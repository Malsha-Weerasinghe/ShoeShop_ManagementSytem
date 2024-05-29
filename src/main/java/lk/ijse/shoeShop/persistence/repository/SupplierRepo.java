package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SupplierRepo extends JpaRepository<Supplier,String> {
    Boolean existsBySupplierCode(String id);
    Supplier findBySupplierCode(String id);
    void deleteBySupplierCode(String id);
    @Query(value = "SELECT supplier_code FROM Suppliers ORDER BY supplier_code DESC LIMIT 1", nativeQuery = true)
    String findLatestSupplierCode();
}
