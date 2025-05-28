package com.KevinCx.controller;

import com.KevinCx.domain.constant.JwtClaimsConstant;
import com.KevinCx.domain.dto.UserDTO;
import com.KevinCx.domain.dto.UserLoginDTO;
import com.KevinCx.domain.pojo.User;
import com.KevinCx.domain.result.Result;
import com.KevinCx.domain.vo.UserVO;
import com.KevinCx.properties.JwtProperties;
import com.KevinCx.service.IUserService;
import com.KevinCx.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Tag(name = "用户相关接口")
public class UserController {

	@Autowired
	private IUserService iUserService;
	@Autowired
	private JwtProperties jwtProperties;

	@Operation(summary = "用户登录")
	@PostMapping("/login")
	public Result Login(@RequestBody UserLoginDTO userLoginDTO){
		log.info("用户登录");
		try {
			UserVO userVO = iUserService.login(userLoginDTO);

			//登录成功后，生成jwt令牌
			Map<String, Object> claims = new HashMap<>();
			claims.put(JwtClaimsConstant.ID, userVO.getId());
			String token = JwtUtil.createJWT(
					jwtProperties.getUserSecretKey(),
					jwtProperties.getUserTtl(),
					claims);

			log.info("登陆成功，生成的token:{}",token);
			return Result.success();
		}catch (Exception e){
			log.error("登录失败:{}",e.getMessage());
			return Result.error(e.getMessage());
		}
	}

	/**
	 * 用户注册
	 * @param userDTO
	 * @return
	 */
	@Operation(summary = "用户注册")
	@PostMapping("/register")
	public Result register(@RequestBody UserDTO userDTO) {
		log.info("用户注册：{}", userDTO);
		try {
			iUserService.register(userDTO);
			return Result.success();
		} catch (Exception e) {
			log.error("注册失败：{}", e.getMessage());
			return Result.error(e.getMessage());
		}
	}
}
