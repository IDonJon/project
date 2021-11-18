package pe.edu.upc.finanzasbe.service;

import pe.edu.upc.finanzasbe.repository.entities.PaidBillEntity;

import java.util.List;

public interface PaidBillService {

    List<PaidBillEntity> getAll();

    List<PaidBillEntity> getAllByUser(Long userId);

    PaidBillEntity getById(Long id);

    PaidBillEntity update(Long id, PaidBillEntity paidBill);

    PaidBillEntity create(PaidBillEntity paidBill);

    void delete(Long paidBillId);

    void deleteAllByUserId(Long userId);
}
