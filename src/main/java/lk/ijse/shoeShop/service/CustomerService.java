package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    boolean deleteCustomer(String customerCode);
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> searchCustomer(String customerName);

    String generateNextId();
}
