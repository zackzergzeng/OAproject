package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.icss.entity.Attributes;

public interface AttributesDao {
	@Select("select * from Attributes where pid=#{pid} and hide=0;")
	public List<Attributes> findAttrByPid(Integer pid);
	@Insert("insert into Attributes value(default,#{attrname},#{writetype},#{atype},#{ismain},#{ismust},#{remarks},#{pid},default);")
	public int insertAttr(Attributes attributes);
	@Update("update Attributes set ismain=0 where pid=#{pid} and hide=0;")
	public void updateIsmainZero(Integer pid);
	@Update("update Attributes set ismain=1 where attrid=#{attrid};")
	public void updateIsmainOne(Integer attrid);
	@Select("select * from Attributes where attrid=#{attrid};")
	public Attributes findAttrById(Integer attrid);
	@Update("update Attributes set hide=1 where attrid=#{attrid}")
	public int deleteAttr(Integer attrid);
}
