package lk.ijse.shoeShop.reqAndResp.secure;


import lk.ijse.shoeShop.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    private String email;
    private String password;
    private Role role;
    private String name;
    private String emp_Id;
}
