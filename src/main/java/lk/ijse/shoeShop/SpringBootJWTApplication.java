package lk.ijse.shoeShop;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class SpringBootJWTApplication {

    public SpringBootJWTApplication() throws IOException {
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJWTApplication.class, args);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
