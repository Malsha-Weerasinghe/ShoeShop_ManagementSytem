package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.entity.Employee;
import lk.ijse.shoeShop.repository.EmployeeRepo;
import lk.ijse.shoeShop.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepo employeeRepo;
    ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepo.findAll().stream().map(
                employee -> mapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getEmployeeDetails(String employeeCode) {
        return null;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeCode(UUID.randomUUID().toString());
        return mapper.map(employeeRepo.save(mapper.map(
               employeeDTO , Employee.class)), EmployeeDTO.class);
    }

    @Override
    public void updateEmployee(String employeeCode, EmployeeDTO employeeDTO) {

    }

    @Override
    public void deleteEmployee(String employeeCode) {

    }
}
