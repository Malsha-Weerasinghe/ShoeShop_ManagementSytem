package lk.ijse.shoeShop.controller;


import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.dto.InventoryDTO;
import lk.ijse.shoeShop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping
    public InventoryDTO saveInventory(
            @RequestPart("itemCode")  String itemCode,
            @RequestPart("itemDescription") String itemDescription,
            @RequestPart("itemPic") String itemPic,
            @RequestPart("category") String category,
            @RequestPart("size") int size,
            @RequestPart("supplierCode") String supplierCode,
            @RequestPart("supplierName") String supplierName,
            @RequestPart("unitPriceSale") Double unitPriceSale,
            @RequestPart("unitPriceBuy") Double unitPriceBuy,
            @RequestPart("qty") int qty,
            @RequestPart("expectedProfit") Double expectedProfit,
            @RequestPart("profitMargin") Double profitMargin,
            @RequestPart("status") String status) {

        String base64ProfilePic = Base64.getEncoder().encodeToString(itemPic.getBytes());
        InventoryDTO inventoryDTO = new InventoryDTO(itemCode,itemDescription,base64ProfilePic,category,size,supplierCode,supplierName,unitPriceSale,unitPriceBuy,qty,expectedProfit,profitMargin,status);
        return inventoryService.saveInventory(inventoryDTO);
    }

    @PostMapping("/save")
    public InventoryDTO save(@RequestBody InventoryDTO inventoryDTO){
        System.out.println(inventoryDTO);
//        customerDTO.setCode(customerService.generateNextId());
        return inventoryService.saveInventory(inventoryDTO);
    }

    @PutMapping
    public InventoryDTO updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.updateInventory(inventoryDTO);
    }

    @DeleteMapping
    public void deleteInventory(@PathVariable("itemCode") String itemCode){
        inventoryService.deleteInventory(itemCode);
    }

}
