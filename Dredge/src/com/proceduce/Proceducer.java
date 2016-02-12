package com.proceduce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

import com.elements.Elements;
import com.elements.GetElement;
import com.model.Href;
import com.pool.Pool;
import com.util.Http;

public class Proceducer {
	
	
	private String rootTopicsUrl = "http://www.zhihu.com/topic/19776749/organize/entire";
	
	private Elements getElement = null;
	
	public Proceducer() {
		getElement = new GetElement();
	}
	
	/**获得xsrf返回值*/
	public String getXsrfValue() {
		String content = Http.doGet(this.rootTopicsUrl);
		Pattern pattern = Pattern.compile("<input type=\"hidden\" name=\"_xsrf\" value=\"(\\w+)\"/>");
		Matcher matcher = pattern.matcher(content);
		if(matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	
	public void startProceduce() {
		String content = Http.doGet(rootTopicsUrl);
		Element ele = getElement.SelectElementByID(content, "zh-topic-side-children-list");
		org.jsoup.select.Elements eles =  ele.getElementsByClass("zm-item-tag");
		for (Element element : eles) {
			
			synchronized (this) {
				Pool.getInstance().queue(new Href(element.html(), element.attr("href")));
			}
				
			new Thread(new Proceduce(element.attr("href"))).start();
		}
		
		
	}
	
	
	public void getHref(String href) {
		String content = Http.doGet(href);
	}
	
	/**
	 * 生成话题的url
	 * @param topic  从页面中解析出来的topic地址
	 * @return
	 */
	private String createUrl(String topic) {
		StringBuffer sb = new StringBuffer("http://www.zhihu.com");
		sb.append(topic);
		sb.append("/organize/entire");
		return sb.toString();
	}
     
	
	

}
