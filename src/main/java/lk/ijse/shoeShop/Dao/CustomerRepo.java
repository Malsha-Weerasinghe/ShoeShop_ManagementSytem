package lk.ijse.shoeShop.Dao;

import lk.ijse.shoeShop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
