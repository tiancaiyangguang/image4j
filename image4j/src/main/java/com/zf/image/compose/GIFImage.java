package com.zf.image.compose;

import java.util.List;

public class GIFImage {
	
	private List<ImageFrame> frames ;
	
	private int repeat ;

	public List<ImageFrame> getFrames() {
		return frames;
	}

	public void setFrames(List<ImageFrame> frames) {
		this.frames = frames;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}


}
