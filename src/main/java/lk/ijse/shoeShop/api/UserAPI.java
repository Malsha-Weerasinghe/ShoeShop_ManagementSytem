package lk.ijse.shoeShop.api;

import jakarta.validation.Valid;
import lk.ijse.shoeShop.dto.UserDTO;
import lk.ijse.shoeShop.service.UserService;
import lk.ijse.shoeShop.util.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v0/user")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})
public class UserAPI {
    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAllCustomer(){
        return userService.getAllUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO saveUser(@Valid @RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateCustomer(@Valid @RequestBody UserDTO userDTO){
        userService.updateUser(userDTO.getEmail(),userDTO);
    }

    @DeleteMapping(value = "/{email}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteCustomer(@PathVariable("email") String email){
        userService.deleteUser(email);
    }

    @PatchMapping(value = "/{email}/{role}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    UserDTO getCustomer(@PathVariable("email") String email, @PathVariable("role") Role role){
        return userService.getUserDetails(email ,role);
    }
}
