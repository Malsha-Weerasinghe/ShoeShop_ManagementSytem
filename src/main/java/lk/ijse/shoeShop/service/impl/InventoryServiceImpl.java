package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.InventoryDTO;
import lk.ijse.shoeShop.entity.Inventory;
import lk.ijse.shoeShop.repository.InventoryRepo;
import lk.ijse.shoeShop.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired

    private ModelMapper modelMapper;
    @Autowired
    private InventoryRepo inventoryRepo;
    @Override
    public List<InventoryDTO> getAllInventory() {
        List<Inventory>userList=inventoryRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<CustomerDTO>>(){}.getType());

    }

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    @Override
    public void deleteInventory(String itemCode) {
        inventoryRepo.delete(modelMapper.map(itemCode, Inventory.class));
    }
}
