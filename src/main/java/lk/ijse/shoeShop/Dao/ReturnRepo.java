package lk.ijse.shoeShop.Dao;

import lk.ijse.shoeShop.entity.ReturnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepo extends JpaRepository<ReturnEntity,String> {
}
