package cn.test.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.json.util.NewBeanInstanceStrategy;

public class DatabaseConnection6 {
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/hello";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	private static Connection rebuildConnection(){
		try {
			Class.forName(DBDRIVER);
			Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
			System.out.println("****success*****:"+conn);
			return conn;
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
			conn = DatabaseConnection6.rebuildConnection();
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
	
	public static void main(String[] args) {
		rebuildConnection();
	}
	
}
	