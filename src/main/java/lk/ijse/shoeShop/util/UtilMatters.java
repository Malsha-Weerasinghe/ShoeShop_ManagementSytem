package lk.ijse.shoeShop.util;

import org.springframework.stereotype.Component;

import java.util.Base64;


@Component
public class UtilMatters {


    public static String convertBase64(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static byte[] decode(String d){
        return Base64.getDecoder().decode(d);
    }


}
