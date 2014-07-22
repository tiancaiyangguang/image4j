package com.zf.image.compose;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import com.madgag.gif.fmsware.AnimatedGifEncoder;

/**
 * 合成静态图片工具
 * @author Administrator
 *
 */
public class ImageComposeor {
	
	/**
	 * 合成静态图片为动态图片
	 * @param frames 静态图片列表
	 * @param repeat 循环次数
	 * @return
	 */
	public InputStream compose(List<ImageFrame> frames, int repeat){
		if(frames == null || frames.size() <= 0){
			return null ;
		}
		ByteArrayOutputStream outImg = new ByteArrayOutputStream() ;
		AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
		gifEncoder.start(outImg) ;
		gifEncoder.setRepeat(repeat);
		
		for (int i = 0; i < frames.size(); i++) {
			ImageFrame frame = frames.get(i) ;
			int delay = frame.getDelay() ;
			BufferedImage frameImg = null;
			try {
				frameImg = ImageIO.read(frame.getImage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(frameImg == null){
				continue ;
			}
			gifEncoder.setDelay(delay); ;
			gifEncoder.addFrame(frameImg) ;
		}
		gifEncoder.finish() ;
		return new ByteArrayInputStream(outImg.toByteArray()) ;
	}

}
