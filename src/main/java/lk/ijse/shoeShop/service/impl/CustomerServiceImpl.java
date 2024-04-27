package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.entity.CustomerEntity;
import lk.ijse.shoeShop.repository.CustomerRepo;
import lk.ijse.shoeShop.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    CustomerRepo customerRepo;
    ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(
                customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public CustomerDTO getCustomerDetails(String customerCode) {
        return null;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerCode(UUID.randomUUID().toString());
        return mapper.map(customerRepo.save(mapper.map(
                customerDTO, CustomerEntity.class)), CustomerDTO.class);
    }

    @Override
    public void updateCustomer(String customerCode, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String customerCode) {

    }
}
