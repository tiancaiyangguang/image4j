package com.zf.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.facemake.util.JsonUtil;
import com.zf.image.compose.ImageComposeor;
import com.zf.image.compose.ImageFrame;
import com.zf.image.text.TextRegional;
import com.zf.image.text.TextableSourceFace;

public class TestCompose {
	
	
	public TextableSourceFace getTextableSourceFace(){
		TextableSourceFace face = new TextableSourceFace();
		face.setWidth(20);
		face.setHeight(10);
		face.setDescripe("测试");
		
		String attributes = face.getAttributes() ;
		Map<String, Object> attributesMap = JsonUtil.toMap(attributes) ;
		
		List<TextRegional> regionals = face.getTextRegionals() ;
		
		TextRegional r1 = new TextRegional();
		r1.setFontSize(18);
		r1.setFontType("仿宋");
		r1.setFontStyle(Font.PLAIN | Font.ITALIC );
		r1.setPoint(new Point(20, 30));  
		r1.setWidth(15);
		r1.setHight(100);
		r1.setMaxTextSize(3);  
		r1.setColor(Color.red.getRGB());
		

		TextRegional r2 = new TextRegional();
		r2.setFontSize(23);
		r2.setFontType("楷体");
		r2.setFontStyle(Font.BOLD);
		r2.setPoint(new Point(134, 110));  
		r2.setWidth(70);
		r2.setHight(100);
		r2.setMaxTextSize(3);  
		r2.setColor(Color.green.getRGB());
		
		regionals.add(r1);
		regionals.add(r2);
		
		attributesMap.put(TextableSourceFace.REGIONALS_SIZE_KEY, regionals.size()) ;
		attributesMap.put(TextableSourceFace.REGIONALS_KEY, regionals) ;  
		
		attributes = JsonUtil.toJsonString(attributesMap) ;
		
		face.setAttributes(attributes);
		
		return face ;
	}
	

	public InputStream getSourceImage(String imgName){
		try {
			String imgPath = "C:/Users/Administrator/Desktop/" + imgName;
			return new FileInputStream(new File(imgPath)) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	@Test
	public void test() throws IOException{
		
		ImageFrame if1 = new ImageFrame(getSourceImage("11.jpg") , 500) ;
		ImageFrame if2 = new ImageFrame(getSourceImage("22.jpg") , 500) ;
		ImageFrame if3 = new ImageFrame(getSourceImage("33.jpg") , 500) ;
		
		List<ImageFrame> images = new ArrayList<ImageFrame>() ;
		images.add(if1);
		images.add(if2);
		images.add(if3);
		
		ImageComposeor composeor = new ImageComposeor() ;
		
		InputStream result =  composeor.compose(images, 10000) ;
		
		try {
			IOUtils.copy( result, new FileOutputStream(new File("C:/Users/Administrator/git/image4j/image4j/imgs/com.gif"))) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
