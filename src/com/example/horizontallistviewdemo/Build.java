package com.example.horizontallistviewdemo;

public class Build {

	private String buildName;
	private String startTime;
	private String total;
	boolean isHeader;

	public Build(String buildName, String startTime, String total, String sell,
			String currSellNum, boolean isHeader) {
		super();
		this.buildName = buildName;
		this.startTime = startTime;
		this.total = total;
		this.isHeader = isHeader;
		this.sell = sell;
		this.currSellNum = currSellNum;
	}

	public boolean isHeader() {
		return isHeader;
	}

	public void setHeader(boolean isHeader) {
		this.isHeader = isHeader;
	}

	public Build(String buildName, String startTime, String total, String sell,
			String currSellNum) {
		super();
		this.buildName = buildName;
		this.startTime = startTime;
		this.total = total;
		this.sell = sell;
		this.currSellNum = currSellNum;

	}

	private String sell;
	private String currSellNum;

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public String getCurrSellNum() {
		return currSellNum;
	}

	public void setCurrSellNum(String currSellNum) {
		this.currSellNum = currSellNum;
	}

}
