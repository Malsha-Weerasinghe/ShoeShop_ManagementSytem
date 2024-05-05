package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.entity.Customer;
import lk.ijse.shoeShop.repository.CustomerRepo;
import lk.ijse.shoeShop.service.CustomerService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerCode())){
            throw new DuplicateRecordException("Customer Id is already exists !!");
        }
        return mapper.map(customerRepo.save(mapper.map(customerDTO, Customer.class)),CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCustomerCode())){
            throw new NotFoundException("Can't find customer id !!");
        }
        return mapper.map(customerRepo.save(mapper.map(customerDTO, Customer.class)), CustomerDTO.class);
    }

    @Override
    public boolean deleteCustomer(String customerCode) {
        if (!customerRepo.existsById(customerCode)){
            throw new NotFoundException("Can't find customer id !!");
        }
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public List<CustomerDTO> searchCustomer(String customerName) {

        return customerRepo.findByCustomerNameStartingWith(customerName).stream().map(customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public String generateNextId() {
        String prefix = "C";
        String customerCode = "";

        Customer lastCustomer = customerRepo.findTopByOrderByCustomerCodeDesc();
        int nextNumericPart;
        if (lastCustomer != null) {
            String lastCode = lastCustomer.getCustomerCode();
            String numericPartString = lastCode.substring(prefix.length());
            try {
                int numericPart = Integer.parseInt(numericPartString);
                nextNumericPart = numericPart + 1;
            } catch (NumberFormatException e) {
                nextNumericPart = 1;
            }
        } else {
            nextNumericPart = 1;
        }
        customerCode = prefix + String.format("%03d", nextNumericPart);

        return customerCode;

    }
}
