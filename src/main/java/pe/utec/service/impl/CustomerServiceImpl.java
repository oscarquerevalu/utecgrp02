package pe.utec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.utec.model.Customer;
import pe.utec.repo.ICustomerRepo;
import pe.utec.repo.IGenericRepo;
import pe.utec.service.ICustomerService;

@Service
public class CustomerServiceImpl extends CRUDImpl<Customer, Integer> implements ICustomerService {

    @Autowired
    private ICustomerRepo repo;

    @Override
    protected IGenericRepo<Customer, Integer> getRepo() {
        return repo;
    }
}
