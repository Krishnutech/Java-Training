package Practice_Codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDetailsList {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // creating a list (used String generics)
    List<String> nameList = new ArrayList<>();
    List<String> departmentList = new ArrayList<>();
    List<String> mobileNumberList = new ArrayList<>();
    List<String> mailList = new ArrayList<>();

    System.out.println("Enter the number of records to add: ");
    int n = scanner.nextInt();
    int i = 0;

    // get details from user and add the values in list
    do {
      System.out.print("Enter the name: ");
      nameList.add(scanner.next());
      System.out.print("Enter the department: ");
      departmentList.add(scanner.next());
      System.out.print("Enter the mobile number: ");
      mobileNumberList.add(scanner.next());
      System.out.print("Enter the email: ");
      mailList.add(scanner.next());
      System.out.println(" ");
      i++;
    } while (i < n);

    // creating a map with generics
    Map<String, List<String>> detailsMap = new HashMap<String, List<String>>();
    detailsMap.put("Name", nameList);
    detailsMap.put("Department", departmentList);
    detailsMap.put("MobileNumber", mobileNumberList);
    detailsMap.put("E-mail", mailList);

    // Sorting the list using TreeMap
    Map<String, List<String>> detailsSortedmap = new TreeMap<String, List<String>>();
    detailsSortedmap.putAll(detailsMap);

    // iterating a Map
    for (Entry<String, List<String>> entry : detailsSortedmap.entrySet()) {
      System.out.println(entry.getKey() + "     " + entry.getValue());
    }
    scanner.close();
  }
}
