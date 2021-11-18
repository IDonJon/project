package pe.edu.upc.finanzasbe.service;

import pe.edu.upc.finanzasbe.repository.entities.BillEntity;

import java.util.List;

public interface BillService {

    List<BillEntity> getAll();

    List<BillEntity> getAllByUser(Long userId);

    BillEntity getById(Long id);

    BillEntity findById(Long id);

    BillEntity update(Long id, BillEntity bill);

    BillEntity create(BillEntity bill);

    void delete(Long billId);

    void deleteAllByUserId(Long userId);
}
