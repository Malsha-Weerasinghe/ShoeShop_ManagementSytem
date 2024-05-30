package lk.ijse.shoeShop.Service;

import java.time.LocalDate;
import java.util.Date;

public interface DateServices {
    LocalDate orderLastReturnDay(Date orderPurchaseDate);
}
