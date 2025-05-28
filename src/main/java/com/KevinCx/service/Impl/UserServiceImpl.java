package com.KevinCx.service.Impl;

import com.KevinCx.domain.constant.UserStatusConstant;
import com.KevinCx.domain.dto.UserDTO;
import com.KevinCx.domain.dto.UserLoginDTO;
import com.KevinCx.domain.pojo.User;
import com.KevinCx.domain.query.UserQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.vo.UserVO;
import com.KevinCx.mapper.UserMapper;
import com.KevinCx.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登录
	 */
	@Override
	public UserVO login(UserLoginDTO userLoginDTO) {
		//在数据库中查询用户信息
		String username = userLoginDTO.getUsername();
		String password = DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes());

		User searchUser = userMapper.selectByName(username);
		// 没有查到用户或者用户信息有误
		if(searchUser == null || !searchUser.getPassword().equals(password)){
			throw new RuntimeException("用户名或密码错误");
		}
		if(searchUser.getStatus() == UserStatusConstant.USER_STATUS_FROZEN){
			throw new RuntimeException("用户已被禁用");
		}
		//登陆成功
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(searchUser,userVO);
		return userVO;
	}

	/**
	 * 用户注册
	 * @param userDTO
	 */
	@Override
	public void register(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO,user);
		//设置状态
		user.setCreatedTime(LocalDateTime.now());
		user.setUpdatedTime(LocalDateTime.now());
		user.setStatus(UserStatusConstant.USER_STATUS_NORMAL);

		//密码加密
		String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(password);
		//保存用户信息
		try {
			userMapper.insert(user);
		}catch (Exception e){
			throw new RuntimeException("用户名重复,请更改用户名");
		}
	}

	/**
	 * 用户分页查询
	 * @param userQuery
	 * @return
	 */
	@Override
	public PageResult page(UserQuery userQuery) {
		PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
		Page<User> page = userMapper.page(userQuery);

		List<User> result = page.getResult();
		List<UserVO> userVOList = new ArrayList<>();
		for (User user : result) {
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(user,userVO);
			userVOList.add(userVO);
		}

		return new PageResult(page.getTotal(),userVOList);
	}

	/**
	 * 冻结用户
	 * @param id
	 */
	@Override
	public void freezeUser(Long id) {
		User Searchuser = userMapper.selectById(id);
		if(Searchuser == null || Searchuser.getStatus() == UserStatusConstant.USER_STATUS_FROZEN){
			throw new RuntimeException("用户不存在或已被冻结");
		}

		User user = new User();
		user.setId(id);
		user.setStatus(User.STATUS_FROZEN);
		user.setUpdatedTime(LocalDateTime.now());
		user.setDeletedTime(LocalDateTime.now());

		userMapper.updateById(user);
	}

	/**
	 * 解冻用户
	 * @param id
	 */
	@Override
	public void unfreezeUser(Long id) {
		User user = new User();
		user.setId(id);
		user.setStatus(User.STATUS_NORMAL);
		user.setUpdatedTime(LocalDateTime.now());

		userMapper.updateDeletedTime(id);
		userMapper.updateById(user);
	}


}
