package stats.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import stats.mapper.StatsMapper;

public class StatsDao {
	private static StatsDao dao = new StatsDao();
	
	public static StatsDao getInstance(){
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
	
	public void insertHitCount(HitCount hitCount) throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;

		System.out.println("insert count "+hitCount.getS_num());
		
		try {
			re = session.getMapper(StatsMapper.class).insertHitCount(hitCount);
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
	
	public List<HitCount> listHitCount() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		List<HitCount> list = null;
		try {
			list = session.getMapper(StatsMapper.class).listHitCount();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public ShoppingMall getSNum(String s_shopurl)throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		ShoppingMall shoppingMall = null;
		
		System.out.println("getsnum in dao -" + s_shopurl+"-");
		
		try {
			shoppingMall = session.getMapper(StatsMapper.class).getSNum(s_shopurl);
			System.out.println("get shoppingMall in dao "+shoppingMall.getS_sname());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return shoppingMall;
	}
	
	
	
}
