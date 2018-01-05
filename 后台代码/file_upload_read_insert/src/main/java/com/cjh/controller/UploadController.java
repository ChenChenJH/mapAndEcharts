package com.cjh.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 用来测试上传文件
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	//普通文件同步上传
	@RequestMapping("/testUpload")
	public String testUpload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception {
			if (!file.isEmpty()) {
				   String path = session.getServletContext().getRealPath("/upload/");  //获取本地存储路径
				   System.out.println(path);
				   String fileName = file.getOriginalFilename();
				   String fileType = fileName.substring(fileName.lastIndexOf(".")); //获取后缀名
				   String newName=new Date().getTime() + fileType;
				   File file2 = new File(path,newName); //新建一个文件
				   file.transferTo(file2);
				}
		return "/success.jsp";
	}
	
	//使用jquery-form插件异步上传文件
	@RequestMapping("/testAjaxUpload")
	@ResponseBody
	public String testAjaxUpload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) {
		String result = "false";
			if (file != null) {
				try{
				   String path = session.getServletContext().getRealPath("/upload/");  //获取本地存储路径
				   String fileName = file.getOriginalFilename();
				   String fileType = fileName.substring(fileName.lastIndexOf(".")); //获取后缀名
				   String newName=new Date().getTime() + fileType;
				   File file2 = new File(path,newName); //新建一个文件
				   file.transferTo(file2);
				}catch(Exception e){
					return "false";
				}
				result = "true";
			}
		return result;
	}
	
	//普通异步请求，表单提交更简便,使用serialize()，不能上传文件
	@RequestMapping("/ajaxSubmit")
	@ResponseBody
	public String ajaxSubmit(String name,String pwd,HttpSession session) {
		System.out.println("名字是:"+name);
		System.out.println("密码是:"+pwd);
		return "true";
	}
	//使用formData
	@RequestMapping("/formDataSubmit")
	@ResponseBody
	public String formDataSubmit(@RequestParam(value = "file", required = false) MultipartFile file,
			String name,String pwd,HttpSession session) {
		System.out.println("名字是:"+name);
		System.out.println("密码是:"+pwd);
		if (!file.isEmpty()) {
			try{
				   String path = session.getServletContext().getRealPath("/upload/");  //获取本地存储路径
				   String fileName = file.getOriginalFilename();
				   String fileType = fileName.substring(fileName.lastIndexOf(".")); //获取后缀名
				   String newName=new Date().getTime() + fileType;
				   File file2 = new File(path,newName); //新建一个文件
				   file.transferTo(file2);
				}catch(Exception e){
					return "false";
			}
		}
		return "true";
	}
}
