package lk.ijse.shoeShop.Dto;

import lk.ijse.shoeShop.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReturnDto {
    private String returnId;
    private String itemId;
    private String itemDes;
    private String size;
    private String qty;
    private String returnDate;
    private OrderEntity orderEntity;
}
