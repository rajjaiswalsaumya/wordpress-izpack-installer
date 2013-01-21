package com.processors;

import com.izforge.izpack.util.AbstractUIProcessHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateWordpressDb {
		
	public void run(AbstractUIProcessHandler handler, String[] args) {
		
		String host = args[0];
		String dbname = args[1];
		String user = args[2];
		String pass = args[3];
		
		handler.logOutput("Attempting to create DB " + dbname + " on " 
											+ host + " with user:" + user + 
														" pass:" + pass, false);
		
		Connection conn = null;
		Statement stat = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+host, user, pass);
			stat = conn.createStatement();
			stat.executeUpdate("create database " + dbname);
			handler.logOutput("Created database " + dbname + " on " + host, false);

	    } catch (Exception e) {

	    	handler.logOutput("Couldnt create database for wordpress!", false);
	    	handler.emitError("Error", "Couldnt create database for wordpress!");
	    	
	    } finally {
	    	
	    	if ( conn != null ) {
	    		try {
					conn.close();
				} catch (SQLException e) {
			    	handler.logOutput("Couldnt close DB Connection", false);
				}
	    	}
	    	if ( stat != null ) {
	    		try {
					stat.close();
				} catch (SQLException e) {
					handler.logOutput("Couldnt close Statement", false);
				}
	    	}
	    	
	    }

		
	}	
}
