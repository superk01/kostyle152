package Category.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Category.model.Adshoppingmall;
import Category.model.CategoryDao;
import Category.model.Categorysmall;
import Category.model.Product;


public class CategoryClick implements Action{

	private List<Product> product_list = new ArrayList<Product>();
	   
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao dao = CategoryDao.getDao();
		
		String keyword = request.getParameter("keyword"); 
		
		List<Categorysmall> keywordList = new ArrayList<Categorysmall>(); //?‚¤?›Œ?“œ ???¥ ë¦¬ìŠ¤?Š¸
		List<Categorysmall> onesave = new ArrayList<Categorysmall>(); //??ë¶„ë¥˜?¼?‹œ ?„?‹œë¡? ?‚¤?›Œ?“œ ???¥?•´?„œ ?‹¤?‹œ ?‚¤?›Œ?“œ ë¦¬ìŠ¤?Š¸?— ?„˜ê²¨ì¤˜?•¼?•¨
		List<String> midnumList = new ArrayList<String>(); //ì¤‘ë¶„ë¥? ?‚¤?›Œ?“œ ë²ˆí˜¸ ???¥
		
		
		//?‚¤?›Œ?“œ êµ¬ë¶„
		int keywordInt = Integer.parseInt(keyword);
		if( keywordInt % 100 == 0){ 
			//??ë¶„ë¥˜ ?‚¤?›Œ?“œ ì²˜ë¦¬
			midnumList = dao.categorymidSelect(keyword);
			for(int i=0; i<midnumList.size(); i++){
				onesave = dao.categorysmallSelect(midnumList.get(i));
				for(int j=0; j<onesave.size(); j++){
					keywordList.add(onesave.get(j));
				}
			} 
		}else{
			//?†Œë¶„ë¥˜ ?‚¤?›Œ?“œ êµ¬ë¶„
			keywordList = dao.categorysmallSelect(keyword);
		}
		
		//?‚¤?›Œ?“œë¥? String ë¦¬ìŠ¤?Š¸ë¡? ë³??™˜
		List<String> strkeywordList = new ArrayList<String>();
		for(int i=0; i<keywordList.size(); i++){
			strkeywordList.add(keywordList.get(i).getCs_name());
		}
		for(int i=0; i<strkeywordList.size(); i++){
			System.out.println(strkeywordList.get(i));
		}
		
		
		
		//ê²??ƒ‰?•  ?‡¼?•‘ëª? ë¦¬ìŠ¤?Š¸ ë°›ê¸°
		List<Adshoppingmall> adsList = new ArrayList<Adshoppingmall>();
		adsList = dao.getADShoppingmall();
	
		for(int searchList = 0; searchList<adsList.size(); searchList++){
			//shorurl = ??— / ì¶”ê?
			//frontURL = ?•?— http:// ì¶”ê? ??— ?‚¤?›Œ?“œ?‹¨?–´ ì¶”ê?
			for(int searchKeyList=0; searchKeyList<strkeywordList.size(); searchKeyList++){
				String frontURL = "http://" + adsList.get(searchList).getS_searchurl() + strkeywordList.get(searchKeyList); 
				String shopurl = adsList.get(searchList).getS_shopurl() + "/";	
				searchLogic(shopurl, frontURL, 0);
			}
		}
		HttpSession session = request.getSession();
		if( session.getAttribute("product_list") != null){
			session.removeAttribute("product_list");
		}
		
		session.setAttribute("product_list", product_list);
		response.sendRedirect("main/template.jsp?body=../CategorysearchResult/CategorysearchResult.jsp");
		/*
		RequestDispatcher re = request.getRequestDispatcher("main/template.jsp?body=../CategorysearchResult/CategorysearchResult.jsp");
		re.forward(request, response);
		*/
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
   //ê²??ƒ‰ ë¡œì§
   public void searchLogic(String shopurl, String frontURL, int pagecount){
	   List<Integer> startLiRowNum = new ArrayList<Integer>(); // ë¬¼í’ˆ ?‹œ?‘ box ì¤? ëª¨ìŒ
	   List<Integer> endLiRowNum = new ArrayList<Integer>(); // ë¬¼í’ˆ ? box ì¤? ëª¨ìŒ
	   List<String> product_NameList = new ArrayList<String>();
	   List<String> product_PriceList = new ArrayList<String>();
	   List<String> product_LinkList = new ArrayList<String>();
	   List<String> product_ImgLinkList = new ArrayList<String>();
	   List<String> list = new ArrayList<String>();   //?˜?´ì§?row ???¥
	   
	 //ê²??ƒ‰ ?˜?´ì§?ë©? ë§ˆì?ë§? ?˜?´ì§? ?ˆ«? ?‚­? œ
	   if(frontURL.indexOf("&page="+pagecount) != -1){
		   frontURL = frontURL.substring(0, frontURL.length() - 7);
	   }
	   
	   //ê²??ƒ‰ ?˜?´ì§? ì²˜ë¦¬
	   pagecount ++;
	   frontURL = frontURL + "&page=" + pagecount;
	   System.out.println("?—°ê²? ?˜?´ì§? : " + frontURL);
	   
	   //?˜?´ì§? ?—°ê²?
	   try {
	         URL url = new URL(frontURL);
	         System.out.println("?—°ê²°ì¤‘....");
	         URLConnection con = url.openConnection();
	         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         String tmp;

	         while ((tmp = br.readLine()) != null) {
	            list.add(tmp);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally{
	    	  System.out.println("?™„ë£?");
	      }
	   
       // ë¬¼í’ˆ ?•˜?‚˜ ?‹œ?‘ ?ƒœê·? ?¸?‹
       String startLI = "<li id";
       String startClass = "xans-record"; // ?‡¼?•‘ëª? ë¬¼í’ˆ ë°•ìŠ¤ class ?´ë¦?

       // ë¬¼í’ˆ ?•˜?‚˜ ? ?ƒœê·? ?¸?‹
       String endLI = "</li>"; // ?´ê±? row ? „ì²´ê°’?´ </li>?´?—¬?•¼ ?•œ?‹¤.

       // ë¬¼í’ˆ ?•˜?‚˜ ë°•ìŠ¤ ?ƒ?„±

       // ë¬¼í’ˆ ë°”ë¡œê°?ê¸? ë§í¬ ?˜?´ì§? ?¸?‹
       String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };
       String product_NameCheck = "[ê°?-?£]"; // ë¬¼í’ˆ ?´ë¯¸ì? ê²??ƒ‰ (?•œê¸? ?ˆ?œ¼ë©? true ë¦¬í„´)
       int productImgLinkRowNum = 0;// ?´ë¯¸ì? src ?‹´ê²¨ìˆ?Š” ?—´ ê²??‚¬ê²°ê³¼

       String Not_product_NameCheck = "[^ê°?-?£]"; // ë¬¼í’ˆ ?´ë¦? ì¶”ì¶œ ìµœë?ê¸¸ì´ 10, ë¬¼í’ˆ ê¸ˆì•¡??
                                        // ?•œê¸? 4ê¸?? ?´?•˜, ë¬¼í’ˆ ?„¤ëª…ì? ?•œê¸?
                                        // 10? ?´?•˜ ?•œê¸? ê²??‚¬ ?ˆ?œ¼ë©?
                                        // falseë¦¬í„´
       int productLinkRowNum = 0; // ê²°ê³¼ê°? ???¥

       
       //ê²??ƒ‰?•œ ?•˜?‚˜?˜ ?ƒ?’ˆ?„ Box?˜•?ƒœë¡? ëª¨ìœ¼ê¸?
       for (int i = 0; i < list.size(); i++) {
          String row = list.get(i);
          int startlicheck = -1;
          int startliclasscheck = -1;
          startlicheck = row.indexOf(startLI);
          startliclasscheck = row.indexOf(startClass);

          if (startlicheck != -1 && startliclasscheck != -1) {
             startLiRowNum.add(i);
          } else if (row.trim().equals(endLI) && startLiRowNum.size() > 0) {
             if (startLiRowNum.get(0) < i) {
                endLiRowNum.add(i);
             }
          }            
       }
       
       //ê²??ƒ‰?•œ ?ƒ?’ˆ?´ ?—†?„?•Œ ?¬ê·??•¨?ˆ˜ ì¤‘ì?
       if(startLiRowNum.size() == 0 && endLiRowNum.size() == 0 ){
    	   System.out.println("-------ê²??ƒ‰? " + (pagecount-1) + " ê°? ?˜?´ì§? ê²??ƒ‰-------");
    	   return;
       }else if(pagecount == 2){ //?Š? ¤?„œ ìµœë?9?˜?´ì§?ê¹Œì?ë§? ë°›ì•„?˜´
    	   System.out.println("?˜?´ì§? ì´ˆê³¼");
    	   return;
       }
       

       


       for (int i = 0; i < startLiRowNum.size(); i++) {
          int startrow = startLiRowNum.get(i);
          int endrow = endLiRowNum.get(i);            
          
          List<String> oneBoxProduct_price = new ArrayList<String>();
          List<String> oneBoxProduct_price_reset = new ArrayList<String>();

          //?ƒ?’ˆBox?—?„œ ?°?´?„°ë½‘ê¸°
          for(int j=startrow; j<endrow; j++){
             String row = list.get(j);
             
            String product_link = ""; //ë¬¼ê±´ ë§í¬ê°?
             //ë¬¼ê±´ ?„¤ëª…ê°’
             String product_name = "";//ë¬¼ê±´ ?´ë¦„ê°’
             String product_price = "";//ë¬¼ê±´ ê¸ˆì•¡ ê°?
             String product_ImageLink = "";//ë¬¼ê±´ ?´ë¯¸ì? ë§í¬ê°?
             
             //ê°?ê²©ì°¾ê¸?
            	String pattern = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
               	String price = row.replaceAll(pattern, "");
               	price = price.trim();   	
               	String price2 = price.replaceAll("[0-9]{1,3},[0-9]{1,3}", "");
               	price2 = price2.trim();              
               	List<String> fristrowList = new ArrayList<String>();
               	List<String> LastrowList = new ArrayList<String>();
               	
	              for(int s=0; s<price.length(); s++){
	            	  fristrowList.add(price.substring(s,s+1));
	              }
	              for(int s=0; s<price2.length(); s++){
	            	  LastrowList.add(price2.substring(s,s+1));
	              }
	              //?‘ê°œì˜ë¦¬ìŠ¤?Š¸ë¥¼ë¹„êµí•´ì¤‘ë³µê°’ì œê±°í•˜ê³ ì²«ë²ˆì§¸ë¦¬ìŠ¤?Š¸?—???¥
	              fristrowList.removeAll(LastrowList);
	              for(int s=0; s<fristrowList.size(); s++){
	            	  product_price+=fristrowList.get(s);
	              }
	              
	              if(!(product_price.equals(""))){
	            	  oneBoxProduct_price.add(product_price);
	              }
              //ê°?ê²©ì°¾ê¸°ë
             
             for(int p=0; p<productLink.length; p++){
                int pLinkNum = row.indexOf(productLink[p]);
                
                if( pLinkNum != -1 && row.replaceAll("[^ê°?-?£]","").length() > 0){ //?´ ì¤„ì— ë§í¬ê°? ?ˆê³? ?•œê¸??´ ?ˆ?œ¼ë©?                                     
              	 product_name = searchProduct_Name(row);   //?•œê¸? ê°? ì¶”ì¶œ
                   product_link = searchProduct_Link(row, shopurl); //ë§í¬ ê°? ì¶”ì¶œ
                   product_NameList.add(product_name);
                   product_LinkList.add(product_link);                                
                  
                }else if(row.indexOf(shopurl) != -1){ //ë§Œì•½?— ë§í¬ë§? ?ˆê³? ?•œê¸??´ ?—†?œ¼ë©? ?´ë¯¸ì? ë§í¬?„ ?ˆ?œ¼?‹ˆ ?´ë¯¸ì? ë§í¬ ì¶”ì¶œ                    
              	  product_ImageLink= searchImgLink(row, shopurl);      //?ƒ?’ˆ ?´ë¯¸ì? ë§í¬
                   product_ImgLinkList.add(product_ImageLink);
                }
             }                    
          }           
          //?ˆ ì¶”ê?
          if(oneBoxProduct_price.size() > 0 ){
        	  product_PriceList.add(oneBoxProduct_price.get(oneBoxProduct_price.size()-1)+"?›");
        	  oneBoxProduct_price = oneBoxProduct_price_reset;
          }else if(oneBoxProduct_price.size() == 0){
        	  product_PriceList.add("");
          }
       }
       //ì¤‘ë³µ? œê±? êµ¬ë¬¸            
       //?´ë¯¸ì?ë§í¬ ì¤‘ë³µ? œê±?
       List<String> ImgresultList = new ArrayList<String>();
       for (int i = 0; i < product_ImgLinkList.size(); i++) {
           if (!ImgresultList.contains(product_ImgLinkList.get(i))) {
          	 ImgresultList.add(product_ImgLinkList.get(i));
           }
       }
       product_ImgLinkList = ImgresultList;
       
       
     //?ƒ?’ˆ?´ë¦? ì¤‘ë³µ? œê±?
       List<String> NameresultList = new ArrayList<String>();
       for (int i = 0; i < product_NameList.size(); i++) {
           if (!NameresultList.contains(product_NameList.get(i))) {
          	 NameresultList.add(product_NameList.get(i));
           }
       }
       product_NameList = NameresultList;
       
       
     //?ƒ?’ˆë§í¬ ì¤‘ë³µ? œê±?
       List<String> LinkresultList = new ArrayList<String>();
       for (int i = 0; i < product_LinkList.size(); i++) {
           if (!LinkresultList.contains(product_LinkList.get(i))) {
          	 LinkresultList.add(product_LinkList.get(i));
           }
       }
       product_LinkList = LinkresultList;
       
      
       
       //ì¤‘ë³µ? œê±°í•˜ê³? êµ¬ë¬¸ ì²˜ë¦¬
       System.out.println("ë§í¬ ê°??ˆ˜ : "+product_LinkList.size());
       System.out.println("?´ë¦„ê°¯?ˆ˜ : " + product_NameList.size());
       System.out.println("ê°?ê²? ê°??ˆ˜ : " + product_PriceList.size());
       System.out.println("?´ë¯¸ì? ê°??ˆ˜ : " + product_ImgLinkList.size());
       System.out.println("ê²??ƒ‰ì¤?.......");
       for(int i=0; i<product_LinkList.size(); i++){
    	   if( product_LinkList.size() != product_ImgLinkList.size()){
    		   product_ImgLinkList.add("");
    	   }
       }
       
       for(int i=0; i<product_LinkList.size(); i++){
      	Product pro  = new Product(product_LinkList.get(i), product_NameList.get(i), product_PriceList.get(i), product_ImgLinkList.get(i));
      	product_list.add(pro);
       }
       searchLogic(shopurl, frontURL, pagecount);
   }
	//ë¬¼í’ˆ ë°”ë¡œê°?ê¸? ë§í¬ ?˜?´ì§? ?¸?‹?•˜ë©? ?´ë¯¸ì?ë§í¬ ì¶”ì¶œ
    public String searchImgLink(String row, String shopurl){        
    	String pattern[] = {".gif\"",".jpg\"",".png\""};
    	
        int productImgLinkRow = row.indexOf("<img src");        //ë¬¼í’ˆ ë°”ë¡œê°?ê¸°ì—?„œ ?˜· ?´ë¯¸ì? ë§í¬ ì¤„ë²ˆ?˜¸ ê°?? ¸?˜¤ê¸?

        String productLinkResult = "";        //ë¬¼í’ˆ ë°”ë¡œê°?ê¸°ì—?„œ ?˜· ?´ë¯¸ì? ë§í¬ ê°?? ¸?˜¤ê¸?
        if( productImgLinkRow != -1){
           String productLinkRow = row; //ex ) aaaaA<img src = "dddddd">ddd
           String productLinkRow_Frist_Cut = productLinkRow.substring(productImgLinkRow, productLinkRow.length()); //ex) <img src="ddddddd">ddd
           int productLinkRow_End_Cut_Index = -1;
           for(int i=0; i<pattern.length; i++){
        	   if( productLinkRow_Frist_Cut.indexOf(pattern[i]) != -1){
        	   productLinkRow_End_Cut_Index = productLinkRow_Frist_Cut.indexOf(pattern[i])+5; //?ê°? ?‹ë³? .gif .png .jpg
        	   }
           }
           productLinkResult = productLinkRow_Frist_Cut.substring(12, productLinkRow_End_Cut_Index-1); // <img src="ddddddd">
        }
        return productLinkResult;
    }
    
    public String searchProduct_Name(String row){
	   	 row = row.trim();
	     String start_Atag = "<a href=\"";
	     String end_Atag = "/>";
	     
	     int start_Atag_index = row.indexOf(start_Atag);
	     int end_Atag_index = -1;
	     String startRow = row.substring(start_Atag_index,row.length());
	     end_Atag_index = startRow.indexOf(end_Atag);
	     
	     
	     if(start_Atag_index < end_Atag_index){
	    	 startRow = row.substring(start_Atag_index, end_Atag_index);
	     }
	     
	     String product_name = startRow.replaceAll("[^ê°?-?£]", ""); //?ƒ?’ˆ ?´ë¦?
	     return product_name;
    }
    
    public String searchProduct_Link(String row,String shopurl){
	   	 row = row.trim();
	     String start_Atag = "<a href=\"";
	     String end_Atag = ">";	     	

	     int start_Atag_index = row.indexOf(start_Atag);
	     String startRow = row.substring(start_Atag_index,row.length());
	     int end_Atag_index = startRow.indexOf(end_Atag);

	     String total_Atag = row.substring(start_Atag_index, end_Atag_index);
	                                      
	     String product_link = total_Atag.substring(10, total_Atag.length()-1); //?ƒ?’ˆ ë§í¬
	     product_link = shopurl + product_link;
	     
	     
	     if(product_link.indexOf("name=") != -1 ){
	    	 product_link = product_link.substring(0, product_link.indexOf("name="));
	     }
	     
	     
	     if(product_link.indexOf("\"") != -1){
	    	 product_link = product_link.substring(0, product_link.length()-2);
	     }
	     
	     //4.25 5:57?ˆ˜? •
	     if(product_link.indexOf("\" class") != -1){
	    	 product_link = product_link.substring(0, product_link.indexOf("\" class"));
	     }
	     
	     return product_link;
   }
    
    //ìµœì¢… ?ƒ?’ˆ ë¦¬ìŠ¤?Š¸ì¤? ì¤‘ë³µê°? ? œê±?
    public List<Product> checkProductList(){
        List<Product> result_product = new ArrayList<Product>();
        for (int i = 0; i < product_list.size(); i++) {
            if (!result_product.contains(product_list.get(i))) {
            	result_product.add(product_list.get(i));
            }

        }
        System.out.println(result_product.toString());
        System.out.println(result_product.size());
    	return result_product;
    }
	    
}
