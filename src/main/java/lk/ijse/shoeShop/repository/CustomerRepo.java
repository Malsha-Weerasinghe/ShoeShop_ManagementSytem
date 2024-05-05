package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findTopByOrderByCustomerCodeDesc();

    List<Customer> findByCustomerNameStartingWith(String customerName);
}
