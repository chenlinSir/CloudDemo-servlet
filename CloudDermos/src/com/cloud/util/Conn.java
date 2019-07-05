package com.cloud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection conn;
	
	public Conn(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Couldcar?characterEncoding=utf8","root","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void colse(PreparedStatement ps, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
