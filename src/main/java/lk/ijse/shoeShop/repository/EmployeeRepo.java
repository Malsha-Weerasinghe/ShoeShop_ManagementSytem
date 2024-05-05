package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
}
