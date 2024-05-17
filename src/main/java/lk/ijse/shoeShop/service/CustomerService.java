package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    boolean deleteCustomer(String customerCode);
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> searchCustomer(String customerName);

    @ResponseBody
    CustomDTO customerIdGenerate();
}
