package Customer.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import customer.mapper.C_BoardMapper;



public class C_BoardDAO {
	//ÔøΩÎñõÊπ≤ÔøΩÔøΩÎÑ† ÔøΩÎô£ÔøΩÍΩ©
	private static C_BoardDAO dao;
	private C_BoardDAO(){}
	public static C_BoardDAO getInstance() {
		if(dao==null){
			dao=new C_BoardDAO();
		}
		return dao;
	}
	//?Ñ∏?Öò?å©?Ü†Î¶?
	public SqlSessionFactory getFactory() {
		String resource="mybatis-config.xml";
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}return new SqlSessionFactoryBuilder().build(is);
	}
	//Î¶¨Ïä§?ä∏
	public List<C_Board> list(Search search){
		List<C_Board> list=null;
		SqlSession session = getFactory().openSession();
		try {
			
			list = session.getMapper(C_BoardMapper.class).list(search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}return list;
	}
	//q_Num?ùò ÏµúÎ?Í∞? Íµ¨ÌïòÍ∏?
	public int addQ_Num(){
		SqlSession session = getFactory().openSession();
		
		try {
			if(session.getMapper(C_BoardMapper.class).add()==null){
				return 0;
			}else{
				return session.getMapper(C_BoardMapper.class).add();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			session.close();
		}
		
		
	}
	//Í≥†Í∞ùÎ¨∏Ïùò Í≤åÏãú?åê?óê Í∏? Ï∂îÍ?
	public void insertBoard(C_Board board, int c_num) {
		
		int num = addQ_Num();
		board.setQ_Num(num+1);
		board.setC_Id(getC_Id(c_num));
		System.out.println(board.getQ_Num());
		SqlSession session = getFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(C_BoardMapper.class).insertBoard(board);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	//Í≤åÏãú?åê Í∏? Î™©Î°ù?ùò Í∏??ùò ?†úÎ™©ÏùÑ ?Å¥Î¶??ñà?ùÑ?ïå ?ï¥?ãπ?ïò?äî Í∏??ùò Í∞ùÏ≤¥?ïò?ÇòÎ•? Íµ¨Ìï®.
	public C_Board detailBoard(int q_num) {
		SqlSession session = getFactory().openSession();
		C_Board board = null;
		try {
			board=session.getMapper(C_BoardMapper.class).detailBoard(q_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	public void UpdateBoard(C_Board board) {
		SqlSession session = getFactory().openSession();
		int re =-1;
		try {
			re = session.getMapper(C_BoardMapper.class).updateBoard(board);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	//?Ç≠?†ú
	public void deleteBoard(int q_num) {
		SqlSession session = getFactory().openSession();
		int re =-1;
		try {
			re = session.getMapper(C_BoardMapper.class).deleteBoard(q_num);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	//Í≥†Í∞ù Í≥†Ïú†?ùò Î≤àÌò∏Î•? Í∞?Ïß?Í≥? Í≥†Í∞ù?ùò idÎ•? Íµ¨Ìï®.
	public String getC_Id(int c_num) {
		SqlSession session= getFactory().openSession();
		String c_Id = null;
		try {
			c_Id = session.getMapper(C_BoardMapper.class).getC_Id(c_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}return c_Id;
	}
	//?åìÍ∏? ?Öå?ù¥Î∏îÏóê Í∏? Ï∂îÍ?.
	public void insertAnswer(Answer answer) {
		SqlSession session = getFactory().openSession();
		int as_Num = addAs_Num()+1;
		System.out.println("as_Num : "+as_Num);
		answer.setAs_num(as_Num+"");
		System.out.println("insertAnswer :"+answer);
		int re = -1;
		
		try {
			re = session.getMapper(C_BoardMapper.class).insertAnswer(answer);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	//as_Num?ùò ÏµúÎ?Í∞íÏùÑ Íµ¨Ìï®
	public int addAs_Num() {
		SqlSession session = getFactory().openSession();
		/*String re = null;*/
	
		try {
			if(session.getMapper(C_BoardMapper.class).addAs_Num()==null){
				return 0;
			}else{
				return (session.getMapper(C_BoardMapper.class).addAs_Num());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
				
		
	}
}
