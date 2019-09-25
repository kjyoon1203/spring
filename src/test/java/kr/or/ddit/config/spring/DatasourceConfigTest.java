package kr.or.ddit.config.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource(value = "classpath:kr/or/ddit/config/mybatis/db-test.properties")
@ImportResource("classpath:kr/or/ddit/config/spring/context-transaction.xml")
public class DatasourceConfigTest {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource datasource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(datasource());
		sqlSessionFactory.setConfigLocation(new ClassPathResource("kr/or/ddit/config/mybatis/mybatis-config.xml"));
		return sqlSessionFactory;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() {
		SqlSessionFactory factory = null;
		
		try {
			factory = sqlSessionFactory().getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
				
		return sqlSessionTemplate;		
	}
}
