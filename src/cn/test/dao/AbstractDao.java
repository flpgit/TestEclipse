package cn.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.test.connection.DataBaseConnection;

public class AbstractDao {
	protected Connection conn = DataBaseConnection.getConnection();
	protected PreparedStatement preparedStatement;
	public AbstractDao(){
		this.conn = conn;
		this.preparedStatement = preparedStatement;
	}
	

}
