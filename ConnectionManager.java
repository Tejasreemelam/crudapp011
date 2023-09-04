package ConnectionManager;
import java.sql.*;

public class ConnectionManager {
	Connection cn=null;
	public Connection establishConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");//creating a driver class
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb1","root","Tejasree99");
		return cn;
	}
	public void closeConnection() throws SQLException
	{
		cn.close();
	}

}
