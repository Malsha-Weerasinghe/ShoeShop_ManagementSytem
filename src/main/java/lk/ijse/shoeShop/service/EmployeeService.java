package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    boolean deleteEmployee(String employeeCode);
    List<EmployeeDTO> getAllEmployee();
    List<EmployeeDTO> searchEmployee(String employeeName);

    String generateNextId();
}
