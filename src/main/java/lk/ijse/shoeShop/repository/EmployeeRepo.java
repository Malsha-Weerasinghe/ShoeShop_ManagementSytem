package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
}
