package lk.ijse.shoeShop.Controller;

import lk.ijse.shoeShop.Dto.UserDto;
import lk.ijse.shoeShop.Service.AuthenticationService;
import lk.ijse.shoeShop.Service.UserService;
import lk.ijse.shoeShop.reqAndResp.response.JwtAuthResponse;
import lk.ijse.shoeShop.reqAndResp.secure.SignIn;
import lk.ijse.shoeShop.reqAndResp.secure.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/search/{id}")
    public UserDto getUser(@PathVariable("id") String id) {
        return userService.searchUser(id);
    }

    /*@PutMapping(path = "/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto dto) {
        System.out.println(dto.toString());
        userService.updateUser(dto);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/user")
    public ResponseEntity<Void> deleteUser(@RequestBody UserDto dto) {
        userService.deleteUser(dto);
        return ResponseEntity.noContent().build();
    }*/



}
