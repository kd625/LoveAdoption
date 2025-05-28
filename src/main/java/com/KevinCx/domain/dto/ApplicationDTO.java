package com.KevinCx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
	// 主键ID
	private Long id;

	// 用户ID，申请人
	private Long userId;

	// 动物ID，被申请领养的动物
	private Long animalId;

	// 用户填写的申请理由
	private String applicationReason;
}
