package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*@Repository*/
public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findByCustomerCode(String id);
    Boolean existsByCustomerCode(String id);
    void deleteByCustomerCode(String id);
    @Query(value = "SELECT customer_code FROM Customers ORDER BY customer_code DESC LIMIT 1", nativeQuery = true)
    String findLatestCustomerCode();
}