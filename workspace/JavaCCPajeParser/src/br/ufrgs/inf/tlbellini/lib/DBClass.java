package br.ufrgs.inf.tlbellini.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class DBClass {

	public String status = "Not connected...";
	public Connection conn;

	public DBClass() {
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

	public boolean insert(String sql) {
		try {
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("DB ERROR: ");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public String generateInsertFileSQL(String filename, String comment, String date){
		return "INSERT INTO file (name, comment, date) " + "VALUES ( " + toString(filename)  + " , " + toString(comment) + ", " + 
				toString(date) + ")";
	}
	
	
	public String generateInsertStateSQL(double start, double end, String type_alias, String value_alias,
			String container_alias) {
		return "INSERT INTO state (startTime, endTime, type_alias, value_alias, container_alias) " + "VALUES (" + start
				+ ", " + end + ", " + toString(type_alias) + ", " + toString(value_alias) + ", " + toString(container_alias) + ")";
	}

	public String generateInsertContainerSQL(String alias, String name, double start, double end, String parent_alias,
			String type_alias) {
		return "INSERT INTO container (alias, name, startTime, endTime, parent_container_alias, type_alias) " + "VALUES (" + toString(alias) + ", " + toString(name) + ", " + start
				+ ", " + end + ", " + toString(parent_alias) + ", " + toString(type_alias) + ")";
		
	}

	public String generateInsertTypeSQL(String alias, String name, String parent, int depth, int fileId) {
		return "INSERT INTO type (alias, name, parent_type_alias, depth, file_id) " + "VALUES ( " + toString(alias)  + " , " + toString(name) + ", " + 
				toString(parent) + ", " + depth + ", " + fileId + ")";
		
	}

	public String generateInsertValueSQL(String alias, String name, String type) {
		return "INSERT INTO value (alias, name, type_alias)" + "VALUES ( " + toString(alias) + " , "+ toString(name) + ", " + 
				toString(type) + ")";
		
	}
	
	public int getFileId(String filename) throws SQLException{
		java.sql.Statement stmt = conn.createStatement();
		String sql = "SELECT id FROM file WHERE name = " + toString(filename);
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		return rs.getInt("id");
		
	}
	
	//getting SQL Exception when string is not double quoted
	public String toString(String str){
		if(str.startsWith("\"") || str == "null")
			return str;
		else
			return "\"" + str + "\"";
		
	}

	

}
