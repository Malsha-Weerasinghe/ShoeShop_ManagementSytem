package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, String> {
   /* List<Inventory> findByItemCodeStartingWith(String item_code);*/

    @Query(value = "SELECT item_code FROM inventory ORDER BY item_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

}
