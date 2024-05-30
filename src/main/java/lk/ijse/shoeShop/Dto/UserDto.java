package lk.ijse.shoeShop.Dto;
import lk.ijse.shoeShop.enums.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto implements SuperDto{
    private String email;
    private String name;
    private String password;
    private Role role;
    private String emp_Id;
//    private EmployeeEntity employeeEntity;
}
