package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    List<SaleDTO> getAllSales();
    SaleDTO getSaleDetails(String id);
    SaleDTO saveSales(SaleDTO salesDTO);
    void updateSales(String id, SaleDTO salesDTO);
    void deleteSales(String id);
}
