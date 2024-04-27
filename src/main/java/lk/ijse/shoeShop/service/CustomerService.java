package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetails(String customerCode);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String customerCode, CustomerDTO customerDTO);
    void deleteCustomer(String customerCode);
}
