public class Main {
    public static void main(String[] args) {
       CustomerRepository repository = new CustomerRepositoryImpl();
       CustomerService service = new CustomerService(repository);
       System.out.println(service.find(1)?"Yes":"No");
    }
}