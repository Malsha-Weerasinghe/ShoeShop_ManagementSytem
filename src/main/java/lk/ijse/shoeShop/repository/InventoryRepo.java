package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,String> {
}
