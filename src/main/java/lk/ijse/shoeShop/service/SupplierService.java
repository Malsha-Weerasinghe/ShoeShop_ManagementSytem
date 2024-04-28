package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO getSuppliersDetails(String supplierCode);
    SupplierDTO saveSuppliers(SupplierDTO supplierDTO);
    void updateSuppliers(String supplierCode, SupplierDTO supplierDTO);
    void deleteSuppliers(String supplierCode);
}
