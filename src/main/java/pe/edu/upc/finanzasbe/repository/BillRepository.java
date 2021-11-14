package pe.edu.upc.finanzasbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzasbe.repository.entities.BillEntity;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

    List<BillEntity> getAllByUserUserId(Long userId);
}
