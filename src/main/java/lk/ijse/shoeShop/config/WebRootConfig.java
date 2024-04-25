package lk.ijse.shoeShop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"lk.ijse.shoeShop.service","lk.ijse.shoeShop.repositories"})
@Import(JPAConfig.class)
public class WebRootConfig {
}
