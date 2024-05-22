package lk.ijse.shoeShop.controller;


import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.service.CustomerService;
import lk.ijse.shoeShop.service.EmployeeService;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("api/v0/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDTO saveEmployee(@RequestPart("data") EmployeeDTO employeeDTO,@RequestPart("profilepic") MultipartFile profilepic){
        String base64ProfilePic = null;
        try {
            base64ProfilePic = Base64.getEncoder().encodeToString(profilepic.getBytes());
            employeeDTO.setEmployeeProfilePic(
                    base64ProfilePic
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateEmployee(@RequestPart("data") EmployeeDTO employeeDTO,@RequestPart("profilepic")MultipartFile profilepic){
        String base64ProfilePic = null;
        try {
            base64ProfilePic = Base64.getEncoder().encodeToString(profilepic.getBytes());
            employeeDTO.setEmployeeProfilePic(
                    base64ProfilePic
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeService.updateEmployee(employeeDTO.getEmployeeCode(),employeeDTO);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteEmployee(@PathVariable("id") String customerCode){
        employeeService.deleteEmployee(customerCode);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    EmployeeDTO getEmployee(@PathVariable("id") String id){
        return employeeService.getEmployeeDetails(id);
    }

    @GetMapping("/nextid")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String getNextEmployeeCode(){
        return employeeService.nextEmployeeCode();
    }
}


