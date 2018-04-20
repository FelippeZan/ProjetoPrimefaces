package br.com.framework.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable{
	
	// salva os dados
	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;
	
	//Salva ou atualiza
	void saveOrUpdate(T obj) throws Exception;

	//Realiza o update/atualização de dados
	void update(T obj) throws Exception;
	
	//Deleta os dados
	void delete(T obj) throws Exception;
	
	//Salva ou atualiza e retorna o objeto em estado persistente
	T merge (T obj) throws Exception;
	
	//Carrega a lista de dados de determinada classe
	List<T> findList(Class<T> objs) throws Exception;
	
	Object findById(Class<T> entidade, Long id) throws Exception;
	
	T findPorId(Class<T> entidade, Long id) throws Exception;
	
	List<T> findListByQueryDinamica(String s) throws Exception;
	
	//Executar update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	//Executar update com SQL
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	//limpa sesssão do Hibernate
	void clearSession() throws Exception;
	
	//Retira um objeto da sessão o Hibernate
	void evict(Object objs) throws Exception;
	
	Session getSession() throws Exception;
	
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	//JDBC do Sprign
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	Long totalRegistro(String table) throws Exception;;
	
	Query obterQuery(String query) throws Exception;
	
	
	//Carregamento dinamico com JSF	e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;;
	
	
}
