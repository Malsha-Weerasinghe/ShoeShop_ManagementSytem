package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    String saveEmployee(EmployeeDto employeeDto);
    EmployeeDto searchEmployee(String searchEmployeeId);
    void updateEmployee(String updateEmpId , EmployeeDto employeeDto);
    String deleteEmployee(String email , String id);
}
