public class Main {
    public static void main(String[] args){
        EmployeeArray empArray = new EmployeeArray();

        empArray.add(new Employee(101,"Alice","Manager",60000));
        empArray.add(new Employee(102,"Bob","Developer",50000));
        empArray.add(new Employee(103,"Charlie","Tester",40000));

        System.out.println("All Employees:");
        empArray.display();

        System.out.println("\nSearch Employee:");
        System.out.println(empArray.search(102));

        System.out.println("\nAfter Deleting Employee 101:");
        empArray.delete(101);
        empArray.display();
    }
}