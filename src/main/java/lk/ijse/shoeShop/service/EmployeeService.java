package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeDetails(String employeeCode);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(String employeeCode, EmployeeDTO employeeDTO);
    void deleteEmployee(String employeeCode);
}
