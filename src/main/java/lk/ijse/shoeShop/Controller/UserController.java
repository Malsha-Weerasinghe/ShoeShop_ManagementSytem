package lk.ijse.shoeShop.Controller;

import lk.ijse.shoeShop.Service.AuthenticationService;
import lk.ijse.shoeShop.Service.UserService;
import lk.ijse.shoeShop.reqAndResp.response.JwtAuthResponse;
import lk.ijse.shoeShop.reqAndResp.secure.SignIn;
import lk.ijse.shoeShop.reqAndResp.secure.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user/")
@CrossOrigin(origins = "*", methods = {RequestMethod.PATCH, RequestMethod.DELETE ,RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/singUp")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq){
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody SignIn signInReq){
        JwtAuthResponse jwtAuthResponse = authenticationService.signIn(signInReq);
        String token = jwtAuthResponse.getToken();
        return token;

    }


}
