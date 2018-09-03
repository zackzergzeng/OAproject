package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.icss.entity.Auditing;

public interface AuditingDao {
	@Insert("insert into Auditing value(default,#{aud_time},#{result},#{remarks},#{process_id},#{step_id},#{user_Id});")//没写完
	public int insertAuditing(Auditing auditing);
	@Select("select * from Auditing where process_id=#{process_id}")
	@Results({
		@Result(property="aud_id",column="aud_id",id=true),
		@Result(property="aud_time",column="aud_time"),
		@Result(property="result",column="result"),
		@Result(property="remarks",column="remarks"),
		@Result(property="process_id",column="process_id"),
		@Result(property="step_id",column="step_id"),
		@Result(property="user_Id",column="user_Id"),
		@Result(property="steps",column="step_id",one=@One(select="com.icss.dao.StepsDao.findStepsById"))
	})
	public List<Auditing> findAuditingByp(Integer process_id);
}
