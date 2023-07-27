package tests.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tests.api.model.Champ;
import tests.api.repo.Repo;

@Service
public class Services {
    @Autowired
    private Repo action;

    public ResponseEntity<?> register(Champ obj){
        if(obj.getName().equals("")){
            return new ResponseEntity<>("nome precisa ser preenchido",HttpStatus.BAD_REQUEST);
        }else {
            action.save(obj);
            return new ResponseEntity<>(action.save(obj),HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> selects(){
        return new ResponseEntity<>(action.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> selectForName(String name){
        if(action.countByName(name) <= 0){
            return new ResponseEntity<>("nome não encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(action.findByName(name),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> edit(Champ obj){
        if(action.countById(obj.getId()) <= 0){
            return new ResponseEntity<>("id não encontrado",HttpStatus.NOT_FOUND);
        }else if(obj.getName().equals("")){
            return new ResponseEntity<>("nome invalido",HttpStatus.BAD_REQUEST);
        }else if(obj.getPower().equals("")){
            return new ResponseEntity<>("Poder invalido",HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(action.save(obj),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> delete(String obj){
        if(action.countByName(obj) <= 0){
            return new ResponseEntity<>("user não encontrado:"+obj,HttpStatus.NOT_FOUND);
        }else{
            Champ objDetected = action.findByName(obj);
            action.delete(objDetected);
            return new ResponseEntity<>("deletado com sucesso",HttpStatus.OK);
        }
       
    }
}
