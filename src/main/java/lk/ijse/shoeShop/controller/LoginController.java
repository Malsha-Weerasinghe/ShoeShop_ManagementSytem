package lk.ijse.shoeShop.controller;

import lk.ijse.shoeShop.auth.Request.SignInRequest;
import lk.ijse.shoeShop.auth.Request.SignUpRequest;
import lk.ijse.shoeShop.auth.Response.JWTAuthResponse;
import lk.ijse.shoeShop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})
public class LoginController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> signIn(
            @RequestBody SignInRequest signInRequest){
        System.out.println("Signing in");
        return ResponseEntity.ok(
                authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JWTAuthResponse> signUp(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signupupdate")
    public ResponseEntity<JWTAuthResponse> signUpdate(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }
}

