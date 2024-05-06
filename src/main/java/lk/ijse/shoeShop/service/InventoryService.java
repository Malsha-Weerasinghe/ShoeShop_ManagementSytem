package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventory();

    InventoryDTO saveInventory(InventoryDTO inventoryDTO);

    InventoryDTO updateInventory(InventoryDTO inventoryDTO);

    void deleteInventory(String itemCode);

}
