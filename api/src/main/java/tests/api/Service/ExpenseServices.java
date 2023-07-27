package tests.api.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tests.api.model.Category;
import tests.api.model.Expense;
import tests.api.model.Users;
import tests.api.repo.CategoryRepo;
import tests.api.repo.ExpenseRepo;
import tests.api.repo.UserRepo;


@Service
public class ExpenseServices {
    @Autowired
    private ExpenseRepo action;
    @Autowired
    private UserRepo actionUser;
    @Autowired
    private CategoryRepo actionCategory;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DecimalFormat formatVal = new DecimalFormat("0.00");

    
    public ResponseEntity<?> selects(){
        return new ResponseEntity<>(action.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> register(Expense obj){
        String dataStr = obj.getExpenseDay().toString();
        long idUser = obj.getUsersExpense().getId();
        Users userCheck = actionUser.findById(idUser);
        // long idCategory = 0;

        // try {
        //     idCategory = obj.getCategory().getId();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // if( idCategory > 0 && actionCategory.findById(idCategory) == null){
        //     return new ResponseEntity<>("categoria não encontrada",HttpStatus.NOT_FOUND);
        // }
        if (obj.getExpenseDay() != null && !dataStr.trim().isEmpty()) {
            try {
                LocalDate.parse(dataStr, dateFormatter);
            } catch (DateTimeParseException e) {
                return new ResponseEntity<>("Formato de data invalido. Use o formato yyyy-MM-dd.",HttpStatus.BAD_REQUEST);
            }
        }
        if(obj.getName().equals("")){
            return new ResponseEntity<>("nome precisa ser preenchido",HttpStatus.BAD_REQUEST);
        }
        if(userCheck==null){
            return new ResponseEntity<>("id não encontrado",HttpStatus.NOT_FOUND);
        }
        if(obj.getVal().compareTo(BigDecimal.ZERO) == 0 ){
            return new ResponseEntity<>("valor nulo",HttpStatus.BAD_REQUEST);
        }
        String formatedVal = formatVal.format(obj.getVal());
        formatedVal = formatedVal.replace(",", ".");
        BigDecimal valBigDecimal = new BigDecimal(formatedVal);
        obj.setVal(valBigDecimal);
        obj.setUsersExpense(userCheck);
        action.save(obj);
        return new ResponseEntity<>(action.save(obj),HttpStatus.CREATED);
        
    }

    public ResponseEntity<?> edit(Expense obj){
        String dataStr = obj.getExpenseDay().toString();
        Expense findExpense = action.findById(obj.getId());
        if(findExpense == null){
            return new ResponseEntity<>("id não encontrado",HttpStatus.NOT_FOUND);
        }else if(obj.getName().equals("")){
            return new ResponseEntity<>("nome invalido",HttpStatus.BAD_REQUEST);
        }else if (obj.getExpenseDay() != null && !dataStr.trim().isEmpty()) {
            try {
                LocalDate.parse(dataStr, dateFormatter);
            } catch (DateTimeParseException e) {
                return new ResponseEntity<>("Formato de data invalido. Use o formato yyyy-MM-dd.",HttpStatus.BAD_REQUEST);
            }
        }
        obj.setUsersExpense(findExpense.getUsersExpense());
        return new ResponseEntity<>(action.save(obj),HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Expense obj){
        Expense objDetected = action.findById(obj.getId());
        if(objDetected == null){
            return new ResponseEntity<>("tarefa não encontrada",HttpStatus.NOT_FOUND);
        }else{
            action.delete(objDetected);
            return new ResponseEntity<>("deletado com sucesso",HttpStatus.OK);
        }
    }

}
