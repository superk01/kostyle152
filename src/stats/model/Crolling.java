package stats.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Crolling {
	
	public static void aaa(){
	List<String> list = new ArrayList<>();	
	try {
        URL url = new URL("http://www.66girls.co.kr/product/list.html?cate_no=233");
        URLConnection con = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String tmp;

        while ((tmp = br.readLine()) != null) {
           list.add(tmp);
           System.out.println(tmp);
        }
        System.out.println("완료");
     } catch (Exception e) {
        e.printStackTrace();
     } 
	}
	
	public static void main(String[] args) {
		aaa();
		
	}

}
