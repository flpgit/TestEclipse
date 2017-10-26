package cn.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.json.util.NewBeanInstanceStrategy;

public class DatabaseConneciton5 {
	private static final String DBDRIVER = "";
	private static final String DBURL = "";
	private static final String USER = "";
	private static final String PASSWORD = "";
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	private static Connection rebuildConnection(){
		try {
			Class.forName(DBDRIVER);
			return DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection(){
		Connection conn = threadLocal.get();
		if(conn==null){
			conn = DatabaseConneciton5.rebuildConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	
	public static void close(){
		Connection conn = threadLocal.get();
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		threadLocal.remove();
	}

}
