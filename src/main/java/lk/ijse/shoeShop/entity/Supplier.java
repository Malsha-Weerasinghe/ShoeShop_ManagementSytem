package lk.ijse.shoeShop.entity;


import jakarta.persistence.*;
import lk.ijse.shoeShop.util.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/*@Table(name = "supplier")*/
public class Supplier {

    @Id
    private String supplierCode;
    private String supplierName;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String address;
    private String contactNo1;
    private String contactNo2;
    private String email;
}
