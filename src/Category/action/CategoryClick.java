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
		
		List<Categorysmall> keywordList = new ArrayList<Categorysmall>(); //?€?? ???₯ λ¦¬μ€?Έ
		List<Categorysmall> onesave = new ArrayList<Categorysmall>(); //??λΆλ₯?Ό? ??λ‘? ?€?? ???₯?΄? ?€? ?€?? λ¦¬μ€?Έ? ?κ²¨μ€?Ό?¨
		List<String> midnumList = new ArrayList<String>(); //μ€λΆλ₯? ?€?? λ²νΈ ???₯
		
		
		//?€?? κ΅¬λΆ
		int keywordInt = Integer.parseInt(keyword);
		if( keywordInt % 100 == 0){ 
			//??λΆλ₯ ?€?? μ²λ¦¬
			midnumList = dao.categorymidSelect(keyword);
			for(int i=0; i<midnumList.size(); i++){
				onesave = dao.categorysmallSelect(midnumList.get(i));
				for(int j=0; j<onesave.size(); j++){
					keywordList.add(onesave.get(j));
				}
			} 
		}else{
			//?λΆλ₯ ?€?? κ΅¬λΆ
			keywordList = dao.categorysmallSelect(keyword);
		}
		
		//?€??λ₯? String λ¦¬μ€?Έλ‘? λ³??
		List<String> strkeywordList = new ArrayList<String>();
		for(int i=0; i<keywordList.size(); i++){
			strkeywordList.add(keywordList.get(i).getCs_name());
		}
		for(int i=0; i<strkeywordList.size(); i++){
			System.out.println(strkeywordList.get(i));
		}
		
		
		
		//κ²???  ?Ό?λͺ? λ¦¬μ€?Έ λ°κΈ°
		List<Adshoppingmall> adsList = new ArrayList<Adshoppingmall>();
		adsList = dao.getADShoppingmall();
	
		for(int searchList = 0; searchList<adsList.size(); searchList++){
			//shorurl = ?? / μΆκ?
			//frontURL = ?? http:// μΆκ? ?? ?€???¨?΄ μΆκ?
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
   //κ²?? λ‘μ§
   public void searchLogic(String shopurl, String frontURL, int pagecount){
	   List<Integer> startLiRowNum = new ArrayList<Integer>(); // λ¬Όν ?? box μ€? λͺ¨μ
	   List<Integer> endLiRowNum = new ArrayList<Integer>(); // λ¬Όν ? box μ€? λͺ¨μ
	   List<String> product_NameList = new ArrayList<String>();
	   List<String> product_PriceList = new ArrayList<String>();
	   List<String> product_LinkList = new ArrayList<String>();
	   List<String> product_ImgLinkList = new ArrayList<String>();
	   List<String> list = new ArrayList<String>();   //??΄μ§?row ???₯
	   
	 //κ²?? ??΄μ§?λ©? λ§μ?λ§? ??΄μ§? ?«? ?­? 
	   if(frontURL.indexOf("&page="+pagecount) != -1){
		   frontURL = frontURL.substring(0, frontURL.length() - 7);
	   }
	   
	   //κ²?? ??΄μ§? μ²λ¦¬
	   pagecount ++;
	   frontURL = frontURL + "&page=" + pagecount;
	   System.out.println("?°κ²? ??΄μ§? : " + frontURL);
	   
	   //??΄μ§? ?°κ²?
	   try {
	         URL url = new URL(frontURL);
	         System.out.println("?°κ²°μ€....");
	         URLConnection con = url.openConnection();
	         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         String tmp;

	         while ((tmp = br.readLine()) != null) {
	            list.add(tmp);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally{
	    	  System.out.println("?λ£?");
	      }
	   
       // λ¬Όν ?? ?? ?κ·? ?Έ?
       String startLI = "<li id";
       String startClass = "xans-record"; // ?Ό?λͺ? λ¬Όν λ°μ€ class ?΄λ¦?

       // λ¬Όν ?? ? ?κ·? ?Έ?
       String endLI = "</li>"; // ?΄κ±? row ? μ²΄κ°?΄ </li>?΄?¬?Ό ??€.

       // λ¬Όν ?? λ°μ€ ??±

       // λ¬Όν λ°λ‘κ°?κΈ? λ§ν¬ ??΄μ§? ?Έ?
       String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };
       String product_NameCheck = "[κ°?-?£]"; // λ¬Όν ?΄λ―Έμ? κ²?? (?κΈ? ??Όλ©? true λ¦¬ν΄)
       int productImgLinkRowNum = 0;// ?΄λ―Έμ? src ?΄κ²¨μ? ?΄ κ²??¬κ²°κ³Ό

       String Not_product_NameCheck = "[^κ°?-?£]"; // λ¬Όν ?΄λ¦? μΆμΆ μ΅λ?κΈΈμ΄ 10, λ¬Όν κΈμ‘??
                                        // ?κΈ? 4κΈ?? ?΄?, λ¬Όν ?€λͺμ? ?κΈ?
                                        // 10? ?΄? ?κΈ? κ²??¬ ??Όλ©?
                                        // falseλ¦¬ν΄
       int productLinkRowNum = 0; // κ²°κ³Όκ°? ???₯

       
       //κ²??? ??? ??? Box??λ‘? λͺ¨μΌκΈ?
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
       
       //κ²??? ???΄ ??? ?¬κ·??¨? μ€μ?
       if(startLiRowNum.size() == 0 && endLiRowNum.size() == 0 ){
    	   System.out.println("-------κ²??? " + (pagecount-1) + " κ°? ??΄μ§? κ²??-------");
    	   return;
       }else if(pagecount == 2){ //?? €? μ΅λ?9??΄μ§?κΉμ?λ§? λ°μ?΄
    	   System.out.println("??΄μ§? μ΄κ³Ό");
    	   return;
       }
       

       


       for (int i = 0; i < startLiRowNum.size(); i++) {
          int startrow = startLiRowNum.get(i);
          int endrow = endLiRowNum.get(i);            
          
          List<String> oneBoxProduct_price = new ArrayList<String>();
          List<String> oneBoxProduct_price_reset = new ArrayList<String>();

          //??Box?? ?°?΄?°λ½κΈ°
          for(int j=startrow; j<endrow; j++){
             String row = list.get(j);
             
            String product_link = ""; //λ¬Όκ±΄ λ§ν¬κ°?
             //λ¬Όκ±΄ ?€λͺκ°
             String product_name = "";//λ¬Όκ±΄ ?΄λ¦κ°
             String product_price = "";//λ¬Όκ±΄ κΈμ‘ κ°?
             String product_ImageLink = "";//λ¬Όκ±΄ ?΄λ―Έμ? λ§ν¬κ°?
             
             //κ°?κ²©μ°ΎκΈ?
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
	              //?κ°μλ¦¬μ€?Έλ₯ΌλΉκ΅ν΄μ€λ³΅κ°μ κ±°νκ³ μ²«λ²μ§Έλ¦¬μ€?Έ????₯
	              fristrowList.removeAll(LastrowList);
	              for(int s=0; s<fristrowList.size(); s++){
	            	  product_price+=fristrowList.get(s);
	              }
	              
	              if(!(product_price.equals(""))){
	            	  oneBoxProduct_price.add(product_price);
	              }
              //κ°?κ²©μ°ΎκΈ°λ
             
             for(int p=0; p<productLink.length; p++){
                int pLinkNum = row.indexOf(productLink[p]);
                
                if( pLinkNum != -1 && row.replaceAll("[^κ°?-?£]","").length() > 0){ //?΄ μ€μ λ§ν¬κ°? ?κ³? ?κΈ??΄ ??Όλ©?                                     
              	 product_name = searchProduct_Name(row);   //?κΈ? κ°? μΆμΆ
                   product_link = searchProduct_Link(row, shopurl); //λ§ν¬ κ°? μΆμΆ
                   product_NameList.add(product_name);
                   product_LinkList.add(product_link);                                
                  
                }else if(row.indexOf(shopurl) != -1){ //λ§μ½? λ§ν¬λ§? ?κ³? ?κΈ??΄ ??Όλ©? ?΄λ―Έμ? λ§ν¬? ??Ό? ?΄λ―Έμ? λ§ν¬ μΆμΆ                    
              	  product_ImageLink= searchImgLink(row, shopurl);      //?? ?΄λ―Έμ? λ§ν¬
                   product_ImgLinkList.add(product_ImageLink);
                }
             }                    
          }           
          //? μΆκ?
          if(oneBoxProduct_price.size() > 0 ){
        	  product_PriceList.add(oneBoxProduct_price.get(oneBoxProduct_price.size()-1)+"?");
        	  oneBoxProduct_price = oneBoxProduct_price_reset;
          }else if(oneBoxProduct_price.size() == 0){
        	  product_PriceList.add("");
          }
       }
       //μ€λ³΅? κ±? κ΅¬λ¬Έ            
       //?΄λ―Έμ?λ§ν¬ μ€λ³΅? κ±?
       List<String> ImgresultList = new ArrayList<String>();
       for (int i = 0; i < product_ImgLinkList.size(); i++) {
           if (!ImgresultList.contains(product_ImgLinkList.get(i))) {
          	 ImgresultList.add(product_ImgLinkList.get(i));
           }
       }
       product_ImgLinkList = ImgresultList;
       
       
     //???΄λ¦? μ€λ³΅? κ±?
       List<String> NameresultList = new ArrayList<String>();
       for (int i = 0; i < product_NameList.size(); i++) {
           if (!NameresultList.contains(product_NameList.get(i))) {
          	 NameresultList.add(product_NameList.get(i));
           }
       }
       product_NameList = NameresultList;
       
       
     //??λ§ν¬ μ€λ³΅? κ±?
       List<String> LinkresultList = new ArrayList<String>();
       for (int i = 0; i < product_LinkList.size(); i++) {
           if (!LinkresultList.contains(product_LinkList.get(i))) {
          	 LinkresultList.add(product_LinkList.get(i));
           }
       }
       product_LinkList = LinkresultList;
       
      
       
       //μ€λ³΅? κ±°νκ³? κ΅¬λ¬Έ μ²λ¦¬
       System.out.println("λ§ν¬ κ°?? : "+product_LinkList.size());
       System.out.println("?΄λ¦κ°―? : " + product_NameList.size());
       System.out.println("κ°?κ²? κ°?? : " + product_PriceList.size());
       System.out.println("?΄λ―Έμ? κ°?? : " + product_ImgLinkList.size());
       System.out.println("κ²??μ€?.......");
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
	//λ¬Όν λ°λ‘κ°?κΈ? λ§ν¬ ??΄μ§? ?Έ??λ©? ?΄λ―Έμ?λ§ν¬ μΆμΆ
    public String searchImgLink(String row, String shopurl){        
    	String pattern[] = {".gif\"",".jpg\"",".png\""};
    	
        int productImgLinkRow = row.indexOf("<img src");        //λ¬Όν λ°λ‘κ°?κΈ°μ? ?· ?΄λ―Έμ? λ§ν¬ μ€λ²?Έ κ°?? Έ?€κΈ?

        String productLinkResult = "";        //λ¬Όν λ°λ‘κ°?κΈ°μ? ?· ?΄λ―Έμ? λ§ν¬ κ°?? Έ?€κΈ?
        if( productImgLinkRow != -1){
           String productLinkRow = row; //ex ) aaaaA<img src = "dddddd">ddd
           String productLinkRow_Frist_Cut = productLinkRow.substring(productImgLinkRow, productLinkRow.length()); //ex) <img src="ddddddd">ddd
           int productLinkRow_End_Cut_Index = -1;
           for(int i=0; i<pattern.length; i++){
        	   if( productLinkRow_Frist_Cut.indexOf(pattern[i]) != -1){
        	   productLinkRow_End_Cut_Index = productLinkRow_Frist_Cut.indexOf(pattern[i])+5; //?κ°? ?λ³? .gif .png .jpg
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
	     
	     String product_name = startRow.replaceAll("[^κ°?-?£]", ""); //?? ?΄λ¦?
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
	                                      
	     String product_link = total_Atag.substring(10, total_Atag.length()-1); //?? λ§ν¬
	     product_link = shopurl + product_link;
	     
	     
	     if(product_link.indexOf("name=") != -1 ){
	    	 product_link = product_link.substring(0, product_link.indexOf("name="));
	     }
	     
	     
	     if(product_link.indexOf("\"") != -1){
	    	 product_link = product_link.substring(0, product_link.length()-2);
	     }
	     
	     //4.25 5:57?? 
	     if(product_link.indexOf("\" class") != -1){
	    	 product_link = product_link.substring(0, product_link.indexOf("\" class"));
	     }
	     
	     return product_link;
   }
    
    //μ΅μ’ ?? λ¦¬μ€?Έμ€? μ€λ³΅κ°? ? κ±?
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
