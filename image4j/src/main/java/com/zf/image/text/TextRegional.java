package com.zf.image.text;

import java.awt.Color;
import java.awt.Point;

/**
 * 源图中可编辑区域
 * @author Administrator
 */
public class TextRegional {

	private Point point ;
	private int width ;
	private int hight ;
	
	private String fontType ;
	private int fontSize ;
	private int maxTextSize ;
	private int color ;
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public String getFontType() {
		return fontType;
	}

	public void setFontType(String fontType) {
		this.fontType = fontType;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getMaxTextSize() {
		return maxTextSize;
	}

	public void setMaxTextSize(int maxTextSize) {
		this.maxTextSize = maxTextSize;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setRGB(int r , int g , int b){
		this.color = new Color(r, g, b).getRGB() ;
	}
	
}
