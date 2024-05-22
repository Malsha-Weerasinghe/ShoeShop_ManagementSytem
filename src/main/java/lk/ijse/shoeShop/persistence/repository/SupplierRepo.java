package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/*@Repository*/
public interface SupplierRepo extends JpaRepository<Suppliers,String> {
    Boolean existsBySupplierCode(String id);
    Suppliers findBySupplierCode(String id);
    void deleteBySupplierCode(String id);
    @Query(value = "SELECT supplier_code FROM Suppliers ORDER BY supplier_code DESC LIMIT 1", nativeQuery = true)
    String findLatestSupplierCode();

}
