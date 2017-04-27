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
		
		List<Categorysmall> keywordList = new ArrayList<Categorysmall>(); //?��?��?�� ???�� 리스?��
		List<Categorysmall> onesave = new ArrayList<Categorysmall>(); //??분류?��?�� ?��?���? ?��?��?�� ???��?��?�� ?��?�� ?��?��?�� 리스?��?�� ?��겨줘?��?��
		List<String> midnumList = new ArrayList<String>(); //중분�? ?��?��?�� 번호 ???��
		
		
		//?��?��?�� 구분
		int keywordInt = Integer.parseInt(keyword);
		if( keywordInt % 100 == 0){ 
			//??분류 ?��?��?�� 처리
			midnumList = dao.categorymidSelect(keyword);
			for(int i=0; i<midnumList.size(); i++){
				onesave = dao.categorysmallSelect(midnumList.get(i));
				for(int j=0; j<onesave.size(); j++){
					keywordList.add(onesave.get(j));
				}
			} 
		}else{
			//?��분류 ?��?��?�� 구분
			keywordList = dao.categorysmallSelect(keyword);
		}
		
		//?��?��?���? String 리스?���? �??��
		List<String> strkeywordList = new ArrayList<String>();
		for(int i=0; i<keywordList.size(); i++){
			strkeywordList.add(keywordList.get(i).getCs_name());
		}
		for(int i=0; i<strkeywordList.size(); i++){
			System.out.println(strkeywordList.get(i));
		}
		
		
		
		//�??��?�� ?��?���? 리스?�� 받기
		List<Adshoppingmall> adsList = new ArrayList<Adshoppingmall>();
		adsList = dao.getADShoppingmall();
	
		for(int searchList = 0; searchList<adsList.size(); searchList++){
			//shorurl = ?��?�� / 추�?
			//frontURL = ?��?�� http:// 추�? ?��?�� ?��?��?��?��?�� 추�?
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
   //�??�� 로직
   public void searchLogic(String shopurl, String frontURL, int pagecount){
	   List<Integer> startLiRowNum = new ArrayList<Integer>(); // 물품 ?��?�� box �? 모음
	   List<Integer> endLiRowNum = new ArrayList<Integer>(); // 물품 ?�� box �? 모음
	   List<String> product_NameList = new ArrayList<String>();
	   List<String> product_PriceList = new ArrayList<String>();
	   List<String> product_LinkList = new ArrayList<String>();
	   List<String> product_ImgLinkList = new ArrayList<String>();
	   List<String> list = new ArrayList<String>();   //?��?���?row ???��
	   
	 //�??�� ?��?���?�? 마�?�? ?��?���? ?��?�� ?��?��
	   if(frontURL.indexOf("&page="+pagecount) != -1){
		   frontURL = frontURL.substring(0, frontURL.length() - 7);
	   }
	   
	   //�??�� ?��?���? 처리
	   pagecount ++;
	   frontURL = frontURL + "&page=" + pagecount;
	   System.out.println("?���? ?��?���? : " + frontURL);
	   
	   //?��?���? ?���?
	   try {
	         URL url = new URL(frontURL);
	         System.out.println("?��결중....");
	         URLConnection con = url.openConnection();
	         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         String tmp;

	         while ((tmp = br.readLine()) != null) {
	            list.add(tmp);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally{
	    	  System.out.println("?���?");
	      }
	   
       // 물품 ?��?�� ?��?�� ?���? ?��?��
       String startLI = "<li id";
       String startClass = "xans-record"; // ?��?���? 물품 박스 class ?���?

       // 물품 ?��?�� ?�� ?���? ?��?��
       String endLI = "</li>"; // ?���? row ?��체값?�� </li>?��?��?�� ?��?��.

       // 물품 ?��?�� 박스 ?��?��

       // 물품 바로�?�? 링크 ?��?���? ?��?��
       String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };
       String product_NameCheck = "[�?-?��]"; // 물품 ?��미�? �??�� (?���? ?��?���? true 리턴)
       int productImgLinkRowNum = 0;// ?��미�? src ?��겨있?�� ?�� �??��결과

       String Not_product_NameCheck = "[^�?-?��]"; // 물품 ?���? 추출 최�?길이 10, 물품 금액??
                                        // ?���? 4�??�� ?��?��, 물품 ?��명�? ?���?
                                        // 10?�� ?��?�� ?���? �??�� ?��?���?
                                        // false리턴
       int productLinkRowNum = 0; // 결과�? ???��

       
       //�??��?�� ?��?��?�� ?��?��?�� Box?��?���? 모으�?
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
       
       //�??��?�� ?��?��?�� ?��?��?�� ?���??��?�� 중�?
       if(startLiRowNum.size() == 0 && endLiRowNum.size() == 0 ){
    	   System.out.println("-------�??��?�� " + (pagecount-1) + " �? ?��?���? �??��-------");
    	   return;
       }else if(pagecount == 2){ //?��?��?�� 최�?9?��?���?까�?�? 받아?��
    	   System.out.println("?��?���? 초과");
    	   return;
       }
       

       


       for (int i = 0; i < startLiRowNum.size(); i++) {
          int startrow = startLiRowNum.get(i);
          int endrow = endLiRowNum.get(i);            
          
          List<String> oneBoxProduct_price = new ArrayList<String>();
          List<String> oneBoxProduct_price_reset = new ArrayList<String>();

          //?��?��Box?��?�� ?��?��?��뽑기
          for(int j=startrow; j<endrow; j++){
             String row = list.get(j);
             
            String product_link = ""; //물건 링크�?
             //물건 ?��명값
             String product_name = "";//물건 ?��름값
             String product_price = "";//물건 금액 �?
             String product_ImageLink = "";//물건 ?��미�? 링크�?
             
             //�?격찾�?
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
	              //?��개의리스?��를비교해중복값제거하고첫번째리스?��?��???��
	              fristrowList.removeAll(LastrowList);
	              for(int s=0; s<fristrowList.size(); s++){
	            	  product_price+=fristrowList.get(s);
	              }
	              
	              if(!(product_price.equals(""))){
	            	  oneBoxProduct_price.add(product_price);
	              }
              //�?격찾기끝
             
             for(int p=0; p<productLink.length; p++){
                int pLinkNum = row.indexOf(productLink[p]);
                
                if( pLinkNum != -1 && row.replaceAll("[^�?-?��]","").length() > 0){ //?�� 줄에 링크�? ?���? ?���??�� ?��?���?                                     
              	 product_name = searchProduct_Name(row);   //?���? �? 추출
                   product_link = searchProduct_Link(row, shopurl); //링크 �? 추출
                   product_NameList.add(product_name);
                   product_LinkList.add(product_link);                                
                  
                }else if(row.indexOf(shopurl) != -1){ //만약?�� 링크�? ?���? ?���??�� ?��?���? ?��미�? 링크?�� ?��?��?�� ?��미�? 링크 추출                    
              	  product_ImageLink= searchImgLink(row, shopurl);      //?��?�� ?��미�? 링크
                   product_ImgLinkList.add(product_ImageLink);
                }
             }                    
          }           
          //?�� 추�?
          if(oneBoxProduct_price.size() > 0 ){
        	  product_PriceList.add(oneBoxProduct_price.get(oneBoxProduct_price.size()-1)+"?��");
        	  oneBoxProduct_price = oneBoxProduct_price_reset;
          }else if(oneBoxProduct_price.size() == 0){
        	  product_PriceList.add("");
          }
       }
       //중복?���? 구문            
       //?��미�?링크 중복?���?
       List<String> ImgresultList = new ArrayList<String>();
       for (int i = 0; i < product_ImgLinkList.size(); i++) {
           if (!ImgresultList.contains(product_ImgLinkList.get(i))) {
          	 ImgresultList.add(product_ImgLinkList.get(i));
           }
       }
       product_ImgLinkList = ImgresultList;
       
       
     //?��?��?���? 중복?���?
       List<String> NameresultList = new ArrayList<String>();
       for (int i = 0; i < product_NameList.size(); i++) {
           if (!NameresultList.contains(product_NameList.get(i))) {
          	 NameresultList.add(product_NameList.get(i));
           }
       }
       product_NameList = NameresultList;
       
       
     //?��?��링크 중복?���?
       List<String> LinkresultList = new ArrayList<String>();
       for (int i = 0; i < product_LinkList.size(); i++) {
           if (!LinkresultList.contains(product_LinkList.get(i))) {
          	 LinkresultList.add(product_LinkList.get(i));
           }
       }
       product_LinkList = LinkresultList;
       
      
       
       //중복?��거하�? 구문 처리
       System.out.println("링크 �??�� : "+product_LinkList.size());
       System.out.println("?��름갯?�� : " + product_NameList.size());
       System.out.println("�?�? �??�� : " + product_PriceList.size());
       System.out.println("?��미�? �??�� : " + product_ImgLinkList.size());
       System.out.println("�??���?.......");
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
	//물품 바로�?�? 링크 ?��?���? ?��?��?���? ?��미�?링크 추출
    public String searchImgLink(String row, String shopurl){        
    	String pattern[] = {".gif\"",".jpg\"",".png\""};
    	
        int productImgLinkRow = row.indexOf("<img src");        //물품 바로�?기에?�� ?�� ?��미�? 링크 줄번?�� �??��?���?

        String productLinkResult = "";        //물품 바로�?기에?�� ?�� ?��미�? 링크 �??��?���?
        if( productImgLinkRow != -1){
           String productLinkRow = row; //ex ) aaaaA<img src = "dddddd">ddd
           String productLinkRow_Frist_Cut = productLinkRow.substring(productImgLinkRow, productLinkRow.length()); //ex) <img src="ddddddd">ddd
           int productLinkRow_End_Cut_Index = -1;
           for(int i=0; i<pattern.length; i++){
        	   if( productLinkRow_Frist_Cut.indexOf(pattern[i]) != -1){
        	   productLinkRow_End_Cut_Index = productLinkRow_Frist_Cut.indexOf(pattern[i])+5; //?���? ?���? .gif .png .jpg
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
	     
	     String product_name = startRow.replaceAll("[^�?-?��]", ""); //?��?�� ?���?
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
	                                      
	     String product_link = total_Atag.substring(10, total_Atag.length()-1); //?��?�� 링크
	     product_link = shopurl + product_link;
	     
	     
	     if(product_link.indexOf("name=") != -1 ){
	    	 product_link = product_link.substring(0, product_link.indexOf("name="));
	     }
	     
	     
	     if(product_link.indexOf("\"") != -1){
	    	 product_link = product_link.substring(0, product_link.length()-2);
	     }
	     
	     //4.25 5:57?��?��
	     if(product_link.indexOf("\" class") != -1){
	    	 product_link = product_link.substring(0, product_link.indexOf("\" class"));
	     }
	     
	     return product_link;
   }
    
    //최종 ?��?�� 리스?���? 중복�? ?���?
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
