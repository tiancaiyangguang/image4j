package com.zf.image.text.maker;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;

import sun.font.FontDesignMetrics;

import com.facemake.util.StringUtil;
import com.zf.image.text.TextRegional;
import com.zf.image.text.TextableSourceFace;

public abstract class AbstractTextableFaceMaker {
	
	public static final String DEFAULT_FONT_NAME = "宋体";
	public static final int DEFAULT_FONT_SIZE = 12 ;

	public abstract InputStream  format( TextableSourceFace sourceFace , InputStream sourceImgStream , List<String> texts);
	
	/**
	 * 从TextRegional中获取定义的Font信息
	 */
	private Font getFontFromRegional( TextRegional textRegional ){
		String fontType = textRegional.getFontType() ;
		int fontSize = textRegional.getFontSize() ;
		if(StringUtil.isBlank(fontType)){
			fontType = AbstractTextableFaceMaker.DEFAULT_FONT_NAME;
		}
		if(fontSize <= 0){
			fontSize = AbstractTextableFaceMaker.DEFAULT_FONT_SIZE ;
		}
		int fontStyle = textRegional.getFontStyle() ;
		return new Font(fontType, fontStyle , fontSize ) ;
	}

	/**
	 * 使用文字渲染图片特定区域
	 * @param image
	 * @param textRegionals
	 * @param texts
	 */
	protected void renderImage(BufferedImage image ,TextableSourceFace sourceFace , List<String> texts){

		List<TextRegional> textRegionals = sourceFace.getTextRegionals() ;
		int regionalsSize = sourceFace.getTextRegionalsSize() ;
		
		if(textRegionals == null ||  regionalsSize <= 0 ){
			return ;
		}

		if(regionalsSize < texts.size()){
			throw new RuntimeException(String.format("文字条数太多，【可编辑区域：%d，文字条数：%d】" + 
					regionalsSize , texts.size()));
		}

		Graphics graph = image.getGraphics() ;
		for (int i = 0; i < texts.size() ; i++) {
			String text = texts.get(i) ;
			if(StringUtil.isBlank(text)){
				continue ;
			}
			
			TextRegional textRegional = textRegionals.get(i) ;
			Font font = getFontFromRegional(textRegional) ;
			graph.setFont(font);
			graph.setColor(new Color(textRegional.getColor()));  
			
			FontMetrics fontMetrics = FontDesignMetrics.getMetrics(font);
			int regionalWidth = textRegional.getWidth() ;
			int fontWidth = fontMetrics.stringWidth(" ") ;
			int fontHeight = fontMetrics.getHeight() ;
			int lineSize = regionalWidth / fontWidth ;
			int rowCount = text.length() % lineSize == 0 ?
					(text.length()) / lineSize : (text.length() / lineSize + 1) ;
			
			
			Point point = textRegional.getPoint() ;
			for (int j = 0; j < rowCount ; j++) {  
				int start =  j * lineSize;
				int end = start + lineSize ;
				if(end > text.length()){
					end = text.length();
				}
				String lineStr = text.substring(start , end) ;
				
				point.y += fontHeight ;  
				
				graph.drawString(lineStr, point.x, point.y); 
			}
			
		}
	}


}
