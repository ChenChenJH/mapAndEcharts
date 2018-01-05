package com.cjh.util;

import java.util.List;

import com.cjh.entity.Good;
import com.cjh.pojo.PieEcharts;

public class CreateEchartsPie {
	public static PieEcharts createPie(List<Good> list) throws Exception{
		PieEcharts pe = new PieEcharts();
		pe.setSeriesData(createSeriesData(list));
		return pe;
	}
	
	//构造数据
	public static String createSeriesData(List<Good> list) throws Exception{
		StringBuilder str=new StringBuilder("[");
		for(int i = 0;i<list.size();i++){
			//str.append("{value:"+list.get(i).getNum()+", name:'"+list.get(i).getProTime()+"'},");
			str.append("{value:").append(list.get(i).getNum()).append(", name:'")
			.append(list.get(i).getProTime()).append("'},");
		}
		str.append("]");
		System.out.println(str);
		return new String(str);
	}
}
