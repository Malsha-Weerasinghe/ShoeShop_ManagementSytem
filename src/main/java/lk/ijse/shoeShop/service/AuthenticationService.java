package lk.ijse.shoeShop.service;


import lk.ijse.shoeShop.auth.Request.SignInRequest;
import lk.ijse.shoeShop.auth.Request.SignUpRequest;
import lk.ijse.shoeShop.auth.Response.JWTAuthResponse;

public interface AuthenticationService {

    JWTAuthResponse signIn(SignInRequest signInRequest);
    JWTAuthResponse signUp(SignUpRequest signUpRequest);
    JWTAuthResponse updateAccount(SignUpRequest signUpRequest);
}
