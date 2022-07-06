import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class CollectionMapDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of elemnts you want to add..");
		int n=sc.nextInt();
		//creating list
		
		List<String> name=new ArrayList<String>();
		List<String> departments=new ArrayList<String>();
		List<String> email=new ArrayList<String>();
		List<String> mobilenum=new ArrayList<String>();
		
		//Getting input from users 
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the name :");
			name.add(sc.next());
			System.out.println("Enter the department :");
			departments.add(sc.next());
			System.out.println("Enter the mobile number :");
			mobilenum.add(sc.next());
			System.out.println("Enter the Emails :");
			email.add(sc.next());

		}
		
		//adding list into map 
		
		Map<String, List<String>> obj = new HashMap<>();
	    obj.put("Name", name);
	    obj.put("Departments", departments);
	    obj.put("Email", email);
	    obj.put("Mobile", mobilenum);
	    
	    //sorting the map by keys
	    
        TreeMap<String, List<String>> sorted = new TreeMap<>();
        sorted.putAll(obj);
        
        //iterating over maps
        for (var entry : sorted.entrySet()) {
            System.out.println("key :"+entry.getKey() + "," +" values :"+ entry.getValue());
        }
        sc.close();
	}		
	}


