package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.CustomDTO;
import lk.ijse.shoeShop.dto.CustomerDTO;
import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.entity.Customer;
import lk.ijse.shoeShop.entity.Employee;
import lk.ijse.shoeShop.repository.CustomerRepo;
import lk.ijse.shoeShop.repository.EmployeeRepo;
import lk.ijse.shoeShop.service.EmployeeService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new DuplicateRecordException("Employee Id is already exists !!");
        }
        return mapper.map(employeeRepo.save(mapper.map(employeeDTO, Employee.class)),EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if (!employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new NotFoundException("Can't find employee id !!");
        }
        return mapper.map(employeeRepo.save(mapper.map(employeeDTO, Employee.class)), EmployeeDTO.class);
    }

    @Override
    public boolean deleteEmployee(String employeeCode) {
        if (!employeeRepo.existsById(employeeCode)){
            throw new NotFoundException("Can't find employee id !!");
        }
        employeeRepo.deleteById(employeeCode);
        return false;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepo.findAll().stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public List<EmployeeDTO> searchEmployee(String employeeName) {

        return employeeRepo.findByEmployeeNameStartingWith(employeeName).stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public CustomDTO employeeIdGenerate() {
        return new CustomDTO(employeeRepo.getLastIndex());
    }

}
