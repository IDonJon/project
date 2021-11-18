package pe.edu.upc.finanzasbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasbe.repository.BillRepository;
import pe.edu.upc.finanzasbe.repository.entities.BillEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    public static final String COULD_NOT_FIND_ENTITY_WITH_ID = "Could not find Entity with id: %s!";
    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<BillEntity> getAll() {
        return this.billRepository.findAll();
    }

    @Override
    public List<BillEntity> getAllByUser(Long userId) {
        return this.billRepository.getAllByUserUserId(userId);
    }

    @Override
    public BillEntity getById(Long id) {
        return this.billRepository.findById(id).orElse(null);
    }

    @Override
    public BillEntity findById(Long id) {
        return this.billRepository.findById(id).orElse(null);
    }

    @Override
    public BillEntity update(Long id, BillEntity bill) {
        BillEntity oldBill = this.billRepository.findById(id).orElse(null);

        if (oldBill == null) {
            return null;
        }

        bill.setBillId(oldBill.getBillId());
        bill.setUser(oldBill.getUser());

        return this.billRepository.save(bill);
    }

    @Override
    public BillEntity create(BillEntity bill) {
        return this.billRepository.save(bill);
    }

    @Override
    public void delete(Long billId) {
        BillEntity oldBill = this.billRepository.findById(billId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(COULD_NOT_FIND_ENTITY_WITH_ID, billId)));

        this.billRepository.delete(oldBill);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        List<BillEntity> userBills = this.billRepository.getAllByUserUserId(userId);
        billRepository.deleteAll(userBills);
    }
}
