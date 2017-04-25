package model;

import java.io.InputStream;

import org.apache.ibatis.jdbc.SqlBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

import com.ibatis.common.resources.Resources;

public class C_BoardService {
	private static C_BoardService dao;
	private C_BoardService(){}
	public static C_BoardService getInstance() {
		if(dao==null){
			dao=new C_BoardService();
		}
		return dao;
	}
	
}
