package stats.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stats.model.HitCount;
import stats.model.StatsDao;

public class StatsHitCountListAction implements StatsAction{

	@Override
	public StatsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StatsDao dao = StatsDao.getInstance();
		List<HitCount> list = dao.listHitCount();
		request.setAttribute("list", list);
		
		StatsActionForward forward = new StatsActionForward();
		forward.setRedirect(false);
		forward.setPath("/stats/hitcountlist.jsp");
		
		return forward;
	}
	
}
