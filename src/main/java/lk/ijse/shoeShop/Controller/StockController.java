package lk.ijse.shoeShop.Controller;


import lk.ijse.shoeShop.Service.StockService;
import lk.ijse.shoeShop.entity.StockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.PATCH, RequestMethod.DELETE ,RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping
    public List<StockEntity> getAllStock(){
        List<StockEntity> allStock = stockService.getAllStock();
        return allStock;
    }

    @GetMapping
    @RequestMapping("/sendInfoItemQty")
    public List<String> checkItemQtySendInfo(){
        List<String> itemQtyMassage = stockService.checkItemQtySendInfo();
        return itemQtyMassage;
    }
}