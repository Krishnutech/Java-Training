import java.sql.*;
import java.util.Scanner;


public class JdbcWithData {
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Connection connect=null;
		Statement stmt = null;
		ResultSet rset = null;
		PreparedStatement pstmt=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		connect=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vijey","123");
		System.out.println("Connection Established...");
		
		stmt=connect.createStatement();
			
		//employee table
		rset=stmt.executeQuery("create table Employee (emp_id number PRIMARY KEY,emp_name varchar(30),emp_mail varchar(30),emp_address varchar(30),emp_salary number)");   
		System.out.println("Table Created...");
		
		int empId;
		String empName,empMail,empAdd;
		double empSalary;
		
		pstmt=connect.prepareStatement("insert into Employee values(?,?,?,?,?)");
		char c='y';
		while(c!='n') {
		
		System.out.println("Enter Employee Id: ");
		empId=sc.nextInt();
		System.out.println("Enter Employee Name: ");
		empName=sc.next();
		System.out.println("Enter Employee E-Mail: ");
		empMail=sc.next();
		System.out.println("Enter Employee Address: ");
		empAdd=sc.next();
		System.out.println("Enter Employee Salary: ");
		empSalary=sc.nextDouble();
		pstmt.setInt(1, empId);
		pstmt.setString(2, empName);
		pstmt.setString(3, empMail);
		pstmt.setString(4, empAdd);
		pstmt.setDouble(5, empSalary);

		int res=pstmt.executeUpdate();
		
		if(res>0) {
			System.out.println("Inserted Successfully");
			System.out.println("do you want to insert a values(y/n)");
			c=sc.next().charAt(0);
		}
		}
		rset=stmt.executeQuery("select * from Employee");
		
		while(rset.next()) {
			System.out.println(rset.getInt("emp_id")+"\t\t"+rset.getString("emp_name")+"\t\t"+rset.getString("emp_mail")+"\t\t"+rset.getString("emp_address")+"\t\t"+rset.getDouble("emp_salary"));
		}
	
		//employee table2
		rset=stmt.executeQuery("create table Employee2 (emp_id number PRIMARY KEY,emp_name varchar(30),emp_mail varchar(30),emp_address varchar(30),emp_salary number)");   
		System.out.println("Table Created...");
		
		
		
		pstmt=connect.prepareStatement("insert into Employee2 values(?,?,?,?,?)");
		c='y';
		while(c!='n') {
		
		System.out.println("Enter Employee Id: ");
		empId=sc.nextInt();
		System.out.println("Enter Employee Name: ");
		empName=sc.next();
		System.out.println("Enter Employee E-Mail: ");
		empMail=sc.next();
		System.out.println("Enter Employee Address: ");
		empAdd=sc.next();
		System.out.println("Enter Employee Salary: ");
		empSalary=sc.nextDouble();
		pstmt.setInt(1, empId);
		pstmt.setString(2, empName);
		pstmt.setString(3, empMail);
		pstmt.setString(4, empAdd);
		pstmt.setDouble(5, empSalary);

		int res=pstmt.executeUpdate();
		
		if(res>0) {
			System.out.println("Inserted Successfully");
			System.out.println("do you want to insert a values(y/n)");
			c=sc.next().charAt(0);
		}
		}
		rset=stmt.executeQuery("select * from Employee2");
		
		while(rset.next()) {
			System.out.println(rset.getInt("emp_id")+"\t\t"+rset.getString("emp_name")+"\t\t"+rset.getString("emp_mail")+"\t\t"+rset.getString("emp_address")+"\t\t"+rset.getDouble("emp_salary"));
		}
		
		stmt.close();
		connect.close();
		pstmt.close();
		sc.close();
		
		
		
	}
}
