package lk.ijse.shoeShop.persistence.repository;


import lk.ijse.shoeShop.persistence.entity.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleDetailsRepo extends JpaRepository<SalesDetails,String> {
    Boolean existsBySalesOrderNo(String id);
    List<SalesDetails> findAllBySalesOrderNo(String id);
    void deleteAllBySalesOrderNo(String id);
    Boolean existsAllBySalesOrderNo(String id);
}
