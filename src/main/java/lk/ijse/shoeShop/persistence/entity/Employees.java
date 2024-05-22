package lk.ijse.shoeShop.persistence.entity;

import jakarta.persistence.*;
import lk.ijse.shoeShop.util.Designation;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Role;
import lk.ijse.shoeShop.util.Status;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "employee_code", unique = true, nullable = false)
    private String employeeCode;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_profile_pic" , columnDefinition = "LONGTEXT")
    private String employeeProfilePic;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_role")
    private Role accessRole;

    @Column(name = "dob")
    private java.util.Date dob;

    @Column(name = "date_of_join")
    private Date dateOfJoin;

    @Column(name = "attached_branch")
    private String attachedBranch;

    @Column(name = "address", nullable = false)
    private String addressLine01;

    @Column(name = "address_line_02", nullable = false)
    private String addressLine02;

    @Column(name = "address_line_03")
    private String addressLine03;

    @Column(name = "address_line_04")
    private String addressLine04;

    @Column(name = "address_line_05")
    private String addressLine05;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "emergency_contact_person")
    private String emergencyContactPerson;
}
