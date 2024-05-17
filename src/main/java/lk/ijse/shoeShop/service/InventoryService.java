package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.InventoryDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventory();

    InventoryDTO saveInventory(InventoryDTO inventoryDTO);

    InventoryDTO updateInventory(InventoryDTO inventoryDTO);

    void deleteInventory(String item_code);

    @ResponseBody
    CustomDTO inventoryIdGenerate();


}
