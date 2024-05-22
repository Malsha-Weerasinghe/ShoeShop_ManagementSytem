package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.InventoryDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventory();
    InventoryDTO getInventoryDetails(String id);
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
    void updateInventory(String id, InventoryDTO inventoryDTO);
    void deleteInventory(String id);

   /* @ResponseBody
    CustomDTO inventoryIdGenerate();*/


}
