package lk.ijse.shoeShop.service;


public interface AuthenticationService {

    JWTAuthResponse signIn(SignInRequest signInRequest);
    JWTAuthResponse signUp(SignUpRequest signUpRequest);
}
