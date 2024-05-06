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
@RequestMapping("employee")
public class EmployeeController {

    /*private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }*/

/*    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeDTO saveEmployee(@RequestPart("employeeCode") String employeeCode,
                                    @RequestPart("employeeName") String employeeName,
                                    @RequestPart("proPic") String proPic,
                                    @RequestPart("gender") Gender gender,
                                    @RequestPart("status") String status,
                                    @RequestPart("designation") String designation,
                                    @RequestPart("role") Role role,
                                    @RequestPart("DOB") Date DOB,
                                    @RequestPart("joinDate") Date joinDate,
                                    @RequestPart("attachBranch") String attachBranch,
                                    @RequestPart("addressLine1") String addressLine1,
                                    @RequestPart("addressLine2") String addressLine2,
                                    @RequestPart("addressLine3") String addressLine3,
                                    @RequestPart("addressLine4") String addressLine4,
                                    @RequestPart("addressLine5") String addressLine5,
                                    @RequestPart("contact") String contact,
                                    @RequestPart("email") String email,
                                    @RequestPart("guardian") String guardian,
                                    @RequestPart("emergContact") String emergContact) {

        String base64ProfilePic = Base64.getEncoder().encodeToString(proPic.getBytes());
        EmployeeDTO employeeDTO = new EmployeeDTO(employeeCode,employeeName,base64ProfilePic,gender,status,designation,role,DOB,joinDate,attachBranch,addressLine1,addressLine2,addressLine3,addressLine4,addressLine5,contact,email,guardian,emergContact);
        return employeeService.saveEmployee(employeeDTO);
    }
    @PutMapping
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable("employeeCode") String employeeCode){
        employeeService.deleteEmployee(employeeCode);
    }*/

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


