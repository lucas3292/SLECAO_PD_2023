package tests.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    // @JsonManagedReference(value="category_expense")
    // @OneToMany(mappedBy = "category")
    // private List<Expense> expenses;

    @JsonBackReference(value="user_category")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users usersCategory;

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
   
    public Users getUsersCategory() {
        return usersCategory;
    }
    public void setUsersCategory(Users usersCategory) {
        this.usersCategory = usersCategory;
    }
    
    
}
