package lk.ijse.shoeShop.persistence.repository;


import lk.ijse.shoeShop.persistence.entity.User;
import lk.ijse.shoeShop.util.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
    User findByEmailAndRole(String email, Role role);
    void deleteByEmail(String email);
    Optional<User> findByEmail(String email);

}
