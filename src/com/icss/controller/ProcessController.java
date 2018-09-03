package com.icss.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.icss.dao.AttributesDao;
import com.icss.dao.AuditingDao;
import com.icss.dao.IUser_infoDao;
import com.icss.dao.ProcessBasicInfoDao;
import com.icss.dao.ProcessTypeDao;
import com.icss.dao.StepsDao;
import com.icss.dao.UserProcessDao;
import com.icss.entity.Attributes;
import com.icss.entity.Auditing;
import com.icss.entity.ProAttrValue;
import com.icss.entity.ProcessBasicInfo;
import com.icss.entity.ProcessType;
import com.icss.entity.Steps;
import com.icss.entity.UserProcess;
import com.icss.entity.User_info;
import com.icss.service.AttrService;
import com.icss.service.CreateProcessService;
import com.icss.service.UpdateService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class ProcessController {
	@Autowired
	private ProcessBasicInfoDao dao;
	@Autowired
	private AttributesDao adao;
	@Autowired
	private StepsDao sdao;
	@Autowired
	private ProcessTypeDao ptdao;
	@Autowired
	private UserProcessDao updao;
	@Autowired
	private AuditingDao audao;
	@Autowired
	private IUser_infoDao uidao;
	@Autowired
	private AttrService aservice;
	@Autowired
	private CreateProcessService cpservice;
	@Autowired
	private UpdateService updateService;
	@RequestMapping("showprocess")
	@ResponseBody
	public List<ProcessBasicInfo> fun() {
		List<ProcessBasicInfo>plist=dao.findProcessALL();
		return plist;
	}
	@RequestMapping("findalltype")
	@ResponseBody
	public List<ProcessBasicInfo> fun1() {
		List<ProcessBasicInfo>plist=dao.findProcessALL();
		return plist;
	}
	@RequestMapping("addprocess")
	@ResponseBody
	public String fun2(HttpServletRequest request) {
		ProcessBasicInfo p=new ProcessBasicInfo();
		p.setpName(request.getParameter("processName"));
		p.setPtId(Integer.parseInt(request.getParameter("ptId")));
		p.setRemarks(request.getParameter("remarks"));
		dao.insertProcess(p);
		Attributes a=new Attributes();
		a.setAttrname("标题");
		a.setIsmain(1);
		a.setIsmust(1);
		a.setAtype(0);
		a.setPid(p.getPid());
		a.setRemarks("");
		a.setWritetype(0);
		adao.insertAttr(a);
		return "jsp/showprocess";
	}
	@RequestMapping("setpid")
	@ResponseBody
	public boolean fun4(HttpServletRequest request,HttpSession session) {
		String str=request.getParameter("pid");
		Integer pid=Integer.parseInt(str);
		String t=request.getParameter("t");
		session.setAttribute("pid", pid);
		if(t.equals("0")) {
			return true;
		}else if(t.equals("1")) {
			return true;
		}else if(t.equals("2")) {
			ProcessBasicInfo pbi=dao.findProcessInfoById(pid);
			session.setAttribute("upbi", pbi);
			session.setAttribute("isupdate",1);
			return true;
		}else{
			return false;
		}
	}
	@RequestMapping("showattributes")
	@ResponseBody
	public List<Attributes> fun3(HttpSession session) {
		Integer pid=(Integer) session.getAttribute("pid");
		System.out.println(pid);
		List<Attributes> alist=adao.findAttrByPid(pid);
		return alist;
	}
	@RequestMapping("addattr")
	@ResponseBody
	public String fun5(HttpServletRequest request,HttpSession session) {
		Attributes a=new Attributes();
		a.setAttrname(request.getParameter("attrname"));
		a.setWritetype(1);
		a.setAtype(Integer.parseInt(request.getParameter("atype")));
		a.setIsmain(0);
		a.setIsmust(Integer.parseInt(request.getParameter("ismust")));
		a.setRemarks(request.getParameter("remarks"));
		a.setPid((Integer)session.getAttribute("pid"));
		adao.insertAttr(a);
		return "jsp/showprocessattr";
	}
	@RequestMapping("showsteps")
	@ResponseBody
	public List<Steps> fun6(HttpSession session) {
		Integer pid=(Integer) session.getAttribute("pid");
		List<Steps> slist=sdao.findStepsByProcess(pid);
		return slist;
	}
	@RequestMapping("addstep")
	public String fun7(HttpSession session,String step_name,Integer pre_step,Integer positionId) {
		Steps step=new Steps();
		step.setStep_name(step_name);
		step.setPre_step(pre_step);
		step.setPositionId(positionId);
		step.setPid((Integer)session.getAttribute("pid"));
		sdao.insertSteps(step);
		return "jsp/showstep";
	}
	@RequestMapping("changemain")
	public String fun8(Integer attrid,HttpSession session) {
		Integer pid=(Integer) session.getAttribute("pid");
		aservice.changemain(attrid,pid);
		return "jsp/showprocessattr";
	}
	@RequestMapping("showprocesstype")
	@ResponseBody
	public String fun9(HttpSession session) {
		List<ProcessType> ptlist=ptdao.findProcessTypeAll();
		session.setAttribute("ptlist", ptlist);
		return "jsp/startprocess";
	}
	@RequestMapping("showattrform")
	public String fun10(HttpSession session,Integer pid) {
		List<Attributes> alist=adao.findAttrByPid(pid);
		session.setAttribute("alist", alist);
		session.setAttribute("pid", pid);
		return "jsp/adduserprocess";
	}
	@RequestMapping("adduserprocessattr")
	@ResponseBody
	public boolean fun11(HttpSession session,HttpServletRequest request) {
		System.out.println("------------------------------------");
		String obj=request.getParameter("params");
		JSONArray jarr=JSONArray.fromObject(obj);
		List<ProAttrValue> pavlist=new ArrayList<ProAttrValue>();
		for(int j=0;j<jarr.size(); j++) {
			JSONObject jsonJ = jarr.getJSONObject(j);
			ProAttrValue neopav=new ProAttrValue();
			neopav.setAttrid(jsonJ.getInt("id"));
			neopav.setAttr_val(jsonJ.getString("value"));
			pavlist.add(neopav);
		}
		User_info ui=(User_info) session.getAttribute("userNow");
		UserProcess up=new UserProcess();
		up.setPid((Integer)session.getAttribute("pid"));
		up.setTime(new Timestamp(System.currentTimeMillis()));
		up.setUser_id(ui.getUser_Id());
		cpservice.createProcess(pavlist, up);
		List<ProcessType> ptlist=ptdao.findProcessTypeAll();
		session.setAttribute("ptlist", ptlist);
		return true;
	}
	@RequestMapping("showmyprocess")
	@ResponseBody
	public List<UserProcess> fun12(HttpSession session) {
		User_info ui=(User_info) session.getAttribute("userNow");
		//List<UserProcess> uplist=updao.findProcessAll();
		List<UserProcess> uplist=updao.findProcessAllByuid(ui.getUser_Id());
		return uplist;
	}
	@RequestMapping("showmyprocessbypid")
	@ResponseBody
	public List<UserProcess> fun13(Integer pid) {
		List<UserProcess> uplist=updao.findProcessBypid(pid);
		return uplist;
	}
	@RequestMapping("toshowmyprocess")
	public String fun14(HttpSession session) {
		List<ProcessType> ptlist=ptdao.findProcessTypeAll();
		session.setAttribute("ptlist", ptlist);
		System.out.println("finish--------------------------------------------------------------");
		return "jsp/myprocess";
	}
	@RequestMapping("deleteprocessinfo")
	@ResponseBody
	public String fun15(Integer pid) {
		dao.deleteProcessInfoById(pid);
		return "jsp/showprocess";
	}
	@RequestMapping("updateprocessinfo")
	@ResponseBody
	public String fun16(HttpServletRequest request,HttpSession session) {
		Integer pid=(Integer) session.getAttribute("pid");
		ProcessBasicInfo p=new ProcessBasicInfo();
		p.setPid(pid);
		String pName=request.getParameter("processName");
		System.out.println(pName);
		p.setpName(pName);
		p.setPtId(Integer.parseInt(request.getParameter("ptId")));
		p.setRemarks(request.getParameter("remarks"));
		//updateService.updateProcessBasicInfo(p);
		dao.updateProcessInfo(p);
		session.setAttribute("isupdate", 0);
		return "jsp/showprocess";
	}
	@RequestMapping("deletestep")
	@ResponseBody
	public String fun17(Integer step_id) {
		sdao.deleteSteps(step_id);
		return "jsp/showstep";
	}
	@RequestMapping("setstepid")
	@ResponseBody
	public boolean fun18(HttpServletRequest request,HttpSession session) {
		String str=request.getParameter("step_id");
		Integer step_id=Integer.parseInt(str);
		session.setAttribute("step_id", step_id);
		Steps step=sdao.findStepsById(step_id);
		session.setAttribute("step", step);
		session.setAttribute("isupdate", 1);
		return true;
	}
	@RequestMapping("updatestep")
	@ResponseBody
	public String fun18(HttpSession session,HttpServletRequest request) {
		Integer step_id=(Integer) session.getAttribute("step_id");
		Steps step=new Steps();
		step.setStep_id(step_id);
		step.setStep_name(request.getParameter("step_name"));
		step.setPre_step(Integer.parseInt(request.getParameter("pre_step")));
		step.setPositionId(Integer.parseInt(request.getParameter("positionId")));
		step.setPid((Integer)session.getAttribute("pid"));
		updateService.updateStep(step);
		session.setAttribute("isupdate", 0);
		return "jsp/showstep";
	}
	@RequestMapping("deleteattr")
	@ResponseBody
	public String fun19(Integer attrid) {
		adao.deleteAttr(attrid);
		return "jsp/showprocessattr";
	}
	@RequestMapping("setattrid")
	@ResponseBody
	public String fun20(HttpServletRequest request,HttpSession session) {
		String str=request.getParameter("attrid");
		Integer attrid=Integer.parseInt(str);
		session.setAttribute("attrid", attrid);
		Attributes attributes=adao.findAttrById(attrid);
		session.setAttribute("attr", attributes);
		session.setAttribute("isupdate", 1);
		return "jsp/addattr";
	}
	@RequestMapping("updatesattr")
	@ResponseBody
	public String fun21(HttpSession session,HttpServletRequest request) {
		Integer attrid=(Integer) session.getAttribute("attrid");
		Attributes a=new Attributes();
		a.setAttrid(attrid);
		a.setAttrname(request.getParameter("attrname"));
		a.setWritetype(1);
		a.setAtype(Integer.parseInt(request.getParameter("atype")));
		a.setIsmain(0);
		a.setIsmust(Integer.parseInt(request.getParameter("ismust")));
		a.setRemarks(request.getParameter("remarks"));
		a.setPid((Integer)session.getAttribute("pid"));
		updateService.updateAttr(a);
		session.setAttribute("isupdate", 0);
		return "jsp/showprocessattr";
	}
	@RequestMapping("clearsession")
	@ResponseBody
	public String fun22(HttpSession session) {
		session.removeAttribute("upbi");
		session.removeAttribute("attr");
		session.removeAttribute("step");
		session.removeAttribute("isupdate");
		return "";
	}
}
