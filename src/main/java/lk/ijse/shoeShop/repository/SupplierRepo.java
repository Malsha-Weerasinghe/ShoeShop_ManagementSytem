package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierRepo extends JpaRepository<Supplier,String> {

   /* Supplier findTopByOrderByCodeDesc();

    List<Supplier> findByNameStartingWith(String supplierName);*/

}
