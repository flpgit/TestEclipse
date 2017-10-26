package cn.test.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>() ;
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	private static final String DBURL = "jdbc:mysql://localhost:3306/hello" ;
	private static final String DBUSER = "root";
	private static final String PASSWORD = "1234";
	
	private static Connection rebulidConnection() throws Exception{
		Class.forName(DBDRIVER);
		Connection conn =  DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		System.out.println("*****conn*****:"+conn);
		return conn;
	}
	
	public static Connection getConnection() {
		Connection conn = threadLocal.get();
		try {
			if(conn==null){
				conn = rebulidConnection();
				threadLocal.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
public static void main(String[] args) throws Exception{
	System.out.println("执行了");
	rebulidConnection();
}

}
