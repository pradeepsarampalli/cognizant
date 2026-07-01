package Exercise4;

public class Main {

    public static void main(String[] args) {

        Methods m = new Methods(5);

        m.add(new Employee(101, "Umesh", "Developer", 50000));
        m.add(new Employee(102, "Rahul", "Tester", 40000));
        m.add(new Employee(103, "Priya", "Manager", 80000));

        System.out.println("All Employees:");
        m.traverse();

        System.out.println("\nSearch Employee:");
        System.out.println(m.search(102));

        System.out.println("\nDelete Employee 102");
        m.delete(102);

        System.out.println("\nAfter Deletion:");
        m.traverse();
    }
}
