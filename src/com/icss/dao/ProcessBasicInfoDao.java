package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.icss.entity.ProcessBasicInfo;

public interface ProcessBasicInfoDao {
	@Select("select * from processbasicinfo where hide=0;")
	@Results({
		@Result(property="type",column="ptId",one=@One(select="com.icss.dao.ProcessTypeDao.findProcessTypeById"))
	})
	public List<ProcessBasicInfo> findProcessALL();
	@Select("select * from processbasicinfo;")
	public List<ProcessBasicInfo> findProcessRealALL();
	@Select("select * from processbasicinfo where ptId=#{ptId} and hide=0;")
	public List<ProcessBasicInfo> findProcessByType(Integer ptId);
	@Insert("insert into processbasicinfo value(default,#{ptId},#{pName},1,#{remarks},default);")
	@Options(useGeneratedKeys = true, keyProperty = "pid", keyColumn = "pid")
	public int insertProcess(ProcessBasicInfo process);
	@Select("select * from processbasicinfo where pid=#{pid};")
	@Results({
		@Result(property="type",column="ptId",one=@One(select="com.icss.dao.ProcessTypeDao.findProcessTypeById"))
	})
	public ProcessBasicInfo findProcessInfoById(Integer pid);
	@Update("update processbasicinfo set hide=1 where pid=#{pid};")
	public int deleteProcessInfoById(Integer pid);
	@Update("update processbasicinfo set pName=#{pName},ptId=#{ptId},remarks=#{remarks} where pid=#{pid};")
	public int updateProcessInfo(ProcessBasicInfo process);
}
