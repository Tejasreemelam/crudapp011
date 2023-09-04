package DAO;

import java.sql.*;

import ConnectionManager.ConnectionManager;
import Model.Login;

public class LoginDAO {
public boolean checkCredential(Login l) throws ClassNotFoundException, SQLException//for getting details Login is Login.java
{
	
	//1.get the details from login.java file
	String username=l.getUsername();
	String password=l.getPassword();
	//2.jdbc connection
	ConnectionManager cn=new ConnectionManager();
	 Connection con=cn.establishConnection();//connection
	 /*3.where to write queies
	      a.statement creation:
	      b.stataement class:what type() of queries def in class
	      c.execute query*/
	 //3.statement creation//
	 Statement st=con.createStatement();
	 //4.write andd execute query
	 //st.executeQuery("Select * from login");
	 //queries have class caled ResultSet which will have pre defined impementation of lists..;
	 ResultSet rt=st.executeQuery("Select * from login");
	 //5.check the credentials
	 while(rt.next()) //iterator is next
	 {
		 if(username.equals(rt.getString("username")) && password.equals(rt.getString("password"))) //user name from java page is equals to database
		 {
			 cn.closeConnection();
			 return true;
			 
		 }
	 }
	 cn.closeConnection();
	 return false;
	      
	}
}
