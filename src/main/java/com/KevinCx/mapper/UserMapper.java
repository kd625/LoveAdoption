package com.KevinCx.mapper;

import com.KevinCx.domain.pojo.User;
import com.KevinCx.domain.query.UserQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	@Select("select * from user where username = #{username}")
	User selectByName(String username);

	/**
	 * 新增用户
	 * @param user
	 */
	@Insert("insert into user (username, password, email, phone, role, status, profile_picture, created_time, updated_time, deleted_time) " +
			"values (#{username}, #{password}, #{email}, #{phone}, #{role}, #{status}, #{profilePicture}, #{createdTime}, #{updatedTime}, #{deletedTime})")
	void insert(User user);

	/**
	 * 根据条件分页查询用户
	 * @param userQuery
	 * @return
	 */
	Page<User> page(UserQuery userQuery);

	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	User selectById(Long id);

	/**
	 * 根据ID更新用户
	 * @param user
	 */
	void updateById(User user);

	/**
	 * 把删除时间设置为空
	 * @param id
	 */
	@Update("update user set deleted_time = null where id = #{id}")
	void updateDeletedTime(Long id);
}
