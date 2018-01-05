package com.cjh.util;

import java.util.List;

import com.cjh.entity.Good;
import com.cjh.pojo.BarEcharts;

public class CreateEchartsBar{
	public static BarEcharts createBar(List<Good> list) throws Exception{
		BarEcharts be = new BarEcharts();
		be.setxAxisData(createxAxisData(list));
		be.setSeriesData(createSeriesData(list));
		return be;
	}
	
	//构造横坐标数据
	public static String createxAxisData(List<Good> list) throws Exception{
		StringBuilder str=new StringBuilder("[");
		for(int i = 0;i<list.size();i++){
			//str.append("'"+list.get(i).getName()+"',");
			str.append("'").append(list.get(i).getName()).append("',");
		}
		str.append("]");
		System.out.println(str);
		return new String(str);
	}
	//构造数据
	public static String createSeriesData(List<Good> list) throws Exception{
		StringBuilder str=new StringBuilder("[");
		for(int i = 0;i<list.size();i++){
			//str.append(list.get(i).getNum()+",");
			str.append(list.get(i).getNum()).append(",");
		}
		str.append("]");
		System.out.println(str);
		return new String(str);
	}

}
