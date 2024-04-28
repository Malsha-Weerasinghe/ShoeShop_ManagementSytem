package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllCustomers();
    EmployeeDTO getEmployeeDetails(String employeeCode);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(String employeeCode, EmployeeDTO EmployeeDTO);
    void deleteEmployee(String EmployeeCode);
}
