package lk.ijse.shoeShop.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Level;
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
public class CustomerDTO{
    @Id
    private String customerCode;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinDate;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int totPoints;
    private Date DOB;
    private String address;
    private String contact;
    private String email;
    private Timestamp purchaseDateTime;
}
