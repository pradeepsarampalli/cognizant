package DI;

public class CustomerService {
    CustomerRepository customerRepository;
    CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public void find(){
        customerRepository.findCustomerById();
    }


}
