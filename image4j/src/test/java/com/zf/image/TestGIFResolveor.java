package com.zf.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.zf.image.compose.GIFImage;
import com.zf.image.compose.GIFResolveor;
import com.zf.image.compose.ImageFrame;

public class TestGIFResolveor {

	public static void main(String[] args) throws IOException {



		GIFResolveor resolver = new GIFResolveor() ;
		
		
		InputStream sourceImg = new FileInputStream(new File("C:/Users/Administrator/Desktop/imgs/com.gif")) ;
		GIFImage gifImage = resolver.resolve(sourceImg) ;
		sourceImg.close(); 

		int i = 0 ;
		
		for (int j = 0; j < gifImage.getFrames().size() ; j++) {
			ImageFrame imageFrame = gifImage.getFrames().get(i) ;
			try {

				IOUtils.copy(imageFrame.getImage(), new FileOutputStream(new File("C:/Users/Administrator/Desktop/imgs/com" + j + ".jpg"))) ;
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		

		System.out.println(gifImage.getFrames().size());

		System.out.println(gifImage.getRepeat());
	}

}
