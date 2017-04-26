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
	
	
	//listFavorite(insert한 모든 Favorite객체를 list로 만들어서 내림차순으로 정렬)
		public List<Favorite> listFavorite(int startRow){
			SqlSession sqlSession = getsqlSessionFactory().openSession();
			List<Favorite> list = null;
			try {
				list = sqlSession.getMapper(FavoriteMapper.class).listFavorite(new RowBounds(startRow, 5));
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return list;
		}
	
		
	//CountBoard(총 게시글의 수 출력)
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
	
	
	
	
	
}
