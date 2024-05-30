package lk.ijse.shoeShop.Service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoeShop.Dao.SizeRepo;
import lk.ijse.shoeShop.Service.StockService;
import lk.ijse.shoeShop.entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockServiceIMPL implements StockService {
    @Autowired
    SizeRepo sizeRepo;
    @Override
    public List<StockEntity> getAllStock() {
        List<StockEntity> allStock = sizeRepo.findAll();
        return allStock;
    }
}
