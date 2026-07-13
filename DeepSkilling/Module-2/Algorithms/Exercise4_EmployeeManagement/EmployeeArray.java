public class EmployeeArray {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee e){
        if(size < employees.length){
            employees[size++] = e;
        }
    }

    public Employee search(int id){
        for(int i=0;i<size;i++){
            if(employees[i].getEmployeeId()==id)
                return employees[i];
        }
        return null;
    }

    public void delete(int id){
        for(int i=0;i<size;i++){
            if(employees[i].getEmployeeId()==id){
                for(int j=i;j<size-1;j++)
                    employees[j]=employees[j+1];
                employees[--size]=null;
                return;
            }
        }
    }

    public void display(){
        for(int i=0;i<size;i++)
            System.out.println(employees[i]);
    }
}