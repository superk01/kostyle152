package model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

public class C_BoardDAO {
	//싱글톤 패턴
	private static C_BoardDAO dao;
	private C_BoardDAO(){}
	public static C_BoardDAO getInstance() {
		if(dao==null){
			dao=new C_BoardDAO();
		}
		return dao;
	}
	
	public SqlSessionFactory getFactory() {
		String resource="mybatis-config.xml";
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}return new SqlSessionFactoryBuilder().build(is);
	}
	public List<C_Board> list(){
		List<C_Board> list=null;
		SqlSession session = null;
		try {
			session = getFactory().openSession();
			list = session.getMapper(arg0)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
