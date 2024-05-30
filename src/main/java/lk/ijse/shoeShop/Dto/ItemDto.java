package lk.ijse.shoeShop.Dto;


import lk.ijse.shoeShop.entity.OrderEntity;
import lk.ijse.shoeShop.entity.StockEntity;
import lk.ijse.shoeShop.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class ItemDto {
    private String itemCode;
    private String itemDesc;
    private String itemPic;
    private String Category;
    private String verities;
    private String occasion;
    private String itemType;
    private double unitPriceSale;
    private double expectedProfit;
    private double profitMargin;
    private String status;
    private double buyPrice;
    private List<SupplierEntity> supplierEntityList;
    private List<OrderEntity> orderEntityList;
    private List<StockEntity> stockEntityList;






}
