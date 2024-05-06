package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.entity.Supplier;
import lk.ijse.shoeShop.repository.SupplierRepo;
import lk.ijse.shoeShop.service.SupplierService;
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
    private ModelMapper modelMapper;
    @Autowired
    private SupplierRepo supplierRepo;
    @Override
    public List<SupplierDTO> getAllSupplier() {
        List<Supplier>userList=supplierRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<SupplierDTO>>(){}.getType());

    }

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        supplierRepo.save(modelMapper.map(supplierDTO, Supplier.class));
        return supplierDTO;
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        supplierRepo.save(modelMapper.map(supplierDTO, Supplier.class));
        return supplierDTO;
    }

    @Override
    public void deleteSupplier(String supplierCode) {
        supplierRepo.delete(modelMapper.map(supplierCode, Supplier.class));

    }
}
