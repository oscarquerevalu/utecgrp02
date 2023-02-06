package pe.utec.repo;

import pe.utec.model.Customer;

public interface ICustomerRepo extends IGenericRepo<Customer, Integer> {

    Customer findOneByEmail(String username);
}
