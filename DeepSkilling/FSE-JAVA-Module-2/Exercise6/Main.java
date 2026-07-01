package Exercise6;

import Exercise5.LinkedList;
import Exercise5.Node;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Searching searching = new Searching(10);
        while (true) {
            System.out.println("1 . Add \n 2 . linear Search\n 3 . Binary Search");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    System.out.println("Enter id , title , author");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String title = sc.nextLine();
                    String author = sc.nextLine();
                    searching.add(new Book(id,title,author));
                    break;
                case 2:
                    System.out.println("Linear Search");
                    System.out.println("Enter the title name");
                    String stitle = sc.nextLine();
                    System.out.println(searching.linearSearch(stitle));
                    break;
                case 3:
                    System.out.println("Binary Search");
                    System.out.println("Enter the title name");
                    String btitle = sc.nextLine();
                    System.out.println(searching.binarySearch(btitle));
                    break;
                case 4:
                    searching.traverse();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
