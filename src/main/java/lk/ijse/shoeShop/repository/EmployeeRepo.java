package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Customer;
import lk.ijse.shoeShop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
    Employee findTopByOrderByEmployeeCodeDesc();

    List<Employee> findByEmployeeNameStartingWith(String customerName);
}
