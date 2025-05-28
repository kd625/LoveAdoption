package com.KevinCx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	private Long id; // 用户ID，主键
	private String username; // 用户名，唯一
	private String password; // 加密后的密码
	private String email; // 用户邮箱，唯一
	private String phone; // 用户手机号，唯一
	private Integer role; // 用户角色，0表示普通用户，1表示管理员
	private String profilePicture; // 用户头像图片的URL
}
