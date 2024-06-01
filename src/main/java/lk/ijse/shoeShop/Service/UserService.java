package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.Dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();
    void saveUser(UserDto userDTO);

    UserDto searchUser(String id);
}
