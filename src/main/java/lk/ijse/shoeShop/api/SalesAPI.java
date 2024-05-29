package lk.ijse.shoeShop.api;

import jakarta.validation.Valid;
import lk.ijse.shoeShop.dto.SaleDTO;
import lk.ijse.shoeShop.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v0/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})
public class SalesAPI {
    private final SaleService saleService;

    public SalesAPI(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<SaleDTO> getAllSales(){
        return saleService.getAllSales();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    SaleDTO saveSales(@Valid @RequestBody SaleDTO salesDTO){
        System.out.println(salesDTO);
        return saleService.saveSales(salesDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateSales(@Valid @RequestBody SaleDTO salesDTO){
        saleService.updateSales(salesDTO.getOrderNo(),salesDTO);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteSales(@PathVariable("id") String id){
        saleService.deleteSales(id);
    }

    @PatchMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    SaleDTO getSales(@PathVariable("id") String id){
        return saleService.getSaleDetails(id);
    }

    @GetMapping("/nextordercode")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String getNextOrderCode(){
        return saleService.nextOrderCode();
    }
}
