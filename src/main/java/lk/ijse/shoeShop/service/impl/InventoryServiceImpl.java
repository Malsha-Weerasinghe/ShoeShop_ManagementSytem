package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.dto.InventoryDTO;
import lk.ijse.shoeShop.entity.Employee;
import lk.ijse.shoeShop.entity.Inventory;
import lk.ijse.shoeShop.repository.InventoryRepo;
import lk.ijse.shoeShop.service.InventoryService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return modelMapper.map(userList,new TypeToken<List<InventoryDTO>>(){}.getType());

    }

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        if (inventoryRepo.existsById(inventoryDTO.getItem_code())){
            throw new DuplicateRecordException("Inventory Id is already exists !!");
        }
        return modelMapper.map(inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class)),InventoryDTO.class);
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        if (!inventoryRepo.existsById(inventoryDTO.getItem_code())){
            throw new NotFoundException("Can't find inventory id !!");
        }
        return modelMapper.map(inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class)), InventoryDTO.class);
    }

    @Override
    public boolean deleteInventory(String item_code) {
        if (!inventoryRepo.existsById(item_code)){
            throw new NotFoundException("Can't find item id !!");
        }
        inventoryRepo.deleteById(item_code);
        return false;
    }


    @Override
    public CustomDTO inventoryIdGenerate() {
        return new CustomDTO(inventoryRepo.getLastIndex());
    }

    /*@Override
    public List<InventoryDTO> searchInventory(String item_code) {
        List<Inventory> inventoryEntities = inventoryRepo.findByItemCodeStartingWith(item_code);
        if (inventoryEntities.isEmpty()) {
            throw new NotFoundException("No items found with item code starting with: " + item_code);
        }
        return inventoryEntities.stream()
                .map(inventory -> modelMapper.map(inventory, InventoryDTO.class))
                .collect(Collectors.toList());
    }*/
}
