import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class Test {
	
	
	private static HttpClient client = null;
	private static HttpGet get = null;
	private static HttpResponse res = null;
	private static String url = "http://qt.gtimg.cn/q=sz";
	
	
	
	public static void run() {
		client = new DefaultHttpClient();
		for(int h = 1 ; h <= 700000 ; h++) {
			String gpdm = "";
			if( (h / 100000) > 1) {
				gpdm = url + h;
			} else if ( (h / 10000) > 1) {
				gpdm = url +"0" + h;
			} else if ((h / 1000) > 1) {
				gpdm = url +"00" + h;
			} else if ((h / 100) > 1) {
				gpdm = url +"000" + h;
			} else if ((h / 10) > 1) {
				gpdm = url +"0000" + h;
			} else {
				gpdm = url +"00000" + h;
			}
			get = new HttpGet(gpdm);
			try {
				res = client.execute(get);
			  Scanner sc = new Scanner(res.getEntity().getContent(),"gb2312");
			  while(sc.hasNextLine()) {
				  String str = sc.nextLine();
				  Pattern p = Pattern.compile("\".+\"");
				  Matcher matcher = p.matcher(str);
				  if(matcher.find()) {
					  str = matcher.group().subSequence(1, matcher.group().length()-1).toString();
					  StringTokenizer st = new StringTokenizer(str,"~");
					  int i = 0;
					  while(st.hasMoreElements()) {
						  i++;
						  if(i == 2) {
							  System.out.println(st.nextToken());
							  break;
						  }
							  
						  st.nextToken();
					  }
				  }
			  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		run();
	}

}
