package br.ufrgs.inf.tlbellini.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClass {

	public String status = "Não conectou...";
	public DBClass() {}

	public java.sql.Connection connectDB() { 
		Connection connection = null;
		
		try { 
			String driverName = "com.mysql.jdbc.Driver"; 
			Class.forName(driverName); 
			String serverName = "localhost"; 
			String mydatabase = "paje"; 
			String useSSL ="?verifyServerCertificate=false" + "&useSSL=false";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase + useSSL; 
			String username = "root";  
			String password = "root"; 
			connection = DriverManager.getConnection(url, username, password); 
			if (connection != null) { 
				status = ("STATUS--->Conectado com sucesso!"); 
			} else { 
				status = ("STATUS--->Não foi possivel realizar conexão"); 
			} return connection; } 

		catch (ClassNotFoundException e) { 
			System.out.println("O driver expecificado nao foi encontrado."); 
			return null; 
		} catch (SQLException e) { 
			System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
			return null; 
		} 
	} 
	public String statusConection() { 
		return status; 
	} 
	public boolean FecharConexao() { 
		try { 
			this.connectDB().close(); 
			return true; } 
		catch (SQLException e) 
		{ 
			return false; 
		} 
	} 

}



