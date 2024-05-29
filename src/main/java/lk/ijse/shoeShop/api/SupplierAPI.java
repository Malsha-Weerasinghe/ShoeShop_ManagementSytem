package lk.ijse.shoeShop.api;

import jakarta.validation.Valid;
import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v0/suppliers")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})
public class SupplierAPI {
    private final SupplierService supplierService;

    public SupplierAPI(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierDTO> getAllSupplier(){
        return supplierService.getAllSuppliers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    SupplierDTO saveSupplier(@Valid @RequestBody SupplierDTO supplierDTO){
        return supplierService.saveSupplier(supplierDTO);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateSupplier(@PathVariable("id") String id,@Valid @RequestBody SupplierDTO supplierDTO){
        supplierService.updateSupplier(id,supplierDTO);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteSupplier(@PathVariable("id") String id){
        supplierService.deleteSupplier(id);
    }

    @PatchMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    SupplierDTO getSupplier(@PathVariable("id") String id){
        return supplierService.getSupplierDetails(id);
    }

    @GetMapping("/nextid")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String getNextSupplierCode(){
        return supplierService.genarateNextSupplierCode();
    }
}
