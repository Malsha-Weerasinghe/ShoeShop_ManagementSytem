package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
    //List<Employee>findAllByAndOrderByDobDesc();
    Boolean existsByEmployeeCode(String id);
    Employee findByEmployeeCode(String id);
    void deleteByEmployeeCode(String id);
    @Query(value = "SELECT employee_code FROM Employees ORDER BY employee_code DESC LIMIT 1", nativeQuery = true)
    String findLatestEmployeeCode();
}
