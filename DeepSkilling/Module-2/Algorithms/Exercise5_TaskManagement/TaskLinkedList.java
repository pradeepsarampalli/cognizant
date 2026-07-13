public class TaskLinkedList {
    private Node head;

    public void add(Task task){
        Node newNode = new Node(task);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public Task search(int id){
        Node temp = head;
        while(temp != null){
            if(temp.task.getTaskId() == id)
                return temp.task;
            temp = temp.next;
        }
        return null;
    }

    public void delete(int id){
        if(head == null) return;

        if(head.task.getTaskId() == id){
            head = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while(curr != null){
            if(curr.task.getTaskId() == id){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.task);
            temp = temp.next;
        }
    }
}