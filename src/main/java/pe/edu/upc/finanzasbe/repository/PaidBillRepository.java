package pe.edu.upc.finanzasbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzasbe.repository.entities.PaidBillEntity;

import java.util.List;

@Repository
public interface PaidBillRepository extends JpaRepository<PaidBillEntity, Long> {

    List<PaidBillEntity> getAllByUserId(Long userId);
}
