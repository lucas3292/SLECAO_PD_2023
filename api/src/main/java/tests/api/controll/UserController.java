package tests.api.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tests.api.Service.UsersServices;
import tests.api.model.Users;

@RestController
public class UserController {

    @Autowired
    private UsersServices usersServices;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(value = "/api/user", consumes = "application/json")
    public ResponseEntity<?> userRegister(@RequestBody Users users){
        return usersServices.register(users);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/api/user")
    public ResponseEntity<?> userList(){
        return usersServices.selects();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping(value = "/api/user",  consumes = "application/json")
    public ResponseEntity<?> userAtt(@RequestBody Users att){
        return usersServices.edit(att);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/api/user")
    public ResponseEntity<?> deletChamp(@RequestBody Users name){
       return usersServices.delete(name);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/api/user/graph/{id}")
    public ResponseEntity<?> listExpense(@PathVariable Long id){
       return usersServices.listExpense(id);
    }
}
