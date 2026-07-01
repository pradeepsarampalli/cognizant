package Exercise4;

public class Methods {

    private Employee[] employees;
    private int count;

    public Methods(int n) {
        employees = new Employee[n];
        count = 0;
    }

    public void add(Employee employee) {

        if (count == employees.length) {
            System.out.println("Array is full");
            return;
        }

        employees[count++] = employee;
    }

    public Employee search(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }

        return null;
    }

    public void traverse() {

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void delete(int employeeId) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found");
            return;
        }

        // Shift elements left
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted");
    }
}
