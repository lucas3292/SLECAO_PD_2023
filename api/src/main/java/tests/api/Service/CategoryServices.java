package tests.api.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tests.api.model.Category;
import tests.api.model.Users;
import tests.api.repo.CategoryRepo;
import tests.api.repo.UserRepo;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepo action;
    @Autowired
    private UserRepo actionUser;

    public ResponseEntity<?> selects(){
        return new ResponseEntity<>(action.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> register(Category obj){
        long idUser = obj.getUsersCategory().getId();
        Users userCheck = actionUser.findById(idUser);
       
        if(obj.getName().equals("")){
            return new ResponseEntity<>("nome precisa ser preenchido",HttpStatus.BAD_REQUEST);
        }
        if(userCheck==null){
            return new ResponseEntity<>("usuario não encontrado",HttpStatus.NOT_FOUND);
        }
        obj.setUsersCategory(userCheck);
        action.save(obj);
        return new ResponseEntity<>(action.save(obj),HttpStatus.CREATED);
    }

    public ResponseEntity<?> edit(Category obj){
        Category findCategory = action.findById(obj.getId());
        if(findCategory == null){
            return new ResponseEntity<>("categoria não encontrada",HttpStatus.NOT_FOUND);
        }else if(obj.getName().equals("")){
            return new ResponseEntity<>("nome invalido",HttpStatus.BAD_REQUEST);
        }
        obj.setUsersCategory(findCategory.getUsersCategory());
        return new ResponseEntity<>(action.save(obj),HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Category obj){
        Category objDetected = action.findById(obj.getId());
        if(objDetected == null){
            return new ResponseEntity<>("tarefa não encontrada",HttpStatus.NOT_FOUND);
        }else{
            action.delete(objDetected);
            return new ResponseEntity<>("deletado com sucesso",HttpStatus.OK);
        }
    }
}
