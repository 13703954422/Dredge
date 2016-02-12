package com.elements;

import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Element;

/**
 * 获得elements的各种方法 
 * @author chai
 */
public interface Elements {
	
	/**
	 * 根据className获得对应的元素集合
	 * @param content   要解析的内容
	 * @param className  类型名字
	 * @return
	 */
	public org.jsoup.select.Elements SelectElementByclassName(String content,String className); 
	
	/**
	 * 根据className、attr获得content内属性为attr的值
	 * @param content  将要解析的内容
	 * @param className  类型的名字
	 * @param attr  属性名字
	 * @return
	 */
	public Set<String> SelectElementByclassName(String content,String className,String attr);
	
	public List<String> SelectElementByclassNameReturnList(String content,String className,String attr);
	
	
	/**
	 * 根据id获得元素集
	 * @param content 
	 * @param id  元素的id
	 * @return
	 */
	public Element SelectElementByID(String content,String id);
	
	/**
	 * 根据元素的tagName获得元素集
	 * @param content
	 * @param tagName  元素的tagName
	 * @return
	 */
	public org.jsoup.select.Elements SelectElementsByTagName(String content,String tagName);

}
