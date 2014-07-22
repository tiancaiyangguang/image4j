package com.zf.image.compose;

import java.awt.image.BufferedImage;

/**
 * 图片的一帧（用于合成图片） 
 * @author Administrator
 *
 */
public class ImageFrame {

	//延迟显示ms数
	private int delay ;
	
	//图片内容
	private BufferedImage image ;
	
	public ImageFrame() {}

	public ImageFrame(BufferedImage image , int delay) {
		this.image = image;
		this.delay = delay;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
