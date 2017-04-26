package customer.actio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;

import customer.model.C_Board;
import customer.model.C_BoardDAO;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		C_BoardDAO dao = C_BoardDAO.getInstance();
		C_Board board = new C_Board();
		String num =request.getParameter("q_num");
		
		int q_num = 0;
		if(num != null){
			q_num = Integer.parseInt(num);
		}
		String q_title = request.getParameter("title");
		String q_content = request.getParameter("content");
		
		System.out.println(q_num);
		System.out.println(q_title);
		System.out.println(q_content);
		
		board.setQ_Num(q_num);
		board.setQ_Title(q_title);
		board.setQ_Content(q_content);
		
		dao.insertBoard(board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("listAction.a");
		
		return forward;
		
	}

}
