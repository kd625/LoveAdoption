package com.KevinCx.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 领养表分页查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationQuery extends PageQuery{
	// 用户ID，申请人
	private Integer userId;
	// 动物ID，被申请领养的动物
	private Integer animalId;
	// 申请状态（0：待审核，1：通过，2：拒绝，3：已撤回）
	private Integer status;
}
