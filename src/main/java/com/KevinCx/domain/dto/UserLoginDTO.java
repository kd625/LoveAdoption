package com.KevinCx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
	private String username; // 用户名，唯一
	private String password; // 加密后的密码
}
