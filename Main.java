package Controller;
import java.sql.SQLException;
import java.util.*;

import DAO.LoginDAO;
import DAO.ProductDAO;
import Model.Login;
import Model.Product;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int choice;
		Login l=new Login();//to give the details for admin in model package it is an object for login page
       LoginDAO ldao=new LoginDAO();
       Product p=new Product();
       ProductDAO pdao=new ProductDAO();
       
		
		do {
    	  System.out.println("1.Admin\n 2.Agent\n 3.Exit\n *********************************** ");
    	  System.out.println("Enter your choice");
    	 choice =sc.nextInt();
    	 switch(choice)
    	 {
    	 case 1:
    		 System.out.println("Admin Login");
    		 System.out.println("Enter the user name");
    		 String username=sc.next();
    		 System.out.println("Enter the password");
    		 String password=sc.next();
    		 l.setUsername(username);//setting username and passwords
    		 l.setPassword(password);
    		 
    		// if(username.equals("Admin") && password.equals("Admin@123"))
    		 if(ldao.checkCredential(l))//from logindao
    		 {
    			 System.out.println("Login Successful!");
    			 System.out.println("Enter the choice");
    			 int option;
    			 do {
    				 System.out.println("1.Add Product\n 2.Display Product\n 3.Update\n 4.Delete\n 5.Logout");
    				 option =sc.nextInt();
    				 
    				 switch(option){
    				 case 1:
    					 
    					 System.out.println("Enter the product id");
    					 int product_id=sc.nextInt();
    					 
    					 System.out.println("Enter product name");
    					 String product_name=sc.next();
    					 
    					 System.out.println("enter the product minsell");
    					 int product_minsell=sc.nextInt();
    					 
    					 System.out.println("Enter the product price");
    					 int product_price=sc.nextInt();
    					 
    					 System.out.println("enter the product quantity");
    					 int product_quantity=sc.nextInt();
    					 
    					 p.setProduct_id(product_id);
    					 p.setProduct_name(product_name);
    					 p.setProduct_minsell(product_minsell);
    					 p.setProduct_quantity(product_quantity);
    					 p.setProduct_price(product_price);
    					 
    					 
    					pdao.addProduct(p);
    					 
    					 System.out.println("Enter the choice");
    					 break;
    				 case 2:
    					 System.out.println("These are the products");
    					 System.out.println("Enter the choice");
    					 pdao.display(p);
    					 
    					 break;
    				 case 3:
					    	System.out.println("Update product");
					    	System.out.println("Enter the productId:");
					    	int product_id1=sc.nextInt();
					    	sc.nextLine();
					    	System.out.println("Enter the productName");
							String product_name1 = sc.nextLine();
							System.out.println("Enter the minimum sell quantity");
							int product_minsell1 = sc.nextInt();
							System.out.println("Enter the price");
							int product_price1 = sc.nextInt();
							System.out.println("Enter the quantity");
							int product_quantity1 = sc.nextInt();
						    p.setProduct_id(product_id1);
							p.setProduct_name(product_name1);
						    p.setProduct_minsell(product_minsell1);
							p.setProduct_price(product_price1);
							p.setProduct_quantity(product_quantity1);
					    	pdao.Update(p);
					    	System.out.println("Product updated Successfully!");
					    	break;
    					 
    				 case 4:
    					 System.out.println("Delete the product");
    					 System.out.println("Enter the product id");
    					 int product_id2=sc.nextInt();
     					 p.setProduct_id(product_id2);
    					 pdao.deleteProduct(p);
    					 break;
    				 }
    			 }while(option!=4);
    		 }
    	 
    		 else
    			 System.out.println("Incorrect username/Password");
    		 break;
    		
    	 case 2:
    		 System.out.println("Agent Login");
    		 System.out.println("Enter the user name");
    		 String username1=sc.next();
    		 System.out.println("Enter the password");
    		 String password1=sc.next();
    		 //if(username1.equals("Admin") && password1.equals("Admin@123"))
    		 l.setUsername(username1);
    		 l.setPassword(password1);
    		 
    		 if(ldao.checkCredential(l))
    		 {
    			 System.out.println("Login Successful");
    			 System.out.println("Enter your choice");
    		 int option;
			 do{
				 System.out.println("1.Display\n 2.Logout");
				 option =sc.nextInt();
				 
				 switch(option){
				 case 1:
					System.out.println("Display these products");
					System.out.println("Enter the choice");
					
					 break;
				 case 2:
					 System.out.println("Logout");
					 
					
					 break;
					 
				 }
				 System.out.println("Enter the choice");
			 }while(option!=2);
    		 }
    		 else
    			 System.out.println("Incorrect username/Password");
    	  
    	  break;
    	 case 3:
    		 System.out.println("Exit");
    		 
    		 break;
    	 }
       }while(choice!=3);
    		 
    	 
       sc.close();//here this is written becoz for not to show warning at scanner sc ...the warning is becpz of ofline editors until and uness we close it wont
	}
       }
	

