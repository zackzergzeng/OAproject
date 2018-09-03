package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.icss.entity.User_info;

public interface IUser_infoDao {
	@Select("select * from user_info")
	public List<User_info> findAllUser();
	@Select("select * from user_info where user_Name=#{0} and pwd=#{1}")
	public User_info findUserByName( String user_Name,String pwd);
	/*@Select("select * from user_info where user_Name=#{user_Name} and ")
	public List<User_info> selectUser(User_info user);*/
	@Insert("insert into user_info(user_Id,user_Name,real_Name,sex,pwd,birthday,tel,departMaster) values(default,#{user_Name},#{real_Name},#{sex},#{pwd},#{birthday},#{tel},#{departMaster})")
	public int insertUser(User_info user);
	@Update("update user_info set user_Name=#{user_Name},real_Name=#{real_Name},sex=#{sex},"
			+ "pwd=#{pwd},birthday=#{birthday},tel=#{tel},departMaster=#{departMaster},"
			+ "departId=#{departId},positionId=#{positionId} where user_Id=#{user_Id}")
	public int updateUser(User_info user);
}
