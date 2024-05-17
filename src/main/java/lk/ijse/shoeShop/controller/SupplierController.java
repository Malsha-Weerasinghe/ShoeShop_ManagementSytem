package lk.ijse.shoeShop.controller;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.service.EmployeeService;
import lk.ijse.shoeShop.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    public SupplierController() {
        System.out.println("supplier working !");
    }

    @GetMapping("/getAllSuppliers")
    public List<SupplierDTO> getAllCustomers(){
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/save")
    public SupplierDTO save(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO);
        return supplierService.saveSupplier(supplierDTO);
    }

    @PostMapping("/update")
    public SupplierDTO update(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO);
        return supplierService.updateSupplier(supplierDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/SupplierIdGenerate")
    public @ResponseBody
    CustomDTO supplierIdGenerate() {
        return supplierService.supplierIdGenerate();
    }

    @DeleteMapping("/delete/{supplierCode}")
    public void delete(@PathVariable("supplierCode") String supplierCode){
        supplierService.deleteSupplier(supplierCode);
    }

}
