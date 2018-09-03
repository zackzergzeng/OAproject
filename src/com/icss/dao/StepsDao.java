package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.icss.entity.Steps;

public interface StepsDao {
	@Select("select * from steps where pid=#{pid} and hide=0")
	public List<Steps> findStepsByProcess(Integer pid);
	@Insert("insert into steps value(default,#{step_name},#{pre_step},#{pid},null,default)")
	public int insertSteps(Steps step);
	@Select("select * from steps where step_id=#{step_id}")
	public Steps findStepsById(Integer step_id);
	@Update("update steps set hide=1 where step_id=#{step_id}")
	public int deleteSteps(Integer step_id);
}
