package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.entity.Supplier;
import lk.ijse.shoeShop.repository.SupplierRepo;
import lk.ijse.shoeShop.service.SupplierService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {

        if (supplierRepo.existsById(supplierDTO.getSupplierCode())){
            throw new DuplicateRecordException("Customer Id is already exists !!");
        }
        return mapper.map(supplierRepo.save(mapper.map(supplierDTO, Supplier.class)), SupplierDTO.class);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {

        if (!supplierRepo.existsById(supplierDTO.getSupplierCode())){
            throw new NotFoundException("Can't find customer id !!");
        }
        return mapper.map(supplierRepo.save(mapper.map(supplierDTO, Supplier.class)), SupplierDTO.class);
    }

    @Override
    public boolean deleteSupplier(String supplierCode) {
        if (!supplierRepo.existsById(supplierCode)){
            throw new NotFoundException("Can't find supplier id !!");
        }
        return false;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepo.findAll().stream().map(supplier -> mapper.map(supplier, SupplierDTO.class)).toList();
    }

    /*@Override
    public List<SupplierDTO> searchSupplier(String supplierName) {
        return supplierRepo.findByNameStartingWith(supplierName).stream().map(supplier -> mapper.map(supplier, SupplierDTO.class)).toList();

    }*/

   /* @Override
    public String generateNextId() {
        String prefix = "S";
        String id = "";

        Supplier lastSupplier = supplierRepo.findTopByOrderByCodeDesc();
        int nextNumericPart;
        if (lastSupplier != null) {
            String lastCode = lastSupplier.getSupplierCode();
            String numericPartString = lastCode.substring(prefix.length());
            try {
                int numericPart = Integer.parseInt(numericPartString);
                nextNumericPart = numericPart + 1;
            } catch (NumberFormatException e) {
                nextNumericPart = 1;
            }
        } else {
            nextNumericPart = 1;
        }
        id = prefix + String.format("%03d", nextNumericPart);

        return id;
    }*/
}
