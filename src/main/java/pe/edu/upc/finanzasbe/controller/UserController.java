package pe.edu.upc.finanzasbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.finanzasbe.repository.entities.UserEntity;
import pe.edu.upc.finanzasbe.service.BillService;
import pe.edu.upc.finanzasbe.service.PaidBillService;
import pe.edu.upc.finanzasbe.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@Validated
public class UserController {

    private final UserService userService;
    private final PaidBillService paidBillService;
    private final BillService billService;

    @Autowired
    public UserController(UserService userService, PaidBillService paidBillService, BillService billService) {
        this.userService = userService;
        this.paidBillService = paidBillService;
        this.billService = billService;
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") Long userId) {
        return this.userService.getByUserId(userId);
    }

    @GetMapping("/search")
    public UserEntity getByUsername(@RequestParam("username") String username) {
        return this.userService.getByUsername(username);
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity user) {
        return this.userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public UserEntity update(@PathVariable("userId") Long userId, @RequestBody UserEntity user) {
        return this.userService.updateUser(userId, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long userId) {
        this.billService.deleteAllByUserId(userId);
        this.paidBillService.deleteAllByUserId(userId);
        this.userService.deleteUser(userId);
    }

}
