package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Http {
	
	static CloseableHttpClient httpclient = null;
	static RequestConfig requestConfig = null;
	
	static {
		 requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
         httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
	}
	
	
	
	
	public static String doGet(String url) {
		
	
		RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
		 CloseableHttpClient   httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		try {  
           // 创建httpget.    
           HttpGet httpget = new HttpGet(url);
           httpget.addHeader("Cookie", "__utma=51854390.1746633699.1445173789.1446440653.1446472421.10;__utmb=51854390.6.10.1446472421;__utmc=51854390;__utmt=1;__utmv=51854390.100--|2=registration_date=20150609=1^3=entry_date=20150609=1;__utmz=51854390.1445258056.4.4.utmcsr=baidu|utmccn=(organic)|utmcmd=organic;_xsrf=45de35bdd5eae2c51d759d792aac067c;_za=e4e7b2ec-c198-40d7-9d80-e5a6c3c53f70;cap_id=\"MjYxNDgyNjQ0MjgyNDk1YjhiOTU5M2ZjOTk0ZWE3NDM=|1446440633|05943c391882880e75ab30a2d59f7a669060c3fc\";q_c1=10737354eaf5448c9c86b693254ed8a3|1445173824000|1445173824000;unlock_ticket=\"QUJBTUh3MkhOUWdYQUFBQVlRSlZUY3YxTmxiZVhkVkg1X21qU01abnNtdmtfNkcxS0wzUnFRPT0=|1446440643|2f124369380f296cacd76dc3c6c00c5cf52493ef\";z_c0=\"QUJBTUh3MkhOUWdYQUFBQVlRSlZUY043WGxadHRma3pPZUtxZUNEM1lqUkRFZHZsWlo2cGdnPT0=|1446440643|ddd9137184d75e79fa597162baa3c84ae50752b8\"");
           httpget.addHeader("Accept-Encoding","gzip, deflate");
           httpget.addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
           httpget.addHeader("Cache-Control","no-cache");
           httpget.addHeader("Connection","keep-alive");
           httpget.addHeader("Content-Type","application/json; charset=UTF-8");
           httpget.addHeader("Referer","http://www.zhihu.com/");
           httpget.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
           // 执行get请求.    
           CloseableHttpResponse response = httpclient.execute(httpget); 
           try {  
               // 获取响应实体    
               HttpEntity entity = response.getEntity();  
               // 打印响应状态    
               if (entity != null) {  
               	return EntityUtils.toString(entity);
               }  
           } finally {  
               response.close();  
           }  
       } catch (ClientProtocolException e) {  
           e.printStackTrace();  
       } catch (ParseException e) {  
           e.printStackTrace();  
       } catch (IOException e) {  
           e.printStackTrace();  
       } 
		return null;
	}
  
   
    /**以utf-8形式读取*/
    public static String doPost(String url,List<NameValuePair> formparams) {
    	return doPost(url, formparams,"UTF-8");
    }
    
    public static String doPost(String url,List<NameValuePair> formparams,String charset) {
    	 RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
         CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
    	// 创建默认的httpClient实例.    
       // CloseableHttpClient httpclient = HttpClients.createDefault(); 
     // 创建httppost    
        HttpPost httppost = new HttpPost(url); 
        httppost.addHeader("Cookie", "__utma=51854390.1746633699.1445173789.1446440653.1446472421.10; expires=Wed, 01 Nov 2017 13:55:43 GMT; path=/; domain=.zhihu.com__utmb=51854390.6.10.1446472421; expires=Mon, 02 Nov 2015 14:25:43 GMT; path=/; domain=.zhihu.com__utmc=51854390; path=/; domain=.zhihu.com__utmt=1; expires=Mon, 02 Nov 2015 14:03:40 GMT; path=/; domain=.zhihu.com__utmv=51854390.100--|2=registration_date=20150609=1^3=entry_date=20150609=1; expires=Wed, 01 Nov 2017 13:55:43 GMT; path=/; domain=.zhihu.com__utmz=51854390.1445258056.4.4.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; expires=Tue, 03 May 2016 01:55:43 GMT; path=/; domain=.zhihu.com_xsrf=45de35bdd5eae2c51d759d792aac067c; expires=Tue, 17 Nov 2015 13:11:16 GMT; path=/; domain=www.zhihu.com_za=e4e7b2ec-c198-40d7-9d80-e5a6c3c53f70; expires=Tue, 17 Oct 2017 13:09:48 GMT; path=/; domain=www.zhihu.comcap_id=\"MjYxNDgyNjQ0MjgyNDk1YjhiOTU5M2ZjOTk0ZWE3NDM=|1446440633|05943c391882880e75ab30a2d59f7a669060c3fc\"; expires=Wed, 02 Dec 2015 05:04:11 GMT; path=/; domain=.zhihu.comq_c1=10737354eaf5448c9c86b693254ed8a3|1445173824000|1445173824000; expires=Wed, 17 Oct 2018 13:10:32 GMT; path=/; domain=.zhihu.comunlock_ticket=\"QUJBTUh3MkhOUWdYQUFBQVlRSlZUY3YxTmxiZVhkVkg1X21qU01abnNtdmtfNkcxS0wzUnFRPT0=|1446440643|2f124369380f296cacd76dc3c6c00c5cf52493ef\"; expires=Mon, 02 Nov 2015 05:33:22 GMT; path=/; domain=.zhihu.comz_c0=\"QUJBTUh3MkhOUWdYQUFBQVlRSlZUY043WGxadHRma3pPZUtxZUNEM1lqUkRFZHZsWlo2cGdnPT0=|1446440643|ddd9137184d75e79fa597162baa3c84ae50752b8\"; expires=Tue, 01 Nov 2016 05:04:22 GMT; path=/; domain=.zhihu.com; HttpOnly");
        httppost.addHeader("Accept-Encoding","gzip, deflate");
        httppost.addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httppost.addHeader("Cache-Control","no-cache");
        httppost.addHeader("Connection","keep-alive");
        httppost.addHeader("Content-Type","application/json; charset=UTF-8");
        httppost.addHeader("Referer","http://www.zhihu.com/");
       /// httppost.addHeader("Referer","http://www.zhihu.com/topics");
        httppost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
        
        UrlEncodedFormEntity uefEntity;
        try {
        	uefEntity = new UrlEncodedFormEntity(formparams, charset);
        	
        	httppost.setEntity(uefEntity);
        	CloseableHttpResponse response = httpclient.execute(httppost);
        	try {
        		// 打印响应状态    
                System.out.println(response.getStatusLine());
        		 HttpEntity entity = response.getEntity(); 
        		 if (entity != null) {  
        			return EntityUtils.toString(entity);
                 }  
        	} finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    	return null;
    }
}
