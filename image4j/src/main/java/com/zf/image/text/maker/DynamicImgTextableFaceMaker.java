package com.zf.image.text.maker;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.madgag.gif.fmsware.GifDecoder;
import com.zf.image.text.TextableSourceFace;

/**
 * 动态图片加入文字格式化处理
 * @author Administrator
 *
 */
public class DynamicImgTextableFaceMaker extends AbstractTextableFaceMaker {

	public InputStream format(TextableSourceFace sourceFace, InputStream sourceImgStream,
			List<String> texts) {
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
		AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
		gifEncoder.start(bos) ;
		gifEncoder.setRepeat(sourceFace.getRepeat());

		GifDecoder gifDecoder = new GifDecoder() ;
		gifDecoder.read(sourceImgStream) ;

		int frameCount = gifDecoder.getFrameCount() ;

		for (int i =  0 ;i < frameCount ;i++) {

			BufferedImage imageFrame = gifDecoder.getFrame(i);

			//渲染图片
			renderImage(  imageFrame , sourceFace ,texts);  

			gifEncoder.setDelay(gifDecoder.getDelay(i));  

			gifEncoder.addFrame(imageFrame);

		}
		gifEncoder.finish() ;
		return new ByteArrayInputStream(bos.toByteArray()) ;
	}

}
