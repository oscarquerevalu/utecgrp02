package pe.utec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.utec.model.Sale;
import pe.utec.model.SaleDetail;
import pe.utec.repo.IGenericRepo;
import pe.utec.repo.ISaleDetailsRepo;
import pe.utec.repo.ISaleRepo;
import pe.utec.service.ISaleDetailsService;
import pe.utec.service.ISaleService;

import java.util.List;

@Service
public class SaleDetailServiceImpl extends CRUDImpl<SaleDetail, Integer> implements ISaleDetailsService {

    @Autowired
    private ISaleDetailsRepo repo;

    @Override
    protected IGenericRepo<SaleDetail, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<SaleDetail> findSaleId(Integer id) {
        return repo.findSaleId(id);
    }
}
