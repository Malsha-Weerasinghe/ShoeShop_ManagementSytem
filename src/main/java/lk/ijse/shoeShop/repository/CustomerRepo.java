package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
