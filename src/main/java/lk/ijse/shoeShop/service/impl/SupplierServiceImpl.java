package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.entity.SupplierEntity;
import lk.ijse.shoeShop.repository.SupplierRepo;
import lk.ijse.shoeShop.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    SupplierRepo supplierRepo;
    ModelMapper mapper;

    public SupplierServiceImpl(SupplierRepo supplierRepo, ModelMapper mapper) {
        this.supplierRepo = supplierRepo;
        this.mapper = mapper;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepo.findAll().stream().map(
                supplier -> mapper.map(supplier, SupplierDTO.class)).toList();
    }

    @Override
    public SupplierDTO getSuppliersDetails(String supplierCode) {
        return null;
    }

    @Override
    public SupplierDTO saveSuppliers(SupplierDTO supplierDTO) {
        supplierDTO.setSupplierCode(UUID.randomUUID().toString());
        return mapper.map(supplierRepo.save(mapper.map(
                supplierDTO , SupplierEntity.class)), SupplierDTO.class);
    }

    @Override
    public void updateSuppliers(String supplierCode, SupplierDTO supplierDTO) {

    }

    @Override
    public void deleteSuppliers(String supplierCode) {

    }
}
