package pe.utec.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.utec.model.Sale;
import pe.utec.model.SaleDetail;

import java.util.List;

public interface ISaleDetailsRepo extends IGenericRepo<SaleDetail, Integer> {
    @Query(value = "SELECT saleDetail FROM SaleDetail saleDetail WHERE saleDetail.sale.id = :idSale")
    List<SaleDetail> findSaleId(@Param("idSale") Integer id);
}
