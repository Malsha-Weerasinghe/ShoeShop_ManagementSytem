package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

/*@Repository*/
public interface SaleRepo extends JpaRepository<Sales,String> {
    Boolean existsByOrderNo(String id);
    Sales findByOrderNo(String id);
    void deleteByOrderNo(String id);
}
