package DI;

public class Main {
    public static void main(String[] args){
        CustomerService customerService = new CustomerService(new CustomerRepositoryImpl());
        customerService.find();
    }
}
