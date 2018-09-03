package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.icss.entity.UserProcess;

public interface UserProcessDao {
	@Insert("insert into process(time,pid,user_id) value(#{time},#{pid},#{user_id});")
	@Options(useGeneratedKeys = true, keyProperty = "process_id", keyColumn = "process_id")
	public int insertProcess(UserProcess userProcess);
	@Select("select * from Process;")
	@Results({
		@Result(property="process_id",column="process_id",id=true),
		@Result(property="time",column="time"),
		@Result(property="pid",column="pid"),
		@Result(property="user_id",column="user_id"),
		@Result(property="pbi",column="pid",one=@One(select="com.icss.dao.ProcessBasicInfoDao.findProcessInfoById")),
		@Result(property="pavlist",column="process_id",many=@Many(select="com.icss.dao.ProAttrValueDao.findProAttrValueByp")),
		@Result(property="aulist",column="process_id",many=@Many(select="com.icss.dao.AuditingDao.findAuditingByp"))
	})
	public List<UserProcess> findProcessAll();
	@Select("select * from Process where pid=#{pid};")
	@Results({
		@Result(property="process_id",column="process_id",id=true),
		@Result(property="time",column="time"),
		@Result(property="pid",column="pid"),
		@Result(property="user_id",column="user_id"),
		@Result(property="pbi",column="pid",one=@One(select="com.icss.dao.ProcessBasicInfoDao.findProcessInfoById")),
		@Result(property="pavlist",column="process_id",many=@Many(select="com.icss.dao.ProAttrValueDao.findProAttrValueByp")),
		@Result(property="aulist",column="process_id",many=@Many(select="com.icss.dao.AuditingDao.findAuditingByp"))
	})
	public List<UserProcess> findProcessBypid(Integer pid);
	@Select("select * from Process where user_id=#{user_id};")
	@Results({
		@Result(property="pbi",column="pid",one=@One(select="com.icss.dao.ProcessBasicInfoDao.findProcessInfoById")),
		@Result(property="pavlist",column="process_id",many=@Many(select="com.icss.dao.ProAttrValueDao.findProAttrValueByp")),
		@Result(property="aulist",column="process_id",many=@Many(select="com.icss.dao.AuditingDao.findAuditingByp"))
	})
	public List<UserProcess> findProcessAllByuid(Integer user_id);
	@Select("select * from Process where user_id=#{user_id} and pid=#{pid};")
	@Results({
		@Result(property="pbi",column="pid",one=@One(select="com.icss.dao.ProcessBasicInfoDao.findProcessInfoById")),
		@Result(property="pavlist",column="process_id",many=@Many(select="com.icss.dao.ProAttrValueDao.findProAttrValueByp")),
		@Result(property="aulist",column="process_id",many=@Many(select="com.icss.dao.AuditingDao.findAuditingByp"))
	})
	public List<UserProcess> findProcessAllByuidAndpid(Integer user_id,Integer pid);
}
