import java.util.*;
class ListDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int num = sc.nextInt();
        //Creating a list of elements
        List<String> name = new ArrayList<>();
        List<String> department = new ArrayList<>();
        List<String> mobno = new ArrayList<>();
        List<String> email = new ArrayList<>();
        System.out.println("Enter name : ");
        for(int i = 0; i < num; i++) {
            name.add(sc.next());
        }
        System.out.println("Enter department : ");
        for(int i = 0; i < num; i++) {
            department.add(sc.next());
        }
        System.out.println("Enter Mobile Number : ");
        for(int i = 0; i < num; i++) {
            mobno.add(sc.next());
        }
        System.out.println("Enter Email  : ");
        for(int i = 0; i < num; i++) {
            email.add(sc.next());
        }
        //Storing the values of list into HashMap
        Map<String, List<String>> hs = new HashMap<String, List<String>>();
        hs.put("names", name);
        hs.put("department", department);
        hs.put("mobile number", mobno);
        hs.put("email", email);
        //Sorting the map using TreeMap
        Map<String, List<String>> hs2 = new TreeMap<>();
        hs2.putAll(hs);// Putting the values from HashMap to TreeMap
        for(String key : hs2.keySet()) {
         System.out.println(key+" : "+hs2.get(key));
         }
         sc.close();
}
}


     
    