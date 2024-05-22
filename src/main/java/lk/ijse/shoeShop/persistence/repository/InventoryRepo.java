package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/*@Repository*/
public interface InventoryRepo extends JpaRepository<Inventory,String> {
    Boolean existsByItemCode(String id);
    Inventory findByItemCode(String id);
    void deleteByItemCode(String id);
}
