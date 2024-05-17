package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Customer;
import lk.ijse.shoeShop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {
    Employee findTopByOrderByEmployeeCodeDesc();

    List<Employee> findByEmployeeNameStartingWith(String customerName);

    @Query(value = "SELECT employee_code FROM employee ORDER BY employee_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
