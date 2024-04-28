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
@RequestMapping("api/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    SupplierDTO saveSuppliers(@RequestBody SupplierDTO supplierDTO){ return supplierService.saveSuppliers(supplierDTO);
    }
}
