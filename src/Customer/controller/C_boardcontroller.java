package Customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.actio.Action;
import customer.actio.ActionForward;
import customer.actio.DeleteAction;
import customer.actio.DetailAction;
import customer.actio.InsertAction;
import customer.actio.ListAction;
import customer.actio.UpdateAction;
import customer.actio.UpdateFormAction;
import customer.model.C_Board;
import customer.model.C_BoardDAO;

/**
 * Servlet implementation class C_boardcontroller
 */
@WebServlet("*.a")
public class C_boardcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public C_boardcontroller() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	/*System.out.println(requestURI);*/
    	String contextPath = request.getContextPath();
		/*System.out.println(contextPath);*/
		String command = requestURI.substring(contextPath.length()+10);
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("listAction.a")){
			action = new ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertAction.a")){
			action = new InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("detailAction.a")){
			action = new DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("updateAction.a")){
			action = new UpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("updateForm.a")){
			action = new UpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("deleteAction.a")){
			action = new DeleteAction();
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
	 
	 /*//����ڰ�? ��û�� �ּ�	
	 String url = request.getRequestURL().toString();
	 System.out.println(url);
	 //DAO��ü����
	 C_BoardDAO dao = C_BoardDAO.getInstance();
	 //list.do�̸�
	 if(url.indexOf("list.do") !=-1){
	 //�Խù� ���? ����	 
	 List<C_Board> list = dao.list();
	 request.setAttribute("list", list);
	 //���� �ּҷ� ������(�ּҰ���, ȭ�� ��ȯ, ������ ����).
	 String page = "/customer/forcustomer.jsp";
	 RequestDispatcher rd = request.getRequestDispatcher(page);
	 rd.forward(request, response);
	 }*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
