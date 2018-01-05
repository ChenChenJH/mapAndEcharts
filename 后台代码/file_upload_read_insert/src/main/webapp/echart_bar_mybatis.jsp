<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>无标题文档</title>
 <!-- 引入 ECharts 文件 -->
    <script src="js/echarts.min.js"></script>
</head>

<body>
  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <div id="pie" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var xAxisData = ${cjhBar.xAxisData};
        var bar_seriesData = ${cjhBar.seriesData};
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts_mybatis入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: xAxisData
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: bar_seriesData
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
		
		//饼图
		  var pie = echarts.init(document.getElementById('pie'));
		  var pie_seriesData = ${cjhPie.seriesData};
		  pie.setOption({
			 
			  //设置背景颜色
			 //  backgroundColor: '#2c343c',
			   title: {
                text: '饼图示例',
                textStyle:{
                	color:'	#FF4500'
                 	},
            	},
            	//提示框
            	tooltip:{},

            	//图例
            	legend: {
                	data:['半年产量'],
                	textStyle:{
                		color:'#FF4500'
                 	},
            	},
				//鼠标移上去的出现阴影
				itemStyle: {
					emphasis: {
						shadowBlur: 200,
						shadowColor: 'rgba(0, 0, 0, 0.5)'
					}
				},
				series : [
					{
						name: '半年产量',
						type: 'pie',
						radius: '55%',
						roseType: true,
						data:pie_seriesData
					}
				]
			}) 
    </script>
</body>
</html>
