package Exercise5;

public class LinkedList {
    Node head;
    public LinkedList() {
        head = null;
    }
    public void add(Node node){
        if(head == null)
            head = node;
        else{
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public Task search(int id){
        Node temp = head;
        while (temp!=null){
            if(temp.task.getTaskId() == id)
                return  temp.task;
            temp = temp.next;
        }
        System.out.println("No Node is Found");
        return  null;
    }
    public void traverse(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.task);
            temp = temp.next;
        }
    }public void Delete(int id){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head.task.getTaskId() == id){
            head = head.next;
            System.out.println("Node is Deleted");
            return;
        }
        Node temp = head;
        Node prev = null;
        boolean flag = false;
        while (temp!=null){
            if(temp.task.getTaskId() == id){
                flag = true;
                prev.next = temp.next;
            System.out.println("Node is Deleted");
            }
            prev = temp;
            temp = temp.next;
        }
        if(!flag)
            System.out.println("No Node is Found");

    }


}
