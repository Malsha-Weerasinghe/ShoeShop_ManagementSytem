package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.Dto.OrderDto;
import lk.ijse.shoeShop.Dto.ReturnDto;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void saveOrder(OrderDto orderDto);
    String returnOrder(ReturnDto returnDto);

    String getLastOrderId();

    List<OrderDto> getAllOrders();

    String getNextReturnId();

    OrderDto searchOrder(String searchOrderId);

    Double totalSaleGet(String date);

    int mostSaleItemQtyGet(Date date);

    String mostSaleItemImgGet(Date date);

    List<OrderDto> branchWiseOrderDetailsGet(String branch);

    List<OrderDto> employeeSaleAllOrdersGet(String empMail);

    //TODO
//    String mostSaleItemGet();


}