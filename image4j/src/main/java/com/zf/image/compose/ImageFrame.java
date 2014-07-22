package com.zf.image.compose;

import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * 图片的一帧（用于合成图片） 
 * @author Administrator
 *
 */
public class ImageFrame {

	//延迟显示ms数
	private int delay ;
	
	//图片内容
	private InputStream image ;
	
	public ImageFrame() {}

	public ImageFrame(InputStream image , int delay) {
		this.image = image;
		this.delay = delay;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

}
