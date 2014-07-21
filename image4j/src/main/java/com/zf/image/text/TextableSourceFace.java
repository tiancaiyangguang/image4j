package com.zf.image.text;

import java.util.ArrayList;
import java.util.List;

import com.facemake.util.JsonUtil;
import com.facemake.util.StringUtil;
import com.google.gson.reflect.TypeToken;
import com.zf.image.sourceface.SourceFace;

public class TextableSourceFace implements SourceFace{

	public static final String REGIONALS_KEY = "regionals";

	public static final String REGIONALS_SIZE = "regionals_size";

	/* 图像宽度 */
	private int width ;
	/* 图像高度 */
	private int height ;
	/* 描述 */
	private String descripe ;
	/* 该字段只对动态图片有效，表示循环次数 */
	private int repeat ;

	/* 扩展字段（JSON格式） */
	private String attributes ;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	public List<TextRegional> getTextRegionals() {
		List<TextRegional> regionals = new ArrayList<TextRegional>() ;
		if(StringUtil.isNotBlank(attributes)){
			regionals = JsonUtil.getValueWithFXFromJsonString(REGIONALS_KEY,attributes, 
					new TypeToken<List<TextRegional>>(){}) ;
		}
		return regionals;
	}

	public int getTextRegionalsSize() {
		int size = 0 ;
		if(StringUtil.isNotBlank(attributes)){
			Integer sizeInteger = JsonUtil.getValueFromJsonString(REGIONALS_SIZE,attributes, Integer.class) ;
			if(sizeInteger != null){
				size = sizeInteger.intValue() ;
			}
		}
		return size;
	}


}
