package lk.ijse.shoeShop.service.impl;

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
    /*EmployeeRepo employeeRepo;
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

    }*/
/*
    @Autowired

    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee>userList=employeeRepo.findAll();
        *//*return modelMapper.map(userList,new TypeToken<List<CustomerDTO>>(){}.getType());*//*
        return modelMapper.map(userList,new TypeToken<List<EmployeeDTO>>(){}.getType());
    }
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {

        employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(String employeeCode) {
        employeeRepo.delete(modelMapper.map(employeeCode, Employee.class));

    }*/

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
    public String generateNextId() {
        String prefix = "E";
        String employeeCode = "";

        Employee lastEmployee = employeeRepo.findTopByOrderByEmployeeCodeDesc();
        int nextNumericPart;
        if (lastEmployee != null) {
            String lastCode = lastEmployee.getEmployeeCode();
            String numericPartString = lastCode.substring(prefix.length());
            try {
                int numericPart = Integer.parseInt(numericPartString);
                nextNumericPart = numericPart + 1;
            } catch (NumberFormatException e) {
                nextNumericPart = 1;
            }
        } else {
            nextNumericPart = 1;
        }
        employeeCode = prefix + String.format("%03d", nextNumericPart);

        return employeeCode;

    }

}
