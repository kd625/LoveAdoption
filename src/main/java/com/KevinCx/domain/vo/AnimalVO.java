package com.KevinCx.domain.vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author KevinCx
 * 用于展示动物信息的VO类（给前端）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalVO {
	/**
	 * 动物的唯一标识ID
	 */
	private Long id;
	/**
	 * 动物的名称
	 */
	private String name;
	/**
	 * 动物所属的物种，例如 "狗"、"猫" 等
	 */
	private String species;
	/**
	 * 动物的年龄，单位为年
	 */
	private Integer age;
	/**
	 * 动物的性别，使用整数表示
	 */
	private Integer gender;
	/**
	 * 关于动物的描述信息，如性格、习性等
	 */
	private String description;
	/**
	 * 动物当前的健康状况
	 */
	private String healthStatus;
	/**
	 * 动物的领养状态，0 表示未领养，1 表示已领养
	 */
	private String adoptionStatus;
	/**
	 * 动物图片的URL地址
	 */
	private String imageUrl;
	/**
	 * 动物所属品种的ID
	 */
	private Integer breed;
	/**
	 * 动物信息的创建时间
	 */
	private LocalDateTime createdTime;

}

