package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.SupplierDTO;


import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO getSupplierDetails(String id);
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    void updateSupplier(String id, SupplierDTO supplierDTO);
    void deleteSupplier(String id);
    String genarateNextSupplierCode();
}
