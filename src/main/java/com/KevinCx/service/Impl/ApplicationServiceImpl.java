package com.KevinCx.service.Impl;

import com.KevinCx.context.BaseContext;
import com.KevinCx.domain.dto.ApplicationAdminDTO;
import com.KevinCx.domain.dto.ApplicationDTO;
import com.KevinCx.domain.pojo.Application;
import com.KevinCx.domain.pojo.User;
import com.KevinCx.domain.query.ApplicationQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.vo.ApplicationVO;
import com.KevinCx.mapper.ApplicationMapper;
import com.KevinCx.mapper.UserMapper;
import com.KevinCx.service.IApplicationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApplicationServiceImpl implements IApplicationService {

	@Autowired
	private ApplicationMapper applicationMapper;
	@Autowired
	private UserMapper userMapper;

	/**
	 * 分页查询
	 * @param applicationQuery
	 */
	@Override
	public PageResult page(ApplicationQuery applicationQuery) {
		PageHelper.startPage(applicationQuery.getPageNum(),applicationQuery.getPageSize());
		Page<Application> page = applicationMapper.pageQuery(applicationQuery);

		return new PageResult(page.getTotal(),page.getResult());
	}

	/**
	 * 新增申请表
	 * @param applicationDTO
	 */
	@Override
	public void add(ApplicationDTO applicationDTO) {
		Application application = new Application();
		applicationDTO.setUserId(BaseContext.getCurrentId());
		BeanUtils.copyProperties(applicationDTO,application);

		//补充属性值
		application.setStatus(Application.STATUS_WAITING);
		application.setApplicationTime(LocalDateTime.now());
		application.setCreatedTime(LocalDateTime.now());

		applicationMapper.add(application);
	}

	/**
	 * 根据ID查询申请信息
	 * @param id
	 * @return
	 */
	@Override
	public ApplicationVO getById(Long id) {
		Application application = applicationMapper.getById(id);
		if(application == null){
			throw new RuntimeException("申请信息不存在");
		}

		ApplicationVO applicationVO = new ApplicationVO();
		BeanUtils.copyProperties(application,applicationVO);

		return applicationVO;
	}

	/**
	 * 根据申请表id删除申请表（软删除)
	 * @param id
	 */
	@Override
	public void delete(Long id) {
		Application application1 = applicationMapper.getById(id);
		if(application1 == null){//申请表不存在
			throw new RuntimeException("申请信息不存在");
		}

		Application application = new Application();
		application.setId(application.getId());
		application.setDeletedTime(LocalDateTime.now());
		application.setUpdatedTime(LocalDateTime.now());
		application.setStatus(Application.STATUS_DELETED);

		applicationMapper.update(application);

	}

	/**
	 * 更新申请表信息
	 * @param applicationDTO
	 * @return
	 */
	@Override
	public ApplicationVO update(ApplicationDTO applicationDTO) {
		Application application = applicationMapper.getById(applicationDTO.getId());
		if(application == null || application.getStatus().equals(Application.STATUS_DELETED)){//申请表不存在
			throw new RuntimeException("申请信息不存在或已删除");
		}
		BeanUtils.copyProperties(applicationDTO,application);
		application.setUpdatedTime(LocalDateTime.now());
		applicationMapper.update(application);
		ApplicationVO applicationVO = new ApplicationVO();
		BeanUtils.copyProperties(application,applicationVO);
		return applicationVO;
	}

	/**
	 * 管理员审核申请
	 * @param applicationAdminDTO
	 */
	@Override
	public void admitApplication(ApplicationAdminDTO applicationAdminDTO) {
		//检查用户是否是管理员
		Long id = BaseContext.getCurrentId();
		User user = userMapper.selectById(id);
		if(!user.getRole().equals(User.ROLE_ADMIN)){
			throw new RuntimeException("用户无权限");
		}

		Application seaechApplication = applicationMapper.getById(applicationAdminDTO.getId());
		if(seaechApplication == null || seaechApplication.getStatus().equals(Application.STATUS_DELETED)){//申请表不存在
			throw new RuntimeException("申请信息不存在或已删除");
		}

		Application application = new Application();
		BeanUtils.copyProperties(applicationAdminDTO,application);
		application.setStatus(Application.STATUS_PASS);
		application.setReviewedBy(BaseContext.getCurrentId());
		application.setReviewTime(LocalDateTime.now());
		application.setUpdatedTime(LocalDateTime.now());

		applicationMapper.update(application);

	}

	/**
	 * 管理员拒绝申请
	 * @param applicationAdminDTO
	 */
	@Override
	public void rejectApplication(ApplicationAdminDTO applicationAdminDTO) {
		Long id = BaseContext.getCurrentId();
		User user = userMapper.selectById(id);
		if(!user.getRole().equals(User.ROLE_ADMIN)){
			throw new RuntimeException("用户无权限");
		}

		Application seaechApplication = applicationMapper.getById(applicationAdminDTO.getId());
		if(seaechApplication == null || seaechApplication.getStatus().equals(Application.STATUS_DELETED)){//申请表不存在
			throw new RuntimeException("申请信息不存在或已删除");
		}

		Application application = new Application();
		BeanUtils.copyProperties(applicationAdminDTO,application);
		application.setStatus(Application.STATUS_REJECT);
		application.setReviewedBy(BaseContext.getCurrentId());
		application.setReviewTime(LocalDateTime.now());
		application.setUpdatedTime(LocalDateTime.now());

		applicationMapper.update(application);
	}


}
