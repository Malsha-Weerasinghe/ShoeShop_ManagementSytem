package lk.ijse.shoeShop.service.util;

import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.SupplierDTO;
import lk.ijse.shoeShop.entity.Customer;
import lk.ijse.shoeShop.entity.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    @Autowired
    ModelMapper mapper;

    //constructor injection
    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CustomerDTO fromCustomerEntity(Customer customer){
        CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public Customer toCustomerEntity(CustomerDTO customerDTO){
        Customer customer = mapper.map(customerDTO, Customer.class);
        return customer;
    }

    public SupplierDTO fromSupplierEntity(Supplier supplier){
        SupplierDTO supplierDTO = mapper.map(supplier, SupplierDTO.class);
        return supplierDTO;
    }

    public Supplier toSupplierEntity(SupplierDTO supplierDTO){
        Supplier supplier = mapper.map(supplierDTO, Supplier.class);
        return supplier;
    }




}
