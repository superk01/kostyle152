package customer.actio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.C_Board;
import customer.model.C_BoardDAO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String num = request.getParameter("q_num");
		String q_title = request.getParameter("q_title");
		String q_content = request.getParameter("q_content");
		
		int q_num=0;
		if(num != null){
			q_num = Integer.parseInt(num);
		}
		
		C_Board board = new C_Board();
		board.setQ_Num(q_num);
		board.setQ_Title(q_title);
		board.setQ_Content(q_content);
		C_BoardDAO dao = C_BoardDAO.getInstance();
		dao.UpdateBoard(board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("listAction.a");
		return forward;
	}

}
