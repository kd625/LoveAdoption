package com.KevinCx.service;

import com.KevinCx.domain.dto.UserDTO;
import com.KevinCx.domain.dto.UserLoginDTO;
import com.KevinCx.domain.pojo.User;
import com.KevinCx.domain.query.UserQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.vo.UserVO;

public interface IUserService {

	UserVO login(UserLoginDTO userLoginDTO);

	void register(UserDTO userDTO);

	PageResult page(UserQuery userQuery);

	void freezeUser(Long id);

	void unfreezeUser(Long id);
}
