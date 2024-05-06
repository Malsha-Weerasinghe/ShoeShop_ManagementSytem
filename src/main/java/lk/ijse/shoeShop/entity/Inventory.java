package lk.ijse.shoeShop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/*@Table(name = "inevetory")*/
public class Inventory {
    @Id
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
