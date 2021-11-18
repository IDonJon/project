package pe.edu.upc.finanzasbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.finanzasbe.controller.request.BillOperationRequest;
import pe.edu.upc.finanzasbe.controller.request.PaidBillOperationRequest;
import pe.edu.upc.finanzasbe.repository.entities.BillEntity;
import pe.edu.upc.finanzasbe.repository.entities.PaidBillEntity;
import pe.edu.upc.finanzasbe.repository.entities.UserEntity;
import pe.edu.upc.finanzasbe.service.PaidBillService;
import pe.edu.upc.finanzasbe.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/paidbills")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@Validated
public class PaidBillController {

    private final PaidBillService paidBillService;
    private final UserService userService;

    @Autowired
    public PaidBillController(PaidBillService paidBillService, UserService userService) {
        this.paidBillService = paidBillService;
        this.userService = userService;
    }

    @GetMapping
    public List<PaidBillEntity> getAll() {return this.paidBillService.getAll(); }

    @GetMapping("/{paidBillId}")
    public PaidBillEntity getById(@PathVariable("paidBillId") Long id) { return this.paidBillService.getById(id); }

    @GetMapping("/search")
    public List<PaidBillEntity> listAllByUserId(@RequestParam("userId") Long userId) {
        return this.paidBillService.getAllByUser(userId);
    }

    @PostMapping
    public PaidBillEntity create(@RequestBody PaidBillOperationRequest request) {
        return this.paidBillService.create(this.parseOperationRequest(request));
    }

    @PutMapping("/{paidBillId}")
    public PaidBillEntity update(@PathVariable("paidBillId") Long paidBillId, @RequestBody PaidBillOperationRequest request) {

        return this.paidBillService.update(paidBillId, this.parseOperationRequest(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long paidBillId) { this.paidBillService.delete(paidBillId); }

    private PaidBillEntity parseOperationRequest(PaidBillOperationRequest request) {
        UserEntity user = this.userService.getByUserId(request.getUserId());
        if (user == null) {
            return null;
        }
        PaidBillEntity paidBill = new PaidBillEntity();
        paidBill.setUser(user);
        paidBill.setCompany(request.getCompany());
        paidBill.setRuc(request.getRuc());
        paidBill.setNetWorth(request.getNetWorth());
        paidBill.setValue(request.getValue());
        paidBill.setTcea(request.getTcea());
        paidBill.setValueYouGet(request.getValueYouGet());
        paidBill.setDays(request.getDays());
        paidBill.setD(request.getD());
        paidBill.setTep(request.getTep());
        return paidBill;
    }
}
