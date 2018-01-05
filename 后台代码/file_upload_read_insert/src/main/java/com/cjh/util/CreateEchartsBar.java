package com.cjh.util;

import java.util.List;

import com.cjh.entity.Good;
import com.cjh.pojo.BarEcharts;

public class CreateEchartsBar {
	public static BarEcharts createBar(List<Good> list) throws Exception{
		BarEcharts be = new BarEcharts();
		be.setxAxisData(createxAxisData(list));
		be.setSeriesData(createSeriesData(list));
		return be;
	}
	
	public static String createxAxisData(List<Good> list) throws Exception{
		String str="[";
		for(int i = 0;i<list.size()-1;i++){
			str = str+"'"+list.get(i).getName()+"',";
		}
		str = str+"'"+list.get(list.size()-1).getName()+"'"+"]";
		System.out.println(str);
		return str;
	}
	
	public static String createSeriesData(List<Good> list) throws Exception{
		String str="[";
		for(int i = 0;i<list.size()-1;i++){
			str = str+list.get(i).getNum()+",";
		}
		str = str+list.get(list.size()-1).getNum()+"]";
		System.out.println(str);
		return str;
	}
}
