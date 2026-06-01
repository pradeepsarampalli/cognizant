import java.util.*;
public class ArrayLists{
    public static void main(String[] args){
        ArrayList<String> studentNames = new ArrayList<>();
        int choice;
        System.out.println("1. Add a student name");
        System.out.println("2. Display all student names");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter student name: ");
                    String name = sc.nextLine();
                    studentNames.add(name);
                    break;
                case 2:
                    System.out.println("Student Names:");
                    for (String student : studentNames) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }        } while (choice != 3);
            sc.close();
    }
}