package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import com.icss.entity.ProAttrValue;

public interface ProAttrValueDao {
	@Insert("insert into ProAttrValue value(default,#{process_id},#{attrid},#{attr_val});")
	public int insertProAttrValue(ProAttrValue proAttrValue);
	@Select("select * from ProAttrValue where process_id=#{process_id}")
	@Results({
		@Result(property="val_id",column="val_id",id=true),
		@Result(property="process_id",column="process_id"),
		@Result(property="attrid",column="attrid"),
		@Result(property="attr_val",column="attr_val"),
		@Result(property="attributes",column="attrid",one=@One(select="com.icss.dao.AttributesDao.findAttrById"))
	})
	public List<ProAttrValue> findProAttrValueByp(Integer process_id);
}
