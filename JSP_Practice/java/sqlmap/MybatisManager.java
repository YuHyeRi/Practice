package sqlmap;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	
	private static SqlSessionFactory instance;	// SqlSessionFactory : SqlSession 객체 생성
	private MybatisManager() {}					// 외부에서 접속 금지
	
	public static SqlSessionFactory getInstance() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("sqlmap/sqlMapConfig.xml");	// sqlMapConfig.xml : mybatis 설정파일
			instance = new SqlSessionFactoryBuilder().build(reader);	// SqlSessionFactoryBuilder > SqlSessionFactory > SqlSession
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) 
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
