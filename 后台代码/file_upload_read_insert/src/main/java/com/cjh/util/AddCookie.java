package com.cjh.util;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookie {
	public static  void addCookie(String name, String password, String rememberMe,HttpServletResponse response, HttpServletRequest request) throws Exception {  
	        //创建Cookie  
	        Cookie nameCookie=new Cookie("name",URLEncoder.encode(name,"utf-8"));  
	        Cookie pswCookie=new Cookie("pwd",password);  
	          
	        //设置Cookie的父路径  
	        nameCookie.setPath(request.getContextPath()+"/");  
	        pswCookie.setPath(request.getContextPath()+"/");  
	          
	        //获取是否保存Cookie  
	        if(rememberMe==null){//不保存Cookie  
	            nameCookie.setMaxAge(0);  
	            pswCookie.setMaxAge(0);  
	        }else{//保存Cookie的时间长度，单位为秒  
	            nameCookie.setMaxAge(7*24*60*60);  
	            pswCookie.setMaxAge(7*24*60*60);  
	        }  
	        //加入Cookie到响应头  
	        response.addCookie(nameCookie);  
	        response.addCookie(pswCookie);  
	}
}
