package lk.ijse.shoeShop.service;


import lk.ijse.shoeShop.auth.request.SignInRequest;
import lk.ijse.shoeShop.auth.request.SignUpRequest;
import lk.ijse.shoeShop.auth.response.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignInRequest signInRequest);
    JwtAuthResponse signUp(SignUpRequest signUpRequest);
}
