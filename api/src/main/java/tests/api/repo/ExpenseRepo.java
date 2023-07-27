package tests.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tests.api.model.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense,Integer>{
    List<Expense> findAll();
    Expense findByName(String name);
    Expense findById(long id);
    List<Expense> findByNameOrderByName(String name);
    List<Expense> findByOrderByName();
    int countByName(String name);
    long countById(long id);
}
