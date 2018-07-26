package dosframework.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class ActionMappingFactoryBean {
	
	@Autowired
	private XmlWebApplicationContext context;
	
	private DataSource datasource;
	private String sql = "SELECT * FROM ACTION_MAPPING";
	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public String getSql(){
		return this.sql;
	}
	
	public void setSql(String sql){
		this.sql = sql;
	}
	
	
	
	@PostConstruct
	public void init(){
		System.out.println("action mapping create bean");
		Connection conn = null;
		Statement st = null;
		try {
			conn = datasource.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
			
			while (rs.next()) {
				ActionMappingBean actionBean = new ActionMappingBean();
				
				actionBean.setActionId(rs.getString("ACTION_ID"));
				actionBean.setClassNm(rs.getString("CLASS_NM"));
				actionBean.setClassMethod(rs.getString("CLASS_METHOD"));
				actionBean.setView(rs.getString("PAGE_NM"));
				actionBean.setActionType(rs.getString("ACTION_TYPE"));
				
				beanFactory.registerSingleton(actionBean.getActionId(), actionBean);
			}
			
			Iterator<String> iterator = beanFactory.getBeanNamesIterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if (st != null) st.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}
		
		
	}
	
	
}
