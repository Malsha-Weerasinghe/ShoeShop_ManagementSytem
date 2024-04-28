package lk.ijse.shoeShop.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.shoeShop.util.Category;
import lk.ijse.shoeShop.util.Gender;
import lk.ijse.shoeShop.util.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDTO implements Serializable {
    @Id
    private String supplierCode;
    private String supplierName;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String addressLine6;
    private String contactNo1;
    private String contactNo2;
    private String email;
}
