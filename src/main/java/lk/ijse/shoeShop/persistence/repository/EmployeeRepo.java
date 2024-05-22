package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*@Repository*/
public interface EmployeeRepo extends JpaRepository<Employees,String> {
    //List<Employee>findAllByAndOrderByDobDesc();
    Boolean existsByEmployeeCode(String id);
    Employees findByEmployeeCode(String id);
    void deleteByEmployeeCode(String id);
    @Query(value = "SELECT employee_code FROM Employee ORDER BY employee_code DESC LIMIT 1", nativeQuery = true)
    String findLatestEmployeeCode();
}
