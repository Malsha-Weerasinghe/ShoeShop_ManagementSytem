package lk.ijse.shoeShop.Service.impl;

import lk.ijse.shoeShop.Dao.UserRepo;
import lk.ijse.shoeShop.Dto.UserDto;
import lk.ijse.shoeShop.Service.UserService;
import lk.ijse.shoeShop.convert.DataConvert;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final DataConvert dataConvert;

    private final ModelMapper mapper;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public void saveUser(UserDto userDTO) {
        userRepo.save(dataConvert.userDtoConvertUserEntity(userDTO));
    }

    @Override
    public UserDto searchUser(String id){
        return (UserDto) userRepo.findByEmail(id)
                .map(user -> mapper.map(user, UserDto.class)
                )
                .orElseThrow(() -> new RuntimeException("User Not Exist"));
    }
}
