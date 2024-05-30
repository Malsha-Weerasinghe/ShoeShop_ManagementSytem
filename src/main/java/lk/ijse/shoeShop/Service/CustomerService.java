package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.Dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    void saveCustomer(CustomerDto customerDto);
    CustomerDto searchCustomer(String searchCustomerId);
    String updateCustomer(String updateCustomerId, CustomerDto updateCustomerDetailsDto);
    String deleteCustomer(String deleteCustomerId);

}
