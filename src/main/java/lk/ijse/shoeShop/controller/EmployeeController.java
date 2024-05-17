package lk.ijse.shoeShop.controller;


import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.service.CustomerService;
import lk.ijse.shoeShop.service.EmployeeService;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.sql.Date;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        System.out.println("employee working !");
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/save")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO);
//        customerDTO.setCode(customerService.generateNextId());
        return employeeService.saveEmployee(employeeDTO);
    }

    @PostMapping("/update")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO);
        return employeeService.updateEmployee(employeeDTO);
    }

    @GetMapping("/nextId")
    public String nextId(){
        return employeeService.generateNextId();
    }

    @GetMapping("/search")
    public List<EmployeeDTO> search(@RequestParam("employeeName") String employeeName){
        return employeeService.searchEmployee(employeeName);
    }

    @DeleteMapping("/delete/{employeeCode}")
    public void delete(@PathVariable("employeeCode") String employeeCode){
        employeeService.deleteEmployee(employeeCode);
    }
}


