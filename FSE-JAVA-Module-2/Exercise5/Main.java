package Exercise5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        while (true){
            System.out.println("1 . Add \n 2 . Search\n 3 . Traverse \n4 . Delete");
            int input = sc.nextInt();
            switch (input){
                case 1 :
                    System.out.println("Enter id , name , status");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    String status = sc.nextLine();
                    Node obj = new Node(id,name,status);
                    linkedList.add(obj);
                    break;
                case 2 :
                    System.out.println("Enter the id u want to see");
                    System.out.println(linkedList.search(sc.nextInt()));;
                    break;
                case 3 :
                    linkedList.traverse();
                    break;
                case 4 :
                    System.out.println("Enter the id u want to delete ");
                    int delete_id = sc.nextInt();
                    linkedList.Delete(delete_id);
                    break;
                case 6 : System.exit(0);
            }
        }
    }
}
