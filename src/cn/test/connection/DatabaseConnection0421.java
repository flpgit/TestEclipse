package cn.test.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.json.util.NewBeanInstanceStrategy;

public class DatabaseConnection0421 {
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/hello";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	private static Connection rebuildConnection() throws Exception{
		Class.forName(DBDRIVER);
		try {
			Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
			System.out.println("*****conn连接成功******:"+conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection() throws Exception{
		Connection conn = threadLocal.get();
		try {
			if(conn==null){
				conn = DatabaseConnection0421.rebuildConnection();
				threadLocal.set(conn);
			}
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(){        //必须是用close()方法关闭数据库的链接,如若不会清空threadLocal中的Connection对象,会导致数据库连接不能再次被打开
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
	
	public static void main(String[] args) throws Exception {
		DatabaseConnection0421.rebuildConnection();
	}

}
