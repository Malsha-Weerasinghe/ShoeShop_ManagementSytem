package lk.ijse.shoeShop.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @Null(message = "Customer CODE is auto genarated")
    private String customerCode;
    @NotBlank(message = "Customer Name Cannot Be Null")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Name not valid")
    private String customerName;
    private Gender gender;
    private java.util.Date joinDate;
    private Level level;
    private int totalPoints;
    private java.util.Date dob;
    @NotBlank(message = "Customer Address Line 01 Cannot Be Null")
    private String address;
    @NotBlank(message = "Customer Address Line 02 Cannot Be Null")
   /* private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;*/
    @NotBlank(message = "Customer Contact Number Cannot Be Null")
    @Pattern(regexp = "^\\+?[0-9()-]{1,11}$", message = "Contact Number not valid")
    private String contactNo;
    @NotBlank(message = "Customer Email Cannot Be Null")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email not valid")
    private String email;
    private Date recentPurchaseDateTime;
}
