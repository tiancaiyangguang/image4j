package com.zf.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.zf.image.compose.GIFImage;
import com.zf.image.compose.GIFResolveor;
import com.zf.image.compose.ImageFrame;

public class TestGIFResolveor {

	public static void main(String[] args) throws IOException {



		GIFResolveor resolver = new GIFResolveor() ;
		
		
		InputStream sourceImg = new FileInputStream(new File("D:/imgtest/com.gif")) ;
		GIFImage gifImage = resolver.resolve(sourceImg) ;
		sourceImg.close(); 

		int i = 0 ;
		
		for (int j = 0; j < gifImage.getFrames().size() ; j++) {
			ImageFrame imageFrame = gifImage.getFrames().get(i) ;
			try {
				File dir =  new File("D:/imgtest/") ;
				if(!dir.exists()){
					dir.mkdirs() ;
				}

				File file = new File(dir , "com" + j + ".jpg");
				file.createNewFile() ;

				OutputStream bos = new FileOutputStream( file) ;

				ImageIO.write(imageFrame.getImage(), "jpg", bos) ;
				bos.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		

		System.out.println(gifImage.getFrames().size());

		System.out.println(gifImage.getRepeat());
	}

}
