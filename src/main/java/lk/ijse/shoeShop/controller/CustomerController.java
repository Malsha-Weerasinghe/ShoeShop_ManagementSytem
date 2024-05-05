package lk.ijse.shoeShop.controller;


import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
        System.out.println("customer working !");
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/save")
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
//        customerDTO.setCode(customerService.generateNextId());
        return customerService.saveCustomer(customerDTO);
    }

    @PostMapping("/update")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.updateCustomer(customerDTO);
    }

    @GetMapping("/nextId")
    public String nextId(){
        return customerService.generateNextId();
    }

    @GetMapping("/search")
    public List<CustomerDTO> search(@RequestParam("customerName") String customerName){
        return customerService.searchCustomer(customerName);
    }

    @DeleteMapping("/delete/{customerCode}")
    public void delete(@PathVariable("customerCode") String customerCode){
        customerService.deleteCustomer(customerCode);
    }
}
/*

 "customerCode":"C001",
         "customerName":"Malsha",
         "email":"malsha@gmail.com",
         "gender":"",
         "contact":"75518991",
         "dob":"",
         "addressLine1":"aluthgedara",
         "addressLine2":"akurugoda",
            "addressLine3":"kamburupitiya",
          "addressLine4":"matara",
          "addressLine5":"southern",
         "joinDate":"",
         "level":"",
         "purchaseDateTime":""
         "loyaltyPoints":2*/
