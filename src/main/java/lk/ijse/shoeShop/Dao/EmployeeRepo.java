package lk.ijse.shoeShop.Dao;

import lk.ijse.shoeShop.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findByEmail(String email);
}
