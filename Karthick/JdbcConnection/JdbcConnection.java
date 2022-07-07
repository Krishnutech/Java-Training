package jdbcConnection;

import java.sql.*;
import java.util.Scanner;

public class JdbcConnection {
	public static void main(String[] args) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		
			ResultSet r;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String userName="karthi";
			String password="karthi";
			//connecting the database with with username&password
			Connection c=DriverManager.getConnection(url,userName,password);
			System.out.println("Employee Details");
			Statement st=c.createStatement();
			//creating Employee table
			r=st.executeQuery("Create table employee(ename varchar(20),empid number,email varchar(20),mobile number(10),salary varchar(10))");
			
			
			PreparedStatement pst=c.prepareStatement("insert into employee(ename,empid,email,mobile,salary) values(?,?,?,?,?)");
			
			char test='Y';
			do {//getting and inserting values for the Employee table
				System.out.println("Enter the name:");
				pst.setString(1,sc.next());
				System.out.println("Enter the id:");
				pst.setInt(2,sc.nextInt());
				System.out.println("Enter the Email Address:");
				pst.setString(3,sc.next());
				System.out.println("Enter the mobile:");
				pst.setLong(4,sc.nextLong());
				System.out.println("Enter the salary:");
				pst.setString(5,sc.next());
				int res=pst.executeUpdate();

				if(res>0)
				{
					System.out.println("insert successfull");
					System.out.println("do you want insert another value:");
					test=sc.next().charAt(0);
				}
			}while(test=='Y' || test =='y');
			
			System.out.println("Employee Details...");
			r=st.executeQuery("Select * from employee");
			System.out.println("eName\t\tempId\t\temail\t\tmobile\t\tsalary" );
			while(r.next()) {
				System.out.println(r.getString("ename")+"\t\t"+ r.getInt("empid")+"\t\t"+ r.getString("email")+"\t\t"+r.getLong("mobile")+ "\t\t"+ r.getString("salary") );
			}
			System.out.println("HR Details");
			//creating table for HR
			r=st.executeQuery("Create table HR(ename varchar(20),empid number,email varchar(20),mobile number(10),salary varchar(10))");
			
			
			PreparedStatement pst1=c.prepareStatement("insert into HR(ename,empid,email,mobile,salary) values(?,?,?,?,?)");
			
			char test1='Y';
			do {//getting and inserting values for the HR table
				System.out.println("Enter the name:");
				pst1.setString(1,sc.next());
				System.out.println("Enter the id:");
				pst1.setInt(2,sc.nextInt());
				System.out.println("Enter the Email Address:");
				pst1.setString(3,sc.next());
				System.out.println("Enter the mobile:");
				pst1.setLong(4,sc.nextLong());
				System.out.println("Enter the salary:");
				pst1.setString(5,sc.next());
				int res1=pst1.executeUpdate();

				if(res1>0)
				{
					System.out.println("insert successfull");
					System.out.println("do you want insert another value:");
					test1=sc.next().charAt(0);
				}
			}while(test1=='Y' || test1 =='y');
			
			System.out.println("HR Details...");
			r=st.executeQuery("Select * from HR");
			System.out.println("eName\t\tempId\t\temail \t\tmobile\t\tsalary" );
			while(r.next()) {
				//printing values of HR table
				System.out.println(r.getString("ename")+"\t\t"+ r.getInt("empid")+"\t\t"+ r.getString("email")+"\t\t\t"+r.getLong("mobile")+ "\t\t"+ r.getString("salary") );
			}
			c.close();
			st.close();
			r.close();
			pst.close();
			pst1.close();
			

		
		
		sc.close();
	
		

	}

}
