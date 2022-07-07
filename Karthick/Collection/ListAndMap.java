import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class ListAndMap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Creating List
        List<String> names=new ArrayList<String>();
        List<String> department =new ArrayList<String>();
        List<String> mobile=new ArrayList<String>();
        List<String> email=new ArrayList<String>();
        for(int i=0;i<5;i++){
            //Adding values to the list
            System.out.print("Enter Your Name :"); names.add(sc.nextLine());
            System.out.print("Enter Your Department :"); department.add(sc.nextLine());
            //Checking mobile number
            while (true){
                System.out.print("Enter Your Mobile Number :"); String number=sc.nextLine();
                if(number.length()==10){      mobile.add(number); break;}
                else{   System.out.println(" Mobile number should contain 10 digits ");}
            }
            //Checking Email id
            while (true){
                System.out.print("Enter Your Email :"); String mail=sc.nextLine(); 
                if(mail.contains("@")){     email.add(mail);    break;}
                else{   System.out.println("E-mail must contain '@' ");}
            }
        }
        sc.close();
        //Adding List values into the Map
        Map<String,List<String>> map=new HashMap<>();
        map.put("Names",names);
        map.put("Department",department);
        map.put("Mobile Number",mobile);
        map.put("Email",email);
        //Sorting the Keys of map 
        Map<String,List<String>> treemap=new TreeMap<>();
        treemap.putAll(map);
        for( String a:treemap.keySet()){
            System.out.println();
            System.out.print(a+" : ");//Keys
            System.out.println(treemap.get(a));//Values
        }
    }
}
