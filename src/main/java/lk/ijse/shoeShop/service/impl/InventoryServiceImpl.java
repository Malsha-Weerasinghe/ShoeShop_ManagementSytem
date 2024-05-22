package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.InventoryDTO;
import lk.ijse.shoeShop.persistence.entity.Inventory;
import lk.ijse.shoeShop.persistence.repository.InventoryRepo;
import lk.ijse.shoeShop.service.InventoryService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
    InventoryRepo inventoryRepository;
    ModelMapper modelMapper;

    public InventoryServiceImpl(InventoryRepo inventoryRepository, ModelMapper modelMapper) {
        this.inventoryRepository = inventoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        return inventoryRepository.findAll().stream().map(
                inventory -> modelMapper.map(inventory, InventoryDTO.class)
        ).toList();
    }

    @Override
    public InventoryDTO getInventoryDetails(String id) {
        if(!inventoryRepository.existsByItemCode(id)){
            throw new NotFoundException("Inventory "+id+" Not Found!");
        }
        return modelMapper.map(inventoryRepository.findByItemCode(id), InventoryDTO.class);
    }

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        if(inventoryRepository.existsByItemCode(inventoryDTO.getItemCode())){
            throw new DuplicateRecordException("This Inventory "+inventoryDTO.getItemCode()+" already exicts...");
        }
        return modelMapper.map(inventoryRepository.save(modelMapper.map(
                inventoryDTO, Inventory.class)), InventoryDTO.class
        );
    }

    @Override
    public void updateInventory(String id, InventoryDTO inventoryDTO) {
        Inventory existingInventory = inventoryRepository.findByItemCode(id);

        if(existingInventory.getItemCode().isEmpty()){
            throw new NotFoundException("Inventory "+ id + "Not Found...");
        }

        existingInventory.setItemDescription(inventoryDTO.getItemDescription());
        existingInventory.setItemPicture(inventoryDTO.getItemPicture());

        inventoryRepository.save(existingInventory);
    }

    @Override
    public void deleteInventory(String id) {
        if(!inventoryRepository.existsByItemCode(id)){
            throw  new NotFoundException("Inventory "+ id + "Not Found...");
        }
        inventoryRepository.deleteByItemCode(id);
    }
}
