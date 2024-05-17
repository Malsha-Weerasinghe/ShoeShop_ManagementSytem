package lk.ijse.shoeShop.entity;

import jakarta.persistence.*;
import lk.ijse.shoeShop.util.Status;
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
    private String item_code;
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
    @Enumerated(EnumType.STRING)
    private Status status;

}
