package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetails(String id);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
    String genarateNextCustomerCode();

    /*@ResponseBody
    CustomDTO customerIdGenerate();*/
}
