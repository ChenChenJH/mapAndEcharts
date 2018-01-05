package com.cjh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjh.util.AddCookie;
/**
 * 用来处理coolies
 */
@Controller
public class CookiesController {
	@RequestMapping("/login")
	public String login(String name,String password, String rememberMe,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println(rememberMe);
		AddCookie.addCookie(name, password, rememberMe, response, request);
		return "redirect:/success.jsp";
	}
}
