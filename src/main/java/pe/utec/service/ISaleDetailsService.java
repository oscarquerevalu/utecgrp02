package pe.utec.service;

import org.springframework.data.repository.query.Param;
import pe.utec.model.Sale;
import pe.utec.model.SaleDetail;

import java.util.List;

public interface ISaleDetailsService extends ICRUD<SaleDetail, Integer>{

    List<SaleDetail> findSaleId(@Param("idSale") Integer id);

}
