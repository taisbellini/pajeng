package br.ufrgs.inf.tlbellini.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.ufrgs.inf.tlbellini.PajeGrammar;

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
			String batch = "&rewriteBatchedStatements=true";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase + useSSL + batch;
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

	    long start = System.currentTimeMillis();
		try {
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			long end = System.currentTimeMillis();
			PajeGrammar.insertionTime += end-start;
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
			String container_alias, double imbrication, int fileId) {
		return "INSERT INTO state (startTime, endTime, type_alias, value_alias, container_alias, imbrication, container_file_id) " + "VALUES (" + start
				+ ", " + end + ", " + toString(type_alias) + ", " + toString(value_alias) + ", " + toString(container_alias) + ","+ imbrication + "," + fileId + ")";
	}

	public String generateInsertContainerSQL(String alias, String name, double start, double end, String parent_alias,
			String type_alias, int fileId) {
		StringBuilder sb = new StringBuilder("INSERT INTO container (alias, name, startTime, endTime, parent_container_alias, type_alias, file_id) VALUES (");
		sb.append(toString(alias));
		sb.append(", ");
		sb.append(toString(name));
		sb.append(", ");
		sb.append(start);
		sb.append(", ");
		sb.append(end);
		sb.append(", ");
		sb.append(toString(parent_alias));
		sb.append(", ");
		sb.append(toString(type_alias));
		sb.append(",");
		sb.append(fileId);
		sb.append(")");
		return sb.toString();
		
	}

	public String generateInsertTypeSQL(String alias, String name, String parent, int depth, int fileId) {
		return "INSERT INTO type (alias, name, parent_type_alias, depth, file_id) " + "VALUES ( " + toString(alias)  + " , " + toString(name) + ", " + 
				toString(parent) + ", " + depth + ", " + fileId + ")";
		
	}
	
	public String generateInsertVariableTypeSQL(String alias, String name, String parent, int depth, int fileId,
			PajeColor color) {
		return "INSERT INTO type (alias, name, parent_type_alias, depth, file_id, color) " + "VALUES ( " + toString(alias)  + " , " + toString(name) + ", " + 
				toString(parent) + ", " + depth + ", " + fileId + "," + toString(getStringColor(color)) + ")";
		
	}
	
	public String generateInsertLinkTypeSQL(String alias, String name, String parent, int depth, int fileId,
			String start, String end) {
		return "INSERT INTO type (alias, name, parent_type_alias, depth, file_id, start_link_type, end_link_type) " + "VALUES ( " + toString(alias)  + " , " + toString(name) + ", " + 
				toString(parent) + ", " + depth + ", " + fileId + "," + toString(start) + "," + toString(end) + ")";
		
	}

	public String generateInsertValueSQL(String alias, String name, String type, PajeColor color, int fileId) {
		return "INSERT INTO value (alias, name, type_alias, color, type_file_id) " + "VALUES ( " + toString(alias) + " , "+ toString(name) + ", " + 
				toString(type) + "," + getStringColor(color) +  "," + fileId + ")";
		
	}
	
	public String generateInsertEventSQL(double time, String type, String container, String value, int fileId) {
		return "INSERT INTO event (time, type_alias, container_alias, value_alias, type_file_id) " + "VALUES ( " + time + ", " + toString(type)  + " , " + toString(container) + ", " + 
				toString(value) +  ", " + fileId + ")";
		
	}
	
	public String generateInsertVariableSQL(double time, String type, String container, double value, double update, int fileId) {
		return "INSERT INTO variable (time, type_alias, container_alias, value, update_time, container_file_id) " + "VALUES ( " + time + "," + toString(type)  + " , " + toString(container) + ", " + 
				value +  ", " + update + "," + fileId + ")";
	}
	
	public String generateInsertLinkSQL(double start, double end, String key, String value, String type, String start_container, String end_container,
			int fileId) {
		return "INSERT INTO link (start_time, end_time, link_key, value_alias, type_alias, start_container_alias, end_container_alias, type_file_id) " + "VALUES ( " + start + ","+ end +  "," + toString(key)  + " , " + toString(value) + "," + toString(type) + ", " + 
				toString(start_container) +  ", " + toString(end_container) + "," + fileId + ")";
	}
	//if filename is the same 
	public int getFileId(String filename) throws SQLException{
		long start = System.currentTimeMillis();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = null;
		try{
			String sql = "SELECT id FROM file WHERE name = " + toString(filename) + " ORDER BY id DESC LIMIT 1";
			rs = stmt.executeQuery(sql);
			rs.next();
			long end = System.currentTimeMillis();
			PajeGrammar.insertionTime += end-start;
			int result = rs.getInt("id");
			rs.close();
			stmt.close();
			return result;
		}catch (Exception e){
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public void setEndContainerDB(String alias, int fileId, double time) {
		StringBuilder sb = new StringBuilder("UPDATE container SET endTime = ");
		sb.append(time);
		sb.append(" WHERE alias = ");
		sb.append(toString(alias));
		sb.append(" AND file_id = ");
		sb.append(fileId);
		this.insert(sb.toString());
		
	}
	
	//getting SQL Exception when string is not double quoted
	public String toString(String str){
		if(str.startsWith("\"") || str == "null")
			return str;
		else
			return "\"" + str + "\"";
	}
	
	protected String getStringColor(PajeColor color){
		if(color != null)
			return "(" + color.r + "," + color.g + "," + color.b + "," + color.a + ")";   
		else
			return "null";
	}


	

	

	


	

	

}
