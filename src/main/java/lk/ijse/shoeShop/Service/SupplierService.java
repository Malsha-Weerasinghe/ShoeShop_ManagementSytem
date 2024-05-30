package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.Dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    List<SupplierDto> getAllSuppliers();
    void saveSupplier(SupplierDto supplierDto);
    SupplierDto searchSupplier(String searchSupplierId);
    String updateSupplier(String updateSupplierId, SupplierDto supplierDto);
    String deleteSupplier(String deleteSupplierId);

}
