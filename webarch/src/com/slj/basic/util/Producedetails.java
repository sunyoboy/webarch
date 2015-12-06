package com.slj.basic.util;


import org.springframework.stereotype.Component;

public class Producedetails implements java.io.Serializable {
	
	private int produceId;
	
	private String produceName;
	
	private int sortId;
	
	private int goodsId;
	

	public void setProduceId(int produceId) {
		this.produceId = produceId;
	}
	
	public int getProduceId() {
		return this.produceId;
	}
		
	public void setProduceName(String produceName) {
		this.produceName = produceName;
	}
	
	public String getProduceName() {
		return this.produceName;
	}
		
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	
	public int getSortId() {
		return this.sortId;
	}
		
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public int getGoodsId() {
		return this.goodsId;
	}
		
	
}