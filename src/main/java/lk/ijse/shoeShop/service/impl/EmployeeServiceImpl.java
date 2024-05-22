package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.EmployeeDTO;
import lk.ijse.shoeShop.persistence.entity.Employees;
import lk.ijse.shoeShop.persistence.repository.CustomerRepo;
import lk.ijse.shoeShop.persistence.repository.EmployeeRepo;
import lk.ijse.shoeShop.service.EmployeeService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepo employeeRepository;
    ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(
                employee -> modelMapper.map(employee, EmployeeDTO.class)
        ).toList();
    }

    @Override
    public EmployeeDTO getEmployeeDetails(String id) {
        if(!employeeRepository.existsByEmployeeCode(id)){
            throw new NotFoundException("Employee "+id+" Not Found!");
        }
        return modelMapper.map(employeeRepository.findByEmployeeCode(id), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepository.existsByEmployeeCode(employeeDTO.getEmployeeCode())){
            throw new DuplicateRecordException("This Employee "+employeeDTO.getEmployeeCode()+" already exicts...");
        }
        return modelMapper.map(employeeRepository.save(modelMapper.map(
                employeeDTO, Employees.class)), EmployeeDTO.class
        );
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        if(!employeeRepository.existsByEmployeeCode(id)){
            throw new NotFoundException("Employee ID"+ id + "Not Found...");
        }
        employeeDTO.setEmployeeCode(id);
        employeeRepository.save(modelMapper.map(employeeDTO, Employees.class));
    }

    @Override
    public void deleteEmployee(String id) {
        if(!employeeRepository.existsByEmployeeCode(id)){
            throw  new NotFoundException("Employee ID"+ id + "Not Found...");
        }
        employeeRepository.deleteByEmployeeCode(id);
    }

    @Override
    public String nextEmployeeCode() {
        String lastEmployeeCode = employeeRepository.findLatestEmployeeCode();
        if(lastEmployeeCode==null){lastEmployeeCode = "EM000";}
        int numericPart = Integer.parseInt(lastEmployeeCode.substring(3));
        numericPart++;
        String nextEmployeeCode = "EM" + String.format("%03d", numericPart);
        return nextEmployeeCode;
    }

}
