package lk.ijse.shoeShop.persistence.repository;

import lk.ijse.shoeShop.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepo extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
}
