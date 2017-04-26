package customer.actio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.actio.Action;
import customer.actio.ActionForward;
import customer.model.Answer;
import customer.model.C_Board;
import customer.model.C_BoardDAO;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C_BoardDAO dao = C_BoardDAO.getInstance();
		String num = request.getParameter("q_num");
		System.out.println(num);
		int q_num =0;
		if(num!=null){
			q_num = Integer.parseInt(num);
		}
		System.out.println(q_num);
		C_Board board = dao.detailBoard(q_num);
		request.setAttribute("board", board);
		
		String as_content = request.getParameter("as_content");
		String as_writer = request.getParameter("as_writer");
		Answer answer = new Answer();
		
		answer.setAc_Content(as_content);
		
		dao.insertAnwer(answer);
		ActionForward forward =new ActionForward();
		forward.setRedirect(false);
		forward.setPath("detail.jsp");
		return forward;
	}

}
