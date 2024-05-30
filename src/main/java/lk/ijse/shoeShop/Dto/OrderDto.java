package lk.ijse.shoeShop.Dto;

import lk.ijse.shoeShop.entity.CustomerEntity;
import lk.ijse.shoeShop.entity.EmployeeEntity;
import lk.ijse.shoeShop.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderCode;
    private Date purchaseDate;
    private String customerName;
    private String itemDesc;
    private int size;
    private double unitPrice;
    private int qty;
    private double total;
    private String paymentMethod;
    private double points;
    private String cashierName;
    private String orderStatus;
    CustomerEntity customerDetails;
    private List<ItemEntity> buyItem;
    private EmployeeEntity employeeEntity;
}
