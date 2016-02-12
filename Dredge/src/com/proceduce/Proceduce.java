package com.proceduce;

import java.util.LinkedList;














import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.consumer.Consumer;
import com.elements.GetElement;
import com.model.Href;
import com.pool.Pool;
import com.util.Http;

public class Proceduce implements Runnable {
	
	private String url = null;
	
	private LinkedList<Href> stack = null;
	
	
	private GetElement getElement = null;
	
	public Proceduce(String url) {
		this.url = url;
		stack = new LinkedList<Href>();
		getElement = new GetElement();
	}

	@Override
	public void run() {
		
		String content = Http.doGet(createUrl(url));
		Element ele = getElement.SelectElementByID(content, "zh-topic-side-children-list");
		Elements eles =  ele.getElementsByClass("zm-item-tag");
		for (Element element : eles) {
				Href href = new Href(element.html(), element.attr("href"));
				if(Pool.getInstance().isFull()) {
					synchronized (this) {
						try {
							wait(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				} else {
					synchronized (this) {
						Pool.getInstance().queue(href);
						stack.push(href);
					}
				}
				
				
				
				
		}
		while(!stack.isEmpty()) {
			Href href = stack.pop();
			String c =	Http.doGet(createUrl(href.getHref()));
			Element ele2 = getElement.SelectElementByID(c, "zh-topic-side-children-list");
			if(ele2 == null) {
				continue;
			} else {
				Elements eles2 =  ele2.getElementsByClass("zm-item-tag");
				for (Element element : eles2) {
					Href href2 = new Href(element.html(), element.attr("href"));
					
					if(Pool.getInstance().isFull()) {
						synchronized (this) {
							try {
								wait(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					} else {
						synchronized (this) {
							Pool.getInstance().queue(href2);
							System.out.println("当前元素有"+Pool.getInstance().size());
							stack.push(href2);
						}
					}
					
					
						
				}
				
			}
			
		}
		
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
