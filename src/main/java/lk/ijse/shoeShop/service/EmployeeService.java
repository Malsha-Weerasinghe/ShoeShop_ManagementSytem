package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeDetails(String id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(String id, EmployeeDTO employeeDTO);
    void deleteEmployee(String id);
    String nextEmployeeCode();

    /*@ResponseBody
    CustomDTO employeeIdGenerate();*/
}
