package com.KevinCx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
    private Long id;
    /** 动物名称 */
    private String name;
    /** 动物物种 */
    private String species;
    /** 动物年龄 */
    private Integer age;
    /** 动物性别 */
    private Integer gender;
    /** 动物描述信息 */
    private String description;
    /** 健康状况 */
    private String healthStatus;
    /** 领养状态 (0-未领养, 1-已领养) */
    private Integer adoptionStatus;
    /** 动物图片URL */
    private String imageUrl;
    /** 动物品种ID */
    private Integer breed;

}
