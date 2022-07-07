package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ListDemo {
    public class listdemo {

        public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter Five Names"); //getting input from user
           List<String> name=new ArrayList<String>(Arrays.asList(sc.next(),sc.next(),sc.next(),sc.next(),sc.next()));
           List<String> department=new ArrayList<String>();
           department.add("Electronics");        // adding the elements
           department.add("Software");
           department.add("Biotechnology");
           department.add("Mechanical");
           department.add("AI");
           List<String> mobilenumber=new ArrayList<>();
           System.out.println("Enter the Mobile Number");
           for(int i=0;i<5;i++){   //for loop
             mobilenumber.add(sc.next());
           }
           //converting arrays in to list
           List<String> email=new ArrayList<String>(Arrays.asList("abitha5901@gmail.com","nisha28@gmail.com","nikil78@gmail.com","anu2656@gmail.com","dinesh07@gmail.com"));
           Map<String ,List<String>> map=new HashMap<String ,List<String>>();
           map.put("Name",name);//adding list in to hashmap
           map.put("Department",department);
           map.put("Mobilenumber",mobilenumber);
           map.put("Email",email);
           System.out.println("Before Sorting...");
           map.forEach((k,v)->System.out.println(k+":"+v));
           Map<String ,List<String>> maps=new TreeMap<String ,List<String>>();//sorting the hashmap
           maps.putAll(map);
           System.out.println("--------------------------------");
           System.out.println("After  Sorting...");
           maps.forEach((key,val)->System.out.println(key+":"+val));//for each using lambda expression

           
        }
    
    }
    
    
}
