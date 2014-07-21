package com.zf.image.text;

import java.util.List;

import com.zf.image.sourceface.SourceFace;

public interface TextableSourceFace extends SourceFace{
	
	/**
	 * 只用于读取
	 * 对返回的Result List的修改不会反映到DB
	 * @return
	 */
	List<TextRegional> getTextRegionals() ;
	
	
	/**
	 * 得到可编辑区域数量
	 * @return
	 */
	int getTextRegionalsSize();

}
