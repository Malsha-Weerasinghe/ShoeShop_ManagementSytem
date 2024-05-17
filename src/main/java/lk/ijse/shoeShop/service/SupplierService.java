package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    SupplierDTO updateSupplier(SupplierDTO supplierDTO);
    boolean deleteSupplier(String supplierCode);
    List<SupplierDTO> getAllSuppliers();
  /*  List<SupplierDTO> searchSupplier(String supplierName);*/
   /* String generateNextId();*/
}
