package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<CustomerEntity,String> {
}
