package br.ufrgs.inf.tlbellini.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInteraction {
	public String status = "Not connected...";
	public Connection conn;
	
	public DBInteraction(){
		
	}

	public void connectDB() {
		Connection connection = null;
	
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase = "paje";
			String useSSL = "?verifyServerCertificate=false" + "&useSSL=false";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase + useSSL;
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				status = ("STATUS--->Successfully connected");
			} else {
				status = ("STATUS--->Not connected");
			}
			this.conn = connection;
		}
	
		catch (ClassNotFoundException e) {
			System.out.println("The driver specified was not found.");
			
		} catch (SQLException e) {
			System.out.println("The database was not found.");
			
		}
	}
	
	public String status() {
		return status;
	}
	
	public boolean close() {
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}

