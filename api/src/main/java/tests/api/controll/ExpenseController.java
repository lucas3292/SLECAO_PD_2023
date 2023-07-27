package tests.api.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tests.api.Service.ExpenseServices;
import tests.api.model.Expense;
import tests.api.model.Users;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseServices expenseServices;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/api/expense")
    public ResponseEntity<?> userRegister(@RequestBody Expense expense){
        return expenseServices.register(expense);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/api/expense")
    public ResponseEntity<?> userList(){
        return expenseServices.selects();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/api/expense")
    public ResponseEntity<?> expenseAtt(@RequestBody Expense att){
        return expenseServices.edit(att);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/api/expense")
    public ResponseEntity<?> deletChamp(@RequestBody Expense name){
       return expenseServices.delete(name);
    }
}
