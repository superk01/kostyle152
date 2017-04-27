package stats.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stats.action.StatsAction;
import stats.action.StatsActionForward;
import stats.action.StatsHitCountInsertAction;
import stats.action.StatsHitCountListAction;

@WebServlet("*.ju")
public class StatsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StatsController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+1);
    	
    	StatsActionForward forward = null;
    	StatsAction action = null;
   	
    	if(command.equals("detail.ju")){
    	action = new StatsHitCountInsertAction();	
    		
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("hitcountlist.ju")){
    		action = new StatsHitCountListAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	    	
    	
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}else{
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    	
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
