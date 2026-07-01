package Exercise5;

public class Node {
    Task task;
    Node next;
    Node(int id,String name,String status){
        this.task = new Task(id,name,status);
        this.next = null;
    }

}
