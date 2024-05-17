package lk.ijse.shoeShop.controller;


import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.dto.InventoryDTO;
import lk.ijse.shoeShop.service.CustomerService;
import lk.ijse.shoeShop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        System.out.println("Inventory Working");
    }

    @GetMapping("/getAllItems")
    public List<InventoryDTO> getAllItems(){
        return inventoryService.getAllInventory();
    }

    @PostMapping("/save")
    public InventoryDTO save(@RequestBody InventoryDTO inventoryDTO){
        System.out.println(inventoryDTO);
        return inventoryService.saveInventory(inventoryDTO);
    }

    @PostMapping("/update")
    public InventoryDTO update(@RequestBody InventoryDTO inventoryDTO){
        System.out.println(inventoryDTO);
        return inventoryService.updateInventory(inventoryDTO);
    }

    @DeleteMapping("/delete/{item_code}")
    public void delete(@PathVariable("item_code") String item_code){
        inventoryService.deleteInventory(item_code);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/InventoryIdGenerate")
    public @ResponseBody
    CustomDTO inventoryIdGenerate() {
        return inventoryService.inventoryIdGenerate();
    }

    /*@GetMapping("/search")
    public List<InventoryDTO> search(@RequestParam("item_code") String item_code){
        return inventoryService.searchInventory(item_code);
    }*/
}
