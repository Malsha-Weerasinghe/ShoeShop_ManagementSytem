package lk.ijse.shoeShop.entity;

import jakarta.persistence.*;
import lk.ijse.shoeShop.util.Designation;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Role;
import lk.ijse.shoeShop.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/*@Table(name = "employee")*/
public class Employee {
    @Id
    private String employeeCode;
    private String employeeName;
    @Column(columnDefinition = "LONGTEXT")
    private String proPic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    @Enumerated(EnumType.STRING)
    private Designation designation;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Date DOB;
    private Date joinDate;
    private String attachedBranch;
    private String address;
    private String contact;
    private String email;
    private String guardian;
    private String emergContact;
}
