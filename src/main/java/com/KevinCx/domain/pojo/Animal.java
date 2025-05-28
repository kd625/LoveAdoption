package com.KevinCx.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	//未领养
	public static final Integer ADOPTION_STATUS_UNADOPTED = 0;
	//已领养
	public static final Integer ADOPTION_STATUS_ADOPTED = 1;
	//已删除
	public static final Integer ADOPTION_STATUS_DELETED = 2;

	/**
	 * 动物的唯一标识符。
	 */
	private Long id;

	/**
	 * 动物的名称。
	 */
	private String name;

	/**
	 * 动物的物种，例如 "狗"、"猫"。
	 */
	private String species;

	/**
	 * 动物的年龄，以年为单位。
	 */
	private Integer age;

	/**
	 * 动物的性别，以整数形式存储，用于类似枚举的表示。
	 */
	private Integer gender;

	/**
	 * 动物的描述信息，包括其性格、习性等。
	 */
	private String description;

	/**
	 * 动物当前的健康状况。
	 */
	private String healthStatus;

	/**
	 * 动物的领养状态，0 表示未领养，1 表示已领养，2 表示已删除
	 */
	private Integer adoptionStatus;

	/**
	 * 动物图片的 URL 地址。
	 */
	private String imageUrl;

	/**
	 * 动物记录的创建时间。
	 */
	private LocalDateTime createdTime;

	/**
	 * 动物记录的最后更新时间。
	 */
	private LocalDateTime updatedTime;

	/**
	 * 动物记录的删除时间，若未删除则为 null。
	 */
	private LocalDateTime deletedTime;

	/**
	 * 动物品种的 ID。
	 */
	private Integer breed;
}