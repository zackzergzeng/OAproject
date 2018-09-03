package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.icss.entity.ProcessType;

public interface ProcessTypeDao {
	@Select("select * from processtype;")
	@Results({
		@Result(property="ptId",column="ptId",id=true),
		@Result(property="ptName",column="ptName"),
		@Result(property="fatherType",column="fatherType"),
		@Result(property="pbi",column="ptId",many=@Many(select="com.icss.dao.ProcessBasicInfoDao.findProcessByType"))
	})
	public List<ProcessType> findProcessTypeAll();
	@Select("select * from processtype where ptId=#{ptId}")
	public ProcessType findProcessTypeById(Integer ptId);
}
