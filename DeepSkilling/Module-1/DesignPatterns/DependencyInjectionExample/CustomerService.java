public class CustomerService {
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }
    public boolean find(int id){
        return repository.findCustomerById(id);
    }
}