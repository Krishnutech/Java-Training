package jdbcproject;
import java.sql.*;
import java.util.Scanner;
public class jdbcdemo1 {
	public static void main(String[] args) throws SQLException {
		ResultSet rs;
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","hr","nutech");  
		Statement stm=con.createStatement();
		//Creating Employee Table
		rs=stm.executeQuery("create table employee(empid int primary key,empname varchar(20),managername varchar(20),empage int,location varchar(10))");
		System.out.println("employee table created");
		
		Scanner sc=new Scanner(System.in);
		//Inserting values in employees table
		char i;
		do {
		PreparedStatement pst=con.prepareStatement("insert into employee(empid,empname,managername,empage,location) values(?,?,?,?,?)");
	    System.out.println("Enter the employee id");
		pst.setInt(1,sc.nextInt());
		System.out.println("Enter the employee Name");
		pst.setString(2,sc.next());
		System.out.println("Enter the manager Name");
		pst.setString(3,sc.next());
		System.out.println("Enter the employee age");
		pst.setInt(4,sc.nextInt());
		System.out.println("Enter the location");
		pst.setString(5,sc.next());
	    int  rs1=pst.executeUpdate();
		if(rs1>0) {
			System.out.println("Inserted Successfully");
		}
		System.out.println("Do you want to insert again in employee table(y/n)");
	    i=sc.next().charAt(0);
		}while(i=='y');
		// Displaying employee table
		  System.out.println("________EmployeeTable_____________");
		   rs=stm.executeQuery("Select*from employee");
		   System.out.println("Empid\t\tEmpName\t\tManagerName\tManagerId\tLocation");
		  while(rs.next()) {
			  System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t "+rs.getInt(4)+"\t\t "+rs.getString(5));
			  System.out.println();
		  }
		 // Creating customer Table
		  rs=stm.executeQuery("create table customer(custid int primary key,custname varchar(20),productname varchar(20),productid int,country varchar(10))");
			System.out.println("customer table created");
		
		//Inserting values in customer table
				char j;
				do {
				PreparedStatement pst=con.prepareStatement("insert into customer(custid,custname,productname,productid,country) values(?,?,?,?,?)");
			    System.out.println("Enter the customer id");
				pst.setInt(1,sc.nextInt());
				System.out.println("Enter the customer Name");
				pst.setString(2,sc.next());
				System.out.println("Enter the product Name");
				pst.setString(3,sc.next());
				System.out.println("Enter the product id ");
				pst.setInt(4,sc.nextInt());
				System.out.println("Enter the country");
				pst.setString(5,sc.next());
				int rs1=pst.executeUpdate();
				if(rs1>0) {
					System.out.println("Inserted Successfully");
				}
				System.out.println("Do you want to insert again in customer table(y/n)");
			    j=sc.next().charAt(0);
				}while(j=='y');
          
		// Displaying customer table
		  System.out.println("________CustomerTable_________");
		   rs=stm.executeQuery("Select*from Customer");
		   System.out.println("custid\tcustName\tprodName\tprodId\tCountry");
		  while(rs.next()) {
			  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t"+rs.getString(5));
			  System.out.println();
		  }
		}
	
}