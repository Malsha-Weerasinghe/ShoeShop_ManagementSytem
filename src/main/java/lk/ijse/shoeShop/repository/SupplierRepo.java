package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierRepo extends JpaRepository<Supplier,String> {

    @Query(value = "SELECT supplier_code FROM supplier ORDER BY supplier_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

}
