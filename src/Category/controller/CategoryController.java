package Category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Category.action.Action;
import Category.action.CategoryClick;
import Category.action.TestAction;


@WebServlet("*.do")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryController() {
        super();
    }
    
    public void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
    	String getURI = request.getRequestURI();
    	String getContextURI = request.getContextPath();
    	String myDo = getURI.substring(getContextURI.length()+1,getURI.length());  
    	
    	Action action = null;
    	if(myDo.equals("category.do")){
    		action = new CategoryClick();
    		 action.execute(request, response);
    	}else if(myDo.equals("TestAction.do")){
    		action = new TestAction();
    		action.execute(request, response);
    	}
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request,response);
	}
	
	

}
