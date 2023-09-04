package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import Model.Product;

//to display all the details of products
public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cn=new ConnectionManager();
		Connection con=cn.establishConnection();
		//que query
		String que="insert into product_details1(product_id,product_name,product_minsell,product_price,product_quantity) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(que);//
		ps.setInt(1,p.getProduct_id());
		ps.setString(2,p.getProduct_name());
		ps.setInt(3,p.getProduct_minsell());
		ps.setInt(4,p.getProduct_price());
		ps.setInt(5,p.getProduct_quantity());
		ps.executeUpdate();
		cn.closeConnection();
	}
	
	
	public void display( Product p) throws SQLException, ClassNotFoundException
	{  
		//copy paste from loginDAo
		
		//2.jdbc connection
		ConnectionManager cn=new ConnectionManager();
		 Connection con=cn.establishConnection();//connection
		 /*3.where to write queries
		      a.statement creation:
		      b.stataement class:what type() of queries def in class
		      c.execute query*/
		 //3.statement creation//
		 Statement st=con.createStatement();
		 //4.write and execute query
		 //st.executeQuery("Select * from login");
		 //queries have class called ResultSet which will have pre defined impementation of lists..;
		 ResultSet rt=st.executeQuery("Select * from product_details1");
		 //5.check the credentials
		 while(rt.next()) //iterator is next
		 {
			 System.out.println(rt.getInt("product_id")+" " +rt.getString("product_name")+"  "+rt.getInt("product_minsell")+" "+rt.getInt("product_price")+"  "+rt.getInt("product_quantity")+"  ");
		 }
		 
		      
		}
	
	public void Update(Product p) throws ClassNotFoundException, SQLException
	 {
		 ConnectionManager cm = new ConnectionManager();
		 Connection con = cm.establishConnection();
		 String que = "update product set productname=?,minsellquantity=?,price=?,quantity=? where productId=?";
		 PreparedStatement ps = con.prepareStatement(que);
		
			ps.setString(1,p.getProduct_name());
			ps.setInt(2,p.getProduct_minsell());
			ps.setInt(3,p.getProduct_price());
			ps.setInt(4,p.getProduct_quantity());
			 ps.setInt(5,p.getProduct_id());
		 ps.executeUpdate();
		 cm.closeConnection();
	 }
	public void deleteProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cn=new ConnectionManager();
		Connection con=cn.establishConnection();
		String que="delete from product_details1 where product_id=?";
		PreparedStatement ps = con.prepareStatement(que);
		ps.setInt(1,p.getProduct_id());
		ps.executeUpdate();
		cn.closeConnection();
	}
	}


