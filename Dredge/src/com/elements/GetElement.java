package com.elements;

import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetElement extends AbstractElements {

	@Override
	public Set<String> SelectElementByclassName(String content, String className,
			String attr) {
		return super.SelectElementByclassName(content, className, attr);
	}
	
	

	@Override
	public Element SelectElementByID(String content, String id) {
		return super.SelectElementByID(content, id);
	}

	@Override
	public Elements SelectElementByclassName(String content, String className) {
		return super.SelectElementByclassName(content, className);
	}

	@Override
	public Elements SelectElementsByTagName(String content, String tagName) {
		return super.SelectElementsByTagName(content, tagName);
	}



	@Override
	public List<String> SelectElementByclassNameReturnList(String content,
			String className, String attr) {
		return super.SelectElementByclassNameReturnList(content, className, attr);
	}
	
	
	
	

}
