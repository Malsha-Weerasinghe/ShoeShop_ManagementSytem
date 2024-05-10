package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<Sales,String> {

    Boolean existsByOrderNo(String id);
    Sales findByOrderNo(String id);
    void deleteByOrderNo(String id);
}
