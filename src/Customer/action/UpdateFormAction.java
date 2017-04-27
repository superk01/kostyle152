package Customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.C_Board;
import customer.model.C_BoardDAO;

public class UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String num = request.getParameter("q_num");
		int q_num = 0;
		if(num != null){
			q_num = Integer.parseInt(num);
		}
		
		C_BoardDAO dao = C_BoardDAO.getInstance();
		C_Board board = dao.detailBoard(q_num);
		
		request.setAttribute("board", board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("updateForm.jsp");
		return forward;
	}

}
