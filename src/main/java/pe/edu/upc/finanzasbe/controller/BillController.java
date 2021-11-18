package pe.edu.upc.finanzasbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzasbe.controller.request.BillOperationRequest;
import pe.edu.upc.finanzasbe.repository.BillRepository;
import pe.edu.upc.finanzasbe.repository.entities.BillEntity;
import pe.edu.upc.finanzasbe.repository.entities.UserEntity;
import pe.edu.upc.finanzasbe.service.BillService;
import pe.edu.upc.finanzasbe.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/bills")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@Validated
public class BillController {

    private final BillService billService;
    private final BillRepository billRepository;
    private final UserService userService;

    @Autowired
    public BillController(BillService billService, BillRepository billRepository, UserService userService) {
        this.billService = billService;
        this.billRepository = billRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<BillEntity> getAll() {
        return this.billService.getAll();
    }

    @GetMapping("/{billId}")
    public BillEntity getById(@PathVariable("billId") Long id) {
        return this.billService.getById(id);
    }

    @GetMapping("/search")
    public List<BillEntity> listAllByUserId(@RequestParam("userId") Long userId) {
        return this.billService.getAllByUser(userId);
    }

    @PostMapping
    public BillEntity create(@RequestBody BillOperationRequest request) {
        return this.billService.create(this.parseOperationRequest(request));
    }

    @PutMapping("/{billId}")
    public BillEntity update(@PathVariable("billId") Long billId, @RequestBody BillOperationRequest request) {

        return this.billService.update(billId, this.parseOperationRequest(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long billId) {
        this.billService.delete(billId);
    }

    private BillEntity parseOperationRequest(BillOperationRequest request) {
        UserEntity user = this.userService.getByUserId(request.getUserId());
        if (user == null) {
            return null;
        }
        BillEntity bill = new BillEntity();
        bill.setUser(user);
        bill.setCompany(request.getCompany());
        bill.setDueTo(request.getDueTo());
        bill.setRuc(request.getRuc());
        bill.setStatus(request.getStatus());
        bill.setValue(request.getValue());
        bill.setEmissionDate(request.getEmissionDate());
        bill.setPaidDate(request.getPaidDate());
        return bill;
    }
}
