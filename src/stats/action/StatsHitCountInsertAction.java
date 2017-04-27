package stats.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stats.model.HitCount;
import stats.model.ShoppingMall;
import stats.model.StatsDao;

public class StatsHitCountInsertAction implements StatsAction{

	@Override
	public StatsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		StatsDao dao = StatsDao.getInstance();
		HitCount hitCount = new HitCount();
		ShoppingMall shoppingMall = new ShoppingMall();
		
		//DB에 넣을 cnt_prdurl 만들기
		String product_no = request.getParameter("product_no");
		String cate_no = request.getParameter("cate_no");
		String display_group = request.getParameter("display_group");
		String shopURI = request.getParameter("shopuri");
		String s_shopurl = shopURI.substring(1,shopURI.length()-1);
		
		System.out.println("succeed making shopURL");
		
		shoppingMall = dao.getSNum(s_shopurl);
		
		System.out.println("get shoppingmall in action "+shoppingMall.getS_sname());
		
		String cnt_prdurl = s_shopurl+"/product/detail.html?"+"product_no="+product_no+"&amp;cate_no="+cate_no+"&amp;display_group="+display_group;
		
		hitCount.setS_num(shoppingMall.getS_num());
		hitCount.setCnt_prdurl(cnt_prdurl);
		hitCount.setC_num("C001");
		
		System.out.println("initial count "+hitCount.getS_num());
		
		dao.insertHitCount(hitCount);
		
		StatsActionForward forward = new StatsActionForward();
		forward.setRedirect(true);
		forward.setPath("hitcountlist.ju");
		return forward;
	
	
	
	
	}
	
	 
	
}
