package com.yto.pac.sync;

import java.util.Date;

import com.yto.pac.pojo.HeaderData;
import com.yto.pac.pojo.OrderData;

public class RetryEntity {
	private OrderData data;
	private Date updateTime;
	private Integer times;
	private HeaderData header;
	public OrderData getData() {
		return data;
	}
	public void setData(OrderData data) {
		this.data = data;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public HeaderData getHeader() {
		return header;
	}
	public void setHeader(HeaderData header) {
		this.header = header;
	}
	
	
}
