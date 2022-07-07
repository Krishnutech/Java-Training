
import java.sql.*;
import java.util.*;
public class DbConn {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "nithu", "nutech");
    Statement stmt = con.createStatement();
    ResultSet rst = stmt.executeQuery("create table Employee(empid int primary key, name varchar(30), salary number(10), mobno number(10), noofyrs int)");
    rst = stmt.executeQuery("create table Admin(empid int primary key, name varchar(30), salary number(10), mobno number(10), noofyrs int)");
    System.out.println("Inserting values into Employee table...");
    PreparedStatement pst = con.prepareStatement("insert into Employee(empid,name,salary,mobno,noofyrs) values(?,?,?,?,?)");
    char ch = 'y', c = 'y';
    Scanner sc = new Scanner(System.in);
    int id;
    String empname;
    long sal;
    long mobnum;
    int noofyears;
    while(ch!='n') {
    	System.out.println("Enter Employee Id : ");
    	id = sc.nextInt();
    	System.out.println("Enter Employee Name : ");
    	empname = sc.next();
    	System.out.println("Enter Employee Salary : ");
    	sal = sc.nextLong();
    	System.out.println("Enter Employee Mobile Number : ");
    	mobnum = sc.nextLong();
    	System.out.println("Enter Employee's number of working years : ");
    	noofyears = sc.nextInt();
    	pst.setInt(1,id);
    	pst.setString(2,empname);
    	pst.setLong(3,sal);
    	pst.setLong(4,mobnum);
    	pst.setInt(5,noofyears);
    	int result=pst.executeUpdate();
    	if(result>0) {
    		System.out.println("Inserted successfully...");
    		System.out.println("Do you want to continue? y/n");
    		ch=sc.next().charAt(0);
    	}
    	
    }
   
    pst = con.prepareStatement("insert into Admin(empid,name,salary,mobno,noofyrs) values(?,?,?,?,?)");
    System.out.println("Inserting values into Admin table...");
    while(c!='n') {
    	System.out.println("Enter Admin Id : ");
    	id = sc.nextInt();
    	System.out.println("Enter Admin Name : ");
    	empname = sc.next();
    	System.out.println("Enter Admin Salary : ");
    	sal = sc.nextLong();
    	System.out.println("Enter Admin Mobile Number : ");
    	mobnum = sc.nextLong();
    	System.out.println("Enter Admin's number of working years : ");
    	noofyears = sc.nextInt();
    	pst.setInt(1,id);
    	pst.setString(2,empname);
    	pst.setLong(3,sal);
    	pst.setLong(4,mobnum);
    	pst.setInt(5,noofyears);
    	int result=pst.executeUpdate();
    	if(result>0) {
    		System.out.println("Inserted successfully...");
    		System.out.println("Do you want to continue? y/n");
    		c=sc.next().charAt(0);
    	}
    	
    }
    System.out.println(".... Employee Table Details ....");
    rst=stmt.executeQuery("select * from Employee");
    System.out.println("Employee id\tEmployee Name\tEmployee salary\tEmployee mobilenumber\tworking years");
    
    while(rst.next()) {
    	System.out.println(rst.getInt("empid")+"\t\t"+rst.getString("name")+"\t\t"+rst.getLong("salary")+"\t\t"+rst.getLong("mobno")+"\t\t"+rst.getInt("noofyrs")+"\t\t");
	}
    System.out.println(".... Admin Table Details ....");
    rst=stmt.executeQuery("select * from Admin");
    System.out.println("Admin id\tAdmin Name\tAdmin salary\tAdmin mobilenumber\tworking years");
    
    while(rst.next()) {
    	System.out.println(rst.getInt("empid")+"\t\t"+rst.getString("name")+"\t\t"+rst.getLong("salary")+"\t\t"+rst.getLong("mobno")+"\t\t"+rst.getInt("noofyrs")+"\t\t");
	}
	}
		
}
