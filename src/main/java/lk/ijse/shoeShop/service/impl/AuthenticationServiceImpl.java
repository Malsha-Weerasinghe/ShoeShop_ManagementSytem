/*
package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.auth.Request.SignInRequest;
import lk.ijse.shoeShop.auth.Request.SignUpRequest;
import lk.ijse.shoeShop.auth.Response.JWTAuthResponse;
import lk.ijse.shoeShop.dto.UserDTO;
import lk.ijse.shoeShop.entity.User;
import lk.ijse.shoeShop.repository.SecurityRepository;
import lk.ijse.shoeShop.service.AuthenticationService;
import lk.ijse.shoeShop.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final SecurityRepository securityRepository;
    private final ModelMapper mapper;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        User user =securityRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String generatedToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(SignUpRequest signUpRequest) {
        UserDTO userDTO = UserDTO.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        User savedUser = securityRepository.save(mapper.map(userDTO, User.class));
        String generatedToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }
}
*/
