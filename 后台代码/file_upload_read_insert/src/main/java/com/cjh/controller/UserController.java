package com.cjh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cjh.entity.User;
import com.cjh.service.UserService;
import com.cjh.util.ReadExcelRealse;

/**
 * 用来进行txt和excel文件插入信息
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	//txt文件插入
	@RequestMapping("/txtInsert")
	public String txtInsert(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception {
		
		Set<User> users = new LinkedHashSet<User>();
		if (!file.isEmpty()) {
		   BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
		   String str = "";
		   while((str=br.readLine())!=null){
			   String[] strs = str.split(",");
			   users.add(new User(strs[0],strs[1]));
		   }
		   br.close(); 
		   userService.insert(users);
		}
		return "/success.jsp";
	}
	
	//excel文件插入
	@RequestMapping("/excelInsert")
	public String excelInsert(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception {
		Set<User> users = ReadExcelRealse.readExcel(file.getInputStream());
		userService.insert(users);
		return "/success.jsp";
	}
	
	//使用jquery-form插件txt文件插入
	@RequestMapping("/txtInsertAjax")
	@ResponseBody
	public String txtInsertAjax(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception{
		String result = "false";
		if (!file.isEmpty()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			Set<User> users = new LinkedHashSet<User>();
			String str = "";
			while ((str = br.readLine()) != null) {
				String[] strs = str.split(",");
				users.add(new User(strs[0], strs[1]));
			}
			br.close();
			userService.insert(users);
			result = "true";
			}
		return result;
	}
	
}
