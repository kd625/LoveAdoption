package com.KevinCx.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 领养申请实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {

	//申请状态（0：待审核，1：通过，2：拒绝，3：已撤回）
	public final static Integer STATUS_WAITING = 0;
	public final static Integer STATUS_PASS = 1;
	public final static Integer STATUS_REJECT = 2;
	public final static Integer STATUS_DELETED = 3;

	// 主键ID
	private Long id;

	// 用户ID，申请人
	private Long userId;

	// 动物ID，被申请领养的动物
	private Long animalId;

	// 用户填写的申请理由
	private String applicationReason;

	// 申请状态（0：待审核，1：通过，2：拒绝，3：已撤回）
	private Integer status;

	// 审核备注，管理员填写的意见
	private String reviewComments;

	// 审核管理员ID
	private Long reviewedBy;

	// 用户提交申请的时间
	private LocalDateTime applicationTime;

	// 审核时间
	private LocalDateTime reviewTime;

	// 记录创建时间
	private LocalDateTime createdTime;

	// 记录更新时间
	private LocalDateTime updatedTime;

	// 软删除时间，标记删除
	private LocalDateTime deletedTime;
}
