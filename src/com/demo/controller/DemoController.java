package com.demo.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.demo.pojo.User;
import com.demo.service.DemoService;


@Controller
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	@Qualifier("demoService")
	private DemoService demoService;
	
	/**
	 * @param 用户名和密码
	 * @return 数据库中符合条件的数据条数
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public Map<String,Object> login(@RequestBody Map<String, Object> param){
		System.out.println("login.do");
		return demoService.login(param);
	}
	
	@RequestMapping("/loginForm.do")
	@ResponseBody
	public void loginForm(@RequestBody HttpServletRequest request,User user){
		System.out.println(user);
		System.out.println("loginForm.do");
//		String uname=request.getParameter("uname");
//		String pwd=request.getParameter("pwd");
//		System.out.println(uname+","+pwd);
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("uname", uname);
//		map.put("pwd",pwd);
//		return demoService.login(map);
	}
	
	
	@RequestMapping("/register.do")
	@ResponseBody
	public int register(@RequestBody Map<String, Object> param){
		return demoService.register(param);
	}
	
	@RequestMapping("/encrypt.do")
	@ResponseBody
	public Map<String, Object> enctypt(@RequestBody Map<String, Object> param){
		return demoService.encrypt(param);
	}
	
	
	@RequestMapping("/decrypt.do")
	@ResponseBody
	public Map<String, Object> decrypt(@RequestBody Map<String, Object> param){
		return demoService.decrypt(param);
	}
	
	@RequestMapping("/isUserExists.do")
	@ResponseBody
	public int isUserExists(@RequestBody Map<String, Object> param){
		return demoService.isUserExists(param);
	}
	
	

}
