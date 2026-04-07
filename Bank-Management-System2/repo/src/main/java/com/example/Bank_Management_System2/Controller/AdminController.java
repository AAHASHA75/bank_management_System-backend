package com.example.Bank_Management_System2.Controller;

import com.example.Bank_Management_System2.Model.Account;
import com.example.Bank_Management_System2.Model.Customer;
import com.example.Bank_Management_System2.Model.Loginrequest;
import com.example.Bank_Management_System2.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/allcustomers")
    public List<Customer> viewallcustomers() {
        return adminService.viewallcustomers();
    }
    @GetMapping("/allaccount")
    public List<Account> viewallaccounts() {
        return adminService.viewallaccounts();
    }

    @PutMapping("/{accountno}/block")
    public String accountblock(@PathVariable Long accountno){
        return adminService.accountblock(accountno);
    }

    @PutMapping("/{accountno}/unblock")
    public String accountunblock(@PathVariable Long accountno){
        return adminService.accountunblock(accountno);
    }

    @PutMapping("/{accountno}/inactive")
    public String accountinactive(@PathVariable Long accountno){
        return adminService.accountinactive(accountno);
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestBody Loginrequest loginrequest) {
        return adminService.loginCustomer(loginrequest.getEmail(), loginrequest.getPassword());
    }
}
