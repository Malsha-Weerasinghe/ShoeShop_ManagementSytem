package lk.ijse.shoeShop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDTO {
    private String itemCode;
    private String itemDescription;
    private String itemPic;
    private String category;
    private int size;
    private String supplierCode;
    private String supplierName;
    private Double unitPriceSale;
    private Double unitPriceBuy;
    private int qty;
    private Double expectedProfit;
    private Double profitMargin;
    private String status;

}
