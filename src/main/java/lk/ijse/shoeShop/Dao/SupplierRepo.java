package lk.ijse.shoeShop.Dao;

import lk.ijse.shoeShop.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {
}