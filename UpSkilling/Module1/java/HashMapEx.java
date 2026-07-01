import java.util.*;
public class HashMapEx{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int choice;
        do{
            System.out.println("1. Add a key-value pair");
            System.out.println("2. Get value by key");
            System.out.println("3. Display all key-value pairs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    map.put(key, value);
                    System.out.println("Key-value pair added.");
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    key = sc.nextLine();
                    if (map.containsKey(key)) {
                        System.out.println("Value: " + map.get(key));
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 3:
                    if (map.isEmpty()) {
                        System.out.println("No key-value pairs to display.");
                    } else {
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}