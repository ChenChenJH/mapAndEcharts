package com.cjh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cjh.util.ReadExcelRealse;
/**
 * 用来读取txt和excel文件
 */
@Controller
public class FileReaderController {
	//txt文件读取
	@RequestMapping("/txtReader")
	public String txtReader(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception {
			if (!file.isEmpty()) {
				   BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
				   String str = "";
				   while((str=br.readLine())!=null){
					   String[] strs = str.split(",");
					   System.out.println("学号是:"+strs[0]+",姓名是:"+strs[1]);
				   }
				   br.close();
				}
		return "/success.jsp";
	}
	
	//excel文件读取
	@RequestMapping("/excelReader")
	public String excelReader(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception {
		ReadExcelRealse.readExcel(file.getInputStream());
		return "/success.jsp";
	}
	
	//使用jquery-form插件异步上传文件
	@RequestMapping("/txtReaderAjax")
	@ResponseBody
	public String txtReaderAjax(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception{
		String result = "false";
		if (!file.isEmpty()) {
			   BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			   String str = "";
			   while((str=br.readLine())!=null){
				   System.out.println(str);
			   }
			   br.close();
			   result = "true";
			}
		return result;
	}
	
}
