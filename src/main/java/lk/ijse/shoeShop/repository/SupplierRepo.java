package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.EmployeeEntity;
import lk.ijse.shoeShop.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {
}
