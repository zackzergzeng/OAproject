package com.icss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.icss.dao.IUser_infoDao;
import com.icss.entity.User_info;
@Controller
public class LoginController {
	@Autowired
	private IUser_infoDao dao;
	@RequestMapping("showUser")
	@ResponseBody
	public List<User_info> fun1() {
		List<User_info> list=dao.findAllUser();
		return list;
	}
	@RequestMapping("insertUser")
	public String fun2(User_info user) {
		System.out.println(user.getPositionId());
		int r=dao.insertUser(user);
		if (r>0) {
			return "jsp/login";
		}else
		{
			return "jsp/register";
		}
	}
	@RequestMapping("login")
	public String fun3(String user_Name,String pwd,HttpSession session,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		 User_info user = dao.findUserByName(user_Name, pwd);
		 session.setAttribute("userNow", user);
		if (user!=null) {
			out.print("<script>alert('登录成功！');window.location.href='myfunc/index.jsp'</script>");
			return "jsp/index";
		}
		else {
			out.print("<script>alert('登录失败！');window.location.href='user/login.jsp'</script>");
			return "jsp/login";
		}
	}
}
