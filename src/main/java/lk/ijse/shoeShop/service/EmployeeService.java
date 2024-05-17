package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    boolean deleteEmployee(String employeeCode);
    List<EmployeeDTO> getAllEmployee();
    List<EmployeeDTO> searchEmployee(String employeeName);

    @ResponseBody
    CustomDTO employeeIdGenerate();
}
