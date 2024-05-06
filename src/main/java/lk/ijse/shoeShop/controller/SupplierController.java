package lk.ijse.shoeShop.controller;

import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.service.EmployeeService;
import lk.ijse.shoeShop.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SupplierDTO> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @PostMapping
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.saveSupplier(supplierDTO);
    }

    @PutMapping
    public SupplierDTO updateSuplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.updateSupplier(supplierDTO);
    }

    @DeleteMapping
    public void deleteSupplier(@PathVariable("supplierCode") String supplierCode){
        supplierService.deleteSupplier(supplierCode);
    }

}
