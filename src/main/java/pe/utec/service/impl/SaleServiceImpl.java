package pe.utec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.utec.model.Sale;
import pe.utec.model.Show;
import pe.utec.repo.IGenericRepo;
import pe.utec.repo.ISaleRepo;
import pe.utec.repo.IShowRepo;
import pe.utec.service.ISaleService;
import pe.utec.service.IShowService;

@Service
public class SaleServiceImpl extends CRUDImpl<Sale, Integer> implements ISaleService {

    @Autowired
    private ISaleRepo repo;

    @Override
    protected IGenericRepo<Sale, Integer> getRepo() {
        return repo;
    }
}
