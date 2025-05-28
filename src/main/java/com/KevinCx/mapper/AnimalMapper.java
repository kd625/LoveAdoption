package com.KevinCx.mapper;

import com.KevinCx.domain.dto.AnimalDTO;
import com.KevinCx.domain.pojo.Animal;
import com.KevinCx.domain.query.AnimalQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AnimalMapper {
	/**
	 * 插入新的动物信息
	 * @param animal
	 */
	@Insert("INSERT INTO animal " +
			"(name, species, age, gender, description, health_status, adoption_status, image_url, created_time, updated_time, deleted_time, breed) " +
			"VALUES " +
			"(#{name}, #{species}, #{age}, #{gender}, #{description}, #{healthStatus}, #{adoptionStatus}, #{imageUrl}, #{createdTime}, #{updatedTime}, #{deletedTime}, #{breed})")
	void add(Animal animal);

	/**
	 * 根据id查询动物信息
	 * @param id
	 * @return
	 */
	@Select("select id, name, species, age, gender, description, health_status, adoption_status, image_url, created_time, updated_time, deleted_time, breed" +
			" from animal where id = #{id}")
	Animal getById(Long id);

	/**
	 * 根据id修改动物信息
	 * @param animal
	 */
	void putById(Animal animal);


	/**
	 * 分页查询动物信息
	 * @param animalQuery
	 * @return
	 */
	Page<Animal> page(AnimalQuery animalQuery);
}
