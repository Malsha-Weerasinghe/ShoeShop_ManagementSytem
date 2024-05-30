package lk.ijse.shoeShop.Service;


import lk.ijse.shoeShop.reqAndResp.response.JwtAuthResponse;
import lk.ijse.shoeShop.reqAndResp.secure.SignIn;
import lk.ijse.shoeShop.reqAndResp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);

    JwtAuthResponse refreshToken(String accessToken);
}
