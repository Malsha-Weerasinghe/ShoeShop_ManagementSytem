package lk.ijse.shoeShop.Dto;


import lk.ijse.shoeShop.enums.Gender;
import lk.ijse.shoeShop.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto implements SuperDto{
    private String customerCode;
    private String customerName;

    private Gender customerGender;
    private Date customerJoinDate;

    private Level level;
    private int  totalPoints;
    private Date birthDay;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNumber;
    private String email;
    private Timestamp recentPurchaseDate;
}
