package com.zf.image.compose;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.madgag.gif.fmsware.GifDecoder;

/**
 * 用于解析GIF动画
 * @author Administrator
 *
 */
public class GIFResolveor {

	public GIFImage resolve(InputStream source){
		GIFImage gifImage = new GIFImage() ;
		if(source == null){
			return gifImage ;
		}

		List<ImageFrame> frames = new ArrayList<ImageFrame>() ;
		GifDecoder gifDecoder = new GifDecoder() ;
		gifDecoder.read(source) ;
		int frameCount = gifDecoder.getFrameCount() ;

		for (int i = 0; i < frameCount ; i++) {
			BufferedImage img = gifDecoder.getFrame(i) ;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try {
				ImageIO.write(img, "jpg", bos) ;
			} catch (IOException e) {
				e.printStackTrace();
			}
			frames.add(new ImageFrame(new ByteArrayInputStream(bos.toByteArray()), gifDecoder.getDelay(i))) ; 
		}
		
		gifImage.setFrames(frames);
		gifImage.setRepeat(gifDecoder.getLoopCount()); 
		return gifImage ;

	}
	
}
