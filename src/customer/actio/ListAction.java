package customer.actio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.C_Board;
import customer.model.C_BoardDAO;
import customer.model.Search;

public class ListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Search search = new Search();
		String temp = request.getParameter("temp");
		if(temp != null){
			String area = request.getParameter("area");
			System.out.println(area);
			String seachKey = request.getParameter("searchKey");
			search.setArea(area);
			search.setSearchKey("%"+seachKey+"%");
		}
		
		
		C_BoardDAO dao = C_BoardDAO.getInstance();
		List<C_Board> list = dao.list(search);
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/customer/forcustomer.jsp");
		
		
		return forward;
		
	}

}
