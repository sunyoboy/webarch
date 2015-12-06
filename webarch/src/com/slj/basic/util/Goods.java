package com.slj.basic.util;


import org.springframework.stereotype.Component;

public class Goods implements java.io.Serializable {
	
	private int goodsId;
	
	private String goodsName;
	
	private String goodsmaterial;
	
	private String goodsPackage;
	
	private String goodsLanguage;
	
	private float goodsPrice;
	
	private String goodsCent;
	
	private String goodsScope;
	
	private String goodsPlace;
	
	private String goodsHabitus;
	
	private String sortName;
	

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public int getGoodsId() {
		return this.goodsId;
	}
		
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getGoodsName() {
		return this.goodsName;
	}
		
	public void setGoodsmaterial(String goodsmaterial) {
		this.goodsmaterial = goodsmaterial;
	}
	
	public String getGoodsmaterial() {
		return this.goodsmaterial;
	}
		
	public void setGoodsPackage(String goodsPackage) {
		this.goodsPackage = goodsPackage;
	}
	
	public String getGoodsPackage() {
		return this.goodsPackage;
	}
		
	public void setGoodsLanguage(String goodsLanguage) {
		this.goodsLanguage = goodsLanguage;
	}
	
	public String getGoodsLanguage() {
		return this.goodsLanguage;
	}
		
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	public float getGoodsPrice() {
		return this.goodsPrice;
	}
		
	public void setGoodsCent(String goodsCent) {
		this.goodsCent = goodsCent;
	}
	
	public String getGoodsCent() {
		return this.goodsCent;
	}
		
	public void setGoodsScope(String goodsScope) {
		this.goodsScope = goodsScope;
	}
	
	public String getGoodsScope() {
		return this.goodsScope;
	}
		
	public void setGoodsPlace(String goodsPlace) {
		this.goodsPlace = goodsPlace;
	}
	
	public String getGoodsPlace() {
		return this.goodsPlace;
	}
		
	public void setGoodsHabitus(String goodsHabitus) {
		this.goodsHabitus = goodsHabitus;
	}
	
	public String getGoodsHabitus() {
		return this.goodsHabitus;
	}
		
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	public String getSortName() {
		return this.sortName;
	}

	@Override
	public String toString() {
		return goodsId + " " + goodsName + " " + goodsmaterial;
	}
		
	
}