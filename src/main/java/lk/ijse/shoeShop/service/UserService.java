package lk.ijse.shoeShop.service;

import lk.ijse.shoeShop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailService();
    void Save(UserDTO userDTO);
}
