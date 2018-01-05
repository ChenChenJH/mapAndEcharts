package com.cjh.pojo;

/**
 *饼图
 */
public class PieEcharts {
	private String titleText; // 标题
	private String legendData; // 图例
	private String seriesName; // 图表名称
	private String seriesType; // 图表类型
	private String seriesData; // 图表数据

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getLegendData() {
		return legendData;
	}

	public void setLegendData(String legendData) {
		this.legendData = legendData;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getSeriesType() {
		return seriesType;
	}

	public void setSeriesType(String seriesType) {
		this.seriesType = seriesType;
	}

	public String getSeriesData() {
		return seriesData;
	}

	public void setSeriesData(String seriesData) {
		this.seriesData = seriesData;
	}

}
