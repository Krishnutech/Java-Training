import java.sql.*;
import java.util.Scanner;
public class JdbcTask {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con;
		Statement st;
		PreparedStatement pst;
		ResultSet rs;
		
	    Class.forName("oracle.jdbc.driver.OracleDriver");	
	    System.out.println("Loading Driver......");
	    
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","maha","mahalakshmi");
	    System.out.println("Conected succesfully.....");
	    
	    st=con.createStatement();
	    rs=st.executeQuery("create table NU_Employee(emp_id int primary key,emp_name varchar(20),emp_mobile number(10),emp_salary number(10),emp_mail varchar(30))");
	    System.out.println("NU EMPLOYEE table is created.....");
	    
	    rs=st.executeQuery("create table Capgemini_Employee(emp_id int primary key,emp_name varchar(20),emp_mobile number(10),emp_salary number(10),emp_mail varchar(30))");
	    System.out.println("CAPGEMINI EMPLOYEE table is created.....");
	    
	    System.out.println("Inserting into an NU employee table.....");
	    pst=con.prepareStatement("insert into NU_Employee(emp_id,emp_name,emp_mobile,emp_salary,emp_mail) values(?,?,?,?,?)");
	    
	    char ch='y',c='y';
	    int i=1;
	    Scanner sc=new Scanner(System.in);
	    String empName,email;int empId;long mobile;long sal;
	    while(ch!='n')
	    {
	    	System.out.println("NU Employee "+i);
	    	System.out.println("Enter employee id");
	    	empId=sc.nextInt();
	    	System.out.println("Enter employee name");
	    	empName=sc.next();
	    	System.out.println("Enter employee mobile number");
	    	mobile=sc.nextLong();
	    	System.out.println("Enter employee salary");
	    	sal=sc.nextLong();
	    	System.out.println("Enter employee email id");
	    	email=sc.next();
	    	pst.setInt(1, empId);
	    	pst.setString(2, empName);
	    	pst.setLong(3, mobile);
	    	pst.setLong(4,sal);
	    	pst.setString(5,email);
	    	int res=pst.executeUpdate();
	    	i++;
	    	if(res>0)
	    	{
	    		System.out.println("INSERT SUCCESSFULL");
	    		System.out.println("do you want to continue adding NU employee details? y/n");
	    		ch=sc.next().charAt(0);
	    	}
	
	    }
	    int j=1;
	    pst=con.prepareStatement("insert into Capgemini_Employee(emp_id,emp_name,emp_mobile,emp_salary,emp_mail) values(?,?,?,?,?)");
	    System.out.println("Inserting values into Capgemini employee table........");
	    while(c!='n')
	    {
	    	System.out.println("CAPGEMINI Employee "+j);
	    	System.out.println("Enter employee id");
	    	empId=sc.nextInt();
	    	System.out.println("Enter employee name");
	    	empName=sc.next();
	    	System.out.println("Enter employee mobile number");
	    	mobile=sc.nextLong();
	    	System.out.println("Enter employee salary");
	    	sal=sc.nextLong();
	    	System.out.println("Enter employee email id");
	    	email=sc.next();
	    	pst.setInt(1, empId);
	    	pst.setString(2, empName);
	    	pst.setLong(3, mobile);
	    	pst.setLong(4,sal);
	    	pst.setString(5,email);
	    	int res=pst.executeUpdate();
	    	j++;
	    	if(res>0)
	    	{
	    		System.out.println("INSERT SUCCESSFULL");
	    		System.out.println("do you want to continue adding capgemini employee detail? y/n");
	    		c=sc.next().charAt(0);
	    	}
	
	    }
	
	    System.out.println("..........Displaying NU employee Table.......");
	    System.out.println("-------------------------------------------------");
	    rs=st.executeQuery("select * from NU_Employee");
	    System.out.println("Employee id\tEmployee Name\tEmployee Email\tEmployee phone number\tEmployee Salary");
	    while(rs.next())
		{			
			System.out.println(rs.getInt("emp_id") +"\t\t"+rs.getString("emp_name") +"\t\t"+ rs.getString("emp_mail") +"\t\t"+rs.getLong("emp_mobile")+"\t\t"+rs.getLong("emp_salary"));
			
		}
	    
	    System.out.println();
	    System.out.println();
	    
	    System.out.println("..........Displaying Capgemini employee Table.......");
	    System.out.println("-------------------------------------------------");
	    rs=st.executeQuery("select * from Capgemini_Employee");
	    System.out.println("Employee id\tEmployee Name\tEmployee Email\tEmployee phone number\tEmployee Salary");
	    while(rs.next())
		{			
			System.out.println(rs.getInt("emp_id") +"\t\t"+rs.getString("emp_name") +"\t\t"+ rs.getString("emp_mail") +"\t\t"+rs.getLong("emp_mobile")+"\t\t"+rs.getLong("emp_salary"));
			
		}
		st.close();
		con.close();
		pst.close();
		sc.close();
	    	


	    	
	    }
		
	
	}


