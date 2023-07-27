package tests.api.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tests.api.Service.CategoryServices;
import tests.api.model.Category;

@RestController
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @PostMapping("/api/category")
    public ResponseEntity<?> userRegister(@RequestBody Category category){
        return categoryServices.register(category);
    }

    @GetMapping("/api/category")
    public ResponseEntity<?> userList(){
        return categoryServices.selects();
    }

    @PutMapping("/api/category")
    public ResponseEntity<?> categoryAtt(@RequestBody Category att){
        return categoryServices.edit(att);
    }

    @DeleteMapping("/api/category")
    public ResponseEntity<?> deletChamp(@RequestBody Category name){
       return categoryServices.delete(name);
    }
}
