package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,String> {
}
