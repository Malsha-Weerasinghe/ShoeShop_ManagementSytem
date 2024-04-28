package lk.ijse.shoeShop.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Level;
import lk.ijse.shoeShop.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO implements Serializable {
    @Id
    private String employeeCode;
    private String employeeName;
    private String proPic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Date DOB;
    private Date joinDate;
    private String attachBranch;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contact;
    private String email;
    private String guardian;
    private String emergContact;
}