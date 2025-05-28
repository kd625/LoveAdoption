package com.KevinCx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationAdminDTO {
	// 主键ID
	private Long id;

	// 审核备注，管理员填写的意见
	private String reviewComments;


}
