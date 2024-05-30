package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);
    String generateToken(UserEntity userEntity);
    boolean isTokenValid(String token,UserDetails userDetails);
}
