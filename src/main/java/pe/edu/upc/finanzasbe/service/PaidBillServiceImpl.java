package pe.edu.upc.finanzasbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasbe.repository.PaidBillRepository;
import pe.edu.upc.finanzasbe.repository.entities.PaidBillEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaidBillServiceImpl implements PaidBillService{

    public static final String COULD_NOT_FIND_ENTITY_WITH_ID = "Could not find Entity with id: %s!";
    private final PaidBillRepository paidBillRepository;

    @Autowired
    public PaidBillServiceImpl(PaidBillRepository paidBillRepository) {
        this.paidBillRepository = paidBillRepository;
    }

    @Override
    public List<PaidBillEntity> getAll() {
        return this.paidBillRepository.findAll();
    }

    @Override
    public List<PaidBillEntity> getAllByUser(Long userId) {
        return this.paidBillRepository.getAllByUserUserId(userId);
    }

    @Override
    public PaidBillEntity getById(Long id) {
        return this.paidBillRepository.findById(id).orElse(null);
    }

    @Override
    public PaidBillEntity findById(Long id) {
        return this.paidBillRepository.findById(id).orElse(null);
    }

    @Override
    public PaidBillEntity update(Long id, PaidBillEntity paidBill) {
        PaidBillEntity existingPaidBill = this.paidBillRepository.findById(id).orElse(null);

        if (existingPaidBill == null) {
            return null;
        }

        paidBill.setPaidBillId(existingPaidBill.getPaidBillId());
        paidBill.setUser(existingPaidBill.getUser());

        return this.paidBillRepository.save(paidBill);
    }

    @Override
    public PaidBillEntity create(PaidBillEntity paidBill) {
        return this.paidBillRepository.save(paidBill);
    }

    @Override
    public void delete(Long paidBillId) {
        PaidBillEntity existingBill = this.paidBillRepository.findById(paidBillId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(COULD_NOT_FIND_ENTITY_WITH_ID, paidBillId)));

        this.paidBillRepository.delete(existingBill);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        List<PaidBillEntity> userPaidBills = this.paidBillRepository.getAllByUserUserId(userId);
        paidBillRepository.deleteAll(userPaidBills);
    }
}
