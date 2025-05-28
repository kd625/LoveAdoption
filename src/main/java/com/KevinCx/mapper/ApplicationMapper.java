package com.KevinCx.mapper;

import com.KevinCx.domain.pojo.Application;
import com.KevinCx.domain.query.ApplicationQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ApplicationMapper {
	/**
	 * 分页查询
	 * @param applicationQuery
	 * @return
	 */
	Page<Application> pageQuery(ApplicationQuery applicationQuery);

	@Insert("insert into application(user_id,animal_id,application_reason,status,review_comments,reviewed_by,application_time,review_time,created_time,updated_time,deleted_time) " +
			"values (#{userId}, #{animalId}, #{applicationReason}, #{status}, #{reviewComments}, #{reviewedBy}, #{applicationTime}, #{reviewTime}, #{createdTime}, #{updatedTime}, #{deletedTime})")
	void add(Application application);

	@Select("select * from application where id = #{id}")
	Application getById(Long id);

	void update(Application application);
}
