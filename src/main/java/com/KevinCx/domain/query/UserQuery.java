package com.KevinCx.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery extends PageQuery{
	private String username; // 用户名，唯一
	private String email; // 用户邮箱，唯一
	private String phone; // 用户手机号，唯一
	private Integer role; // 用户角色，0表示普通用户，1表示管理员
	private Integer status; // 用户状态，0表示正常使用，1表示冻结
}
