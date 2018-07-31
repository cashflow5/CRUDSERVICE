package com.panshi.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.panshi.user.domain.User;

@Mapper
public interface UserMapper {

	@Select("select * from stu where id = #{userId}")
	User getUserById(@Param("userId") Integer userId);
	
	@Select("select * from stu where name like '%${inputName}%' limit #{startIndex},#{limit} ")
	List<User> queryAll(@Param("startIndex")Integer startIndex,
			@Param("limit")Integer limit,
			@Param("inputName")String inputName);
	
	@Select("select count(*) from stu where name like '%${inputName}%' ")
	Integer countAll(@Param("inputName")String inputName);
	
	@Insert("insert into stu (name,sex,city) values (#{user.name},#{user.sex},#{user.city})")
	void save(@Param("user")User user);
	@Delete("delete from stu where id in (${ids})")
	void deleteByIds(@Param("ids")String ids);
	@Update("update stu set name=#{user.name},sex=#{user.sex},city=#{user.city} where id = #{user.id}")
	void update(@Param("user")User user);
	

}
