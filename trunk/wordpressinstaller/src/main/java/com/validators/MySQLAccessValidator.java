package com.validators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.izforge.izpack.installer.AutomatedInstallData;
import com.izforge.izpack.installer.DataValidator;

public class MySQLAccessValidator implements DataValidator {
	
	String message = "Cannot connect to mysql database!";
	
	public boolean getDefaultAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getErrorMessageId() {
		// TODO Auto-generated method stub
		return message;
	}

	public String getWarningMessageId() {
		// TODO Auto-generated method stub
		return message;
	}

	public Status validateData(AutomatedInstallData adata) {
		
		String host = adata.getVariable( "wordpress-izpack-installer.variable.databasehost" );
        String user = adata.getVariable( "wordpress-izpack-installer.variable.databaseusername" );
        String pass = adata.getVariable( "wordpress-izpack-installer.variable.databasepassword" );

        Connection conn = null;
		Statement stat = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+host, user, pass);
			return Status.OK;
			
	    } catch (Exception e) {

	    	return Status.ERROR;
	         
	    } finally {
	    	
	    	if ( conn != null ) {
	    		try {
					conn.close();
				} catch (SQLException e) {
			    	
				}
	    	}
	    	if ( stat != null ) {
	    		try {
					stat.close();
				} catch (SQLException e) {
				}
	    	}
	    	
	    }
       
	}
	
	
	
	
}
