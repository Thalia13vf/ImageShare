package br.com.files.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource implements Closeable{
	private String hostname;
	private String username;
	private String password;
	private String database;
	private Connection connection;
	
	public DataSource() 
	{
		try 
		{
			hostname = "localhost";
			database = "files";
			username = "root";
			password = "";
			String url = "jdbc:mysql://" + hostname + ":3306/" + database;
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(url, username, password);
		}
		catch(SQLException ex) 
		{
			System.out.println("Erro ao Conectar " + ex.getMessage());
		}
	}
	
	//método para pegar o atributo connection
	public Connection getConnection() 	
	{
		return this.connection;
	}

	@Override
	public void close() throws IOException {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
