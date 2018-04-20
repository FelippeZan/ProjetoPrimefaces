package br.com.framework.hibernate.session;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 
 * Responsavel por estabelecer conexão com o hibernate
 * @author felippe
 */ 
public class HibernateUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static String JAVA_COM_ENV_JDBC_DATA_SOURCE="java:comp/env/jdbc/MySQLDataSource";
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * Responsavel por ler o arquivo de configuração hibernate.cfg.xml
	 * @return
	 */
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			
			if(sessionFactory==null) {
				Configuration configuration = new Configuration();
				configuration.configure();
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			}
			
			return sessionFactory;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Erro ao criar conexão SessionFactory");
		}
			
	}
	
	
	/**
	 * Retorna o SessionFactory corrente
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	/**
	 * Retorna a sessão do SessionFactory
	 * 
	 * @return
	 */
	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	/**
	 * Abre uma nova sessão no SessionFactory
	 * 
	 */
	
	public static Session openSession() {
		if(sessionFactory==null) {
			buildSessionFactory();
		}
		
		return sessionFactory.openSession();	
	}
	
	/**
	 * Obtem a conection do provedor de conexões configurado
	 * @return Connection SQL
	 * @throws SQLException
	 */
	public static Connection getConnectionProvider() throws SQLException {
		return((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();	
	}
	
	
	/**
	 *
	 * @return Connection no InitialContext java:comp/env/jdbc/MySQLDataSource
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup(JAVA_COM_ENV_JDBC_DATA_SOURCE);
		return ds.getConnection();
	}
	
	/**
	 * 
	 * @return DataSource JNDI Tomcat
	 * @throws NamingException
	 */
	public DataSource getDataSourceJndi() throws NamingException {
		InitialContext context = new InitialContext();
		return (DataSource) context.lookup(JAVA_COM_ENV_JDBC_DATA_SOURCE);
		
	}
	
}
