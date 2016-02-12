package com.elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class AbstractElements implements Elements {

	@Override
	public org.jsoup.select.Elements SelectElementByclassName(String content, String className) {
		Document doc = Jsoup.parse(content);
		return doc.getElementsByClass(className);
	}

	@Override
	public Set<String> SelectElementByclassName(String content, String className,
			String attr) {
		Set<String> set = new HashSet<String>();
		Document doc = Jsoup.parse(content);
		org.jsoup.select.Elements elements = doc.getElementsByClass(className);
		for (Element element :  elements) {
			set.add(element.attr(attr));
		}
		if(set.size() == 0)
			return null;
		else
			return set;
	}

	@Override
	public Element SelectElementByID(String content, String id) {
		Document doc = Jsoup.parse(content);
		return doc.getElementById(id);
		
	}

	@Override
	public org.jsoup.select.Elements SelectElementsByTagName(String content,
			String tagName) {
		Document doc = Jsoup.parse(content);
		return  doc.getElementsByTag(tagName);
	}

	@Override
	public List<String> SelectElementByclassNameReturnList(String content,
			String className, String attr) {
		List<String> list = new ArrayList<String>();
		Document doc = Jsoup.parse(content);
		org.jsoup.select.Elements elements = doc.getElementsByClass(className);
		for (Element element :  elements) {
			list.add(element.attr(attr));
		}
		if(list.size() == 0)
			return null;
		else
			return list;
	}
	
	

}
