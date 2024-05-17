package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.SaleDTO;
import lk.ijse.shoeShop.dto.SalesInventoryDTO;
import lk.ijse.shoeShop.entity.Sales;
import lk.ijse.shoeShop.entity.SalesDetails;
import lk.ijse.shoeShop.repository.SaleDetailsRepo;
import lk.ijse.shoeShop.repository.SaleRepo;
import lk.ijse.shoeShop.service.SaleService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    SaleRepo saleRepo;
    SaleDetailsRepo saleDetailsRepo;
    ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepo saleRepo, SaleDetailsRepo saleDetailsRepo, ModelMapper modelMapper) {
        this.saleRepo = saleRepo;
        this.saleDetailsRepo = saleDetailsRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepo.findAll().stream().map(
                sales -> modelMapper.map(sales, SaleDTO.class)
        ).toList();
    }

    @Override
    public SaleDTO getSaleDetails(String id) {
        if(!saleRepo.existsByOrderNo(id)){
            throw new NotFoundException("Sales "+id+" Not Found!");
        }
        SaleDTO salesDTO = modelMapper.map(saleRepo.findByOrderNo(id), SaleDTO.class);
        System.out.println("ID-----------------------"+id);
        List<SalesInventoryDTO> salesInventory = saleDetailsRepo.findAllBySalesOrderNo(id).stream().map(
                salesDetails -> modelMapper.map(salesDetails, SalesInventoryDTO.class)
        ).toList();
        salesDTO.setInventory(salesInventory);

        return salesDTO;
    }

    @Override
    public SaleDTO saveSales(SaleDTO salesDTO) {
        if(saleRepo.existsByOrderNo(salesDTO.getOrderNo())){
            throw new DuplicateRecordException("This Sales "+salesDTO.getOrderNo()+" already exist...");
        }
        SaleDTO newsalesDTO = modelMapper.map(saleRepo.save(modelMapper.map(
                salesDTO, Sales.class)), SaleDTO.class
        );

        List<SalesInventoryDTO> salesInventoryDTO = new ArrayList<>();
        for (SalesInventoryDTO inventoryDTO : salesDTO.getInventory()) {

            SalesDetails savedSaleDetails = saleDetailsRepo.save(modelMapper.map(inventoryDTO, SalesDetails.class));
            salesInventoryDTO.add(modelMapper.map(savedSaleDetails, SalesInventoryDTO.class));
        }
        newsalesDTO.setInventory(salesInventoryDTO);
        return newsalesDTO;
    }

    @Override
    public void updateSales(String id, SaleDTO salesDTO) {

        for (SalesInventoryDTO inventoryDTO : salesDTO.getInventory()) {
            if(!saleRepo.existsById(inventoryDTO.getId())){
                throw new NotFoundException("Update Failed; Sales id: " +
                        salesDTO.getOrderNo() + " does not exist");
            }
            saleDetailsRepo.save(modelMapper.map(inventoryDTO, SalesDetails.class));
        }
    }

    @Override
    public void deleteSales(String id) {

        if(!saleDetailsRepo.existsBySalesOrderNo(id)){
            throw  new NotFoundException("Sales "+ id + "Not Found...");
        }
        saleDetailsRepo.deleteAllBySalesOrderNo(id);
        saleRepo.deleteByOrderNo(id);
    }
}

