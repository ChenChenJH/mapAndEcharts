package com.cjh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjh.entity.Good;
import com.cjh.pojo.BarEcharts;
import com.cjh.pojo.PieEcharts;
import com.cjh.service.GoodService;
import com.cjh.util.CreateEchartsBar;
import com.cjh.util.CreateEchartsPie;

/**
 * 用来测试echarts
 */
@Controller
@RequestMapping("/good")
public class GoodController {
	@Autowired
	private GoodService goodService;
	
	@RequestMapping("/createBar")
	public String createBar(Model model) throws Exception{
		List<Good> list = goodService.selectAll();
		BarEcharts cjhBar = CreateEchartsBar.createBar(list);
		PieEcharts cjhPie = CreateEchartsPie.createPie(list);
		model.addAttribute("cjhBar", cjhBar);
		model.addAttribute("cjhPie", cjhPie);
		return "/echart_bar_mybatis.jsp";
	}
}
