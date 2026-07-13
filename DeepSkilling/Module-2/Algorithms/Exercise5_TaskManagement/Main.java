public class Main {
    public static void main(String[] args){

        TaskLinkedList list = new TaskLinkedList();

        list.add(new Task(1,"Design Database","Pending"));
        list.add(new Task(2,"Develop API","In Progress"));
        list.add(new Task(3,"Testing","Pending"));

        System.out.println("All Tasks:");
        list.display();

        System.out.println("\nSearch Task:");
        System.out.println(list.search(2));

        System.out.println("\nDelete Task 1");
        list.delete(1);

        list.display();
    }
}