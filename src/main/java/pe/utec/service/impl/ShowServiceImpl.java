package pe.utec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.utec.model.Customer;
import pe.utec.model.Show;
import pe.utec.repo.ICustomerRepo;
import pe.utec.repo.IGenericRepo;
import pe.utec.repo.IShowRepo;
import pe.utec.service.ICustomerService;
import pe.utec.service.IShowService;

@Service
public class ShowServiceImpl extends CRUDImpl<Show, Integer> implements IShowService {

    @Autowired
    private IShowRepo repo;

    @Override
    protected IGenericRepo<Show, Integer> getRepo() {
        return repo;
    }
}
