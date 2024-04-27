package lk.ijse.shoeShop.entity;

import jakarta.persistence.*;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String customerCode;
    private String CustomerName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinDate;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int totPoints;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contact;
    private String email;
    private Timestamp purchaseDateTime;

}
