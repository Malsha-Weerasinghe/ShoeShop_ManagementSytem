package lk.ijse.shoeShop.repository;

import lk.ijse.shoeShop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findTopByOrderByCustomerCodeDesc();

    List<Customer> findByCustomerNameStartingWith(String customerName);

    @Query(value = "SELECT customer_code FROM customer ORDER BY customer_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
