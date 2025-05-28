package com.KevinCx.domain.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	public static final Integer STATUS_NORMAL = 0; // 正常状态
	public static final Integer STATUS_FROZEN = 1; // 冻结状态
	public static final Integer ROLE_USER = 0; // 用户角色
	public static final Integer ROLE_ADMIN = 1; // 管理员角色

	private Long id; // 用户ID，主键
	private String username; // 用户名，唯一
	private String password; // 加密后的密码
	private String email; // 用户邮箱，唯一
	private String phone; // 用户手机号，唯一
	private Integer role; // 用户角色，0表示普通用户，1表示管理员
	private Integer status; // 用户状态，0表示正常使用，1表示冻结
	private String profilePicture; // 用户头像图片的URL
	private LocalDateTime createdTime; // 用户创建时间
	private LocalDateTime updatedTime; // 最后更新时间
	private LocalDateTime deletedTime; // 软删除时间
}
