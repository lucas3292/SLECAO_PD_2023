package tests.api.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tests.api.dto.ExpenseGraphDTO;
import tests.api.model.Category;
import tests.api.model.Expense;
import tests.api.model.Users;
import tests.api.repo.UserRepo;

@Service
public class UsersServices {
    @Autowired
    private UserRepo action;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ResponseEntity<?> selects(){
        return new ResponseEntity<>(action.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> register(Users obj){
        if(obj.getName().equals("")){
            return new ResponseEntity<>("nome precisa ser preenchido",HttpStatus.BAD_REQUEST);
        }if(obj.getName().equals("")){
            return new ResponseEntity<>("nome precisa ser preenchido",HttpStatus.BAD_REQUEST);
        }else {
            action.save(obj);
            return new ResponseEntity<>(action.save(obj),HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> edit(Users obj){
        if(action.findById(obj.getId()) == null){
            return new ResponseEntity<>("id não encontrado",HttpStatus.NOT_FOUND);
        }else if(obj.getName().equals("")){
            return new ResponseEntity<>("nome invalido",HttpStatus.BAD_REQUEST);
        }
        Users user = action.findById(obj.getId());
        user.setName(obj.getName());
        action.save(user);
        return new ResponseEntity<>("usuario atualizado", HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Users obj){
        long idObj = obj.getId();
        if(action.countById(obj.getId()) <= 0){
            return new ResponseEntity<>("user não encontrado" + idObj,HttpStatus.NOT_FOUND);
        }else{
            Users objDetected = action.findById(idObj);

            List<Expense> expenses = objDetected.getExpenses();
            for (Expense expense : expenses) {
                expense.setUsersExpense(null); // ou categoryRepository.delete(category);
            }
            List<Category> categories = objDetected.getCategories();
            for (Category category : categories) {
                category.setUsersCategory(null); // ou categoryRepository.delete(category);
            }
            action.delete(objDetected);
            return new ResponseEntity<>("deletado com sucesso",HttpStatus.OK);
        }
    }

    public ResponseEntity<?> listExpense(long name){
        long idObj = name;
        if(action.countById(idObj) <= 0){
            return new ResponseEntity<>("user não encontrado" + idObj,HttpStatus.NOT_FOUND);
        }else{
            Users objDetected = action.findById(idObj);
            List<Expense> listExpenses = objDetected.getExpenses();
            List<ExpenseGraphDTO> expenseGraphDTO = new ArrayList<>();
            for(Expense expense:listExpenses){
                ExpenseGraphDTO expensefGraphDTOCreate = new ExpenseGraphDTO();
                expensefGraphDTOCreate.setVal(expense.getVal());
                expensefGraphDTOCreate.setDayExpense(expense.getExpenseDay());
                expenseGraphDTO.add(expensefGraphDTOCreate);
            }
            Collections.sort(expenseGraphDTO, Comparator.comparing(ExpenseGraphDTO::getDayExpense));
            return new ResponseEntity<>(expenseGraphDTO,HttpStatus.OK);
        }
    }

}
