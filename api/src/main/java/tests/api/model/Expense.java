package tests.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JsonBackReference(value="user_expense")
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users usersExpense;
    

    // @JsonBackReference(value="category_expense")
    // @ManyToOne
    // @JoinColumn(name = "category_id")
    // private Category category;

    private String name;
    private String description;
    private LocalDate expenseDay;
    private BigDecimal val;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getExpenseDay() {
        return expenseDay;
    }
    public void setExpenseDay(LocalDate expenseDay) {
        this.expenseDay = expenseDay;
    }
    public BigDecimal getVal() {
        return val;
    }
    public void setVal(BigDecimal val) {
        this.val = val;
    }
    public Users getUsersExpense() {
        return usersExpense;
    }
    public void setUsersExpense(Users usersExpense) {
        this.usersExpense = usersExpense;
    }
}
