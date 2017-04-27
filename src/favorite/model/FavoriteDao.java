package favorite.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import favorite.mapper.FavoriteMapper;

public class FavoriteDao {

private static FavoriteDao dao = new FavoriteDao();
	
	public static FavoriteDao getInstance(){
		return dao;
	}
	
	
	public SqlSessionFactory getsqlSessionFactory(){
		String resource = "mybatis-config.xml";
		
		InputStream input = null;
		
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(input); 
	}
	
	
	//listFavorite(insert? λͺ¨λ  Favoriteκ°μ²΄λ₯? listλ‘? λ§λ€?΄? ?΄λ¦Όμ°¨??Όλ‘? ? ? ¬)
		public List<Favorite> listFavorite(int startRow){
			SqlSession sqlSession = getsqlSessionFactory().openSession();
			List<Favorite> list = null;
			try {
				list = sqlSession.getMapper(FavoriteMapper.class).listFavorite(new RowBounds(startRow, 7));
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return list;
		}
	
		
	//CountFavorite(μ΄? κ²μκΈ?? ? μΆλ ₯)
		public int countFavorite(){
			SqlSession sqlSession = getsqlSessionFactory().openSession();
			int re=0;
			try {
				re = sqlSession.getMapper(FavoriteMapper.class).countFavorite();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return re;
		}	
		
	//detailComent
		public Favorite detailComent(String f_num){
			SqlSession sqlSession = getsqlSessionFactory().openSession();
			Favorite favorite = null;
			try{
				favorite = sqlSession.getMapper(FavoriteMapper.class).detailComent(f_num);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return favorite;
		}
		
		
	//updateComent(favorite?? ?΄?Ή κΈ?? μ½λ©?Έ λ²νΌ? ?΄λ¦??λ©? updateForm?? μ½λ©?Έ ?? ₯/?? ?΄ κ°??₯)
		public int updateComent(Favorite favorite){
			SqlSession sqlSession = getsqlSessionFactory().openSession();
			int re=-1;
			try {
				re = sqlSession.getMapper(FavoriteMapper.class).updateComent(favorite);
				if(re>0){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return re;
		}
		
		
	//deleteFavorite(favorite?? ?΄?Ή κΈ?? ?­?  λ²νΌ? ?΄λ¦??λ©? DB?? ?­? ?¨)
		public int deleteFavorite(Favorite favorite){
			SqlSession sqlSession = getsqlSessionFactory().openSession();
			int re=-1;
			try {
				re = sqlSession.getMapper(FavoriteMapper.class).deleteFavorite(favorite);
				if(re>0){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return re;
		}
		
		
	
	
		
		
	
	
}
