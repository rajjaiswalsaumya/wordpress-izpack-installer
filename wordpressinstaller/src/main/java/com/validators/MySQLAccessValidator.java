package com.validators;

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
		
		String databasehost = adata.getVariable( "wordpress-izpack-installer.variable.databasehost" );
        String databaseusername = adata.getVariable( "wordpress-izpack-installer.variable.databaseusername" );
        String databasepassword = adata.getVariable( "wordpress-izpack-installer.variable.databasepassword" );
        String wordpressdatabasename = adata.getVariable( "wordpress-izpack-installer.variable.wordpressdatabasename" );

        System.out.println(databasehost + " " + databaseusername);
        
        return Status.ERROR;
        
	}
	
	
	
	
}
