package lk.ijse.shoeShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sales_Details")
public class SalesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int salesId;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "unit_price_sale", nullable = false)
    private Double unitPriceSale;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_code" , referencedColumnName = "item_code")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "order_no" , referencedColumnName = "order_no")
    private Sales sales;

}

