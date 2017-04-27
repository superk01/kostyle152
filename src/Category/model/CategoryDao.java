package Category.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Category.mapper.CategoryMapper;

public class CategoryDao {
	static CategoryDao dao = new CategoryDao();
	
	public static CategoryDao getDao(){
		return dao;
	}
	
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<Categorysmall> categorysmallSelect(String midnum){
		SqlSession session = getSqlSessionFactory().openSession();
		List<Categorysmall> list = new ArrayList<Categorysmall>();
		try {
			list = session.getMapper(CategoryMapper.class).categorysmallSelect(midnum);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
		
	}


	public List<String> categorymidSelect(String keyword) {
		SqlSession session = getSqlSessionFactory().openSession();
		List<String> list = new ArrayList<String>();
		try {
			list = session.getMapper(CategoryMapper.class).categorymidSelect(keyword);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
		
	}


	public List<Adshoppingmall> getADShoppingmall() {
		List<Adshoppingmall> adsList = new ArrayList<Adshoppingmall>();
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			adsList = session.getMapper(CategoryMapper.class).getADShoppingmall();
			System.out.println(adsList.size());
			return adsList;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return adsList;
	}
	
	

	
	
	/*	
	public void BoardInsertOk(Board board){
		SqlSession session = getSqlSessionFactory().openSession();
		int result = -1;
		try {
			result = session.getMapper(BoardMapper.class).BoardInsert(board);
			if ( result > 0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public int boardMax_id(){
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			if( session.getMapper(BoardMapper.class).boardMax_id() == null){
				return 0;
			}else{
				return session.getMapper(BoardMapper.class).boardMax_id() + 1;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	public List<Board> BoardList(Search search, int startRow){
		SqlSession session = getSqlSessionFactory().openSession();
		List<Board> list = new ArrayList<Board>();		
		try {
			list = session.getMapper(BoardMapper.class).BoardList(new RowBounds(startRow, 2),search);
			return list;	
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}finally{
			session.close();
		}
	}


	public Board selectBoard(int b_id) {
		SqlSession session = getSqlSessionFactory().openSession(); 
		Board board = new Board();
		try {
			board = session.getMapper(BoardMapper.class).selectBoard(b_id);
			return board;
		} catch (Exception e) {
			e.printStackTrace();
			return board;
		}finally{
			session.close();
		}
	}


	public void BoardUpdate(Board board) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			 re = session.getMapper(BoardMapper.class).updateBoard(board);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}


	public int totalBoardCount(Search search) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			 re = session.getMapper(BoardMapper.class).totalBoardCount(search);
			 return re;
				
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}


	public int totalReCount(int b_id) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			 if( session.getMapper(BoardMapper.class).totalReCount(b_id) == null ){
				 return re;	 
			 }else{
				 re = session.getMapper(BoardMapper.class).totalReCount(b_id);
				 return re+1;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}


	public void insertReComment(ReCommentModel recomment) {
		//insertReComment
		SqlSession session = getSqlSessionFactory().openSession();
		int result = -1;
		try {
			result = session.getMapper(BoardMapper.class).insertReComment(recomment);
			if ( result > 0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}


	public List<ReCommentModel> ReCommentList(int b_id) {
		SqlSession session = getSqlSessionFactory().openSession(); 
		List<ReCommentModel> list = new ArrayList<ReCommentModel>();
		try {
			list = session.getMapper(BoardMapper.class).ReCommentList(b_id);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}finally{
			session.close();
		}
		
	}
	
	*/
}
