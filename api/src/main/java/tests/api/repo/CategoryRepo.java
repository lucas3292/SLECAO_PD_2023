package tests.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tests.api.model.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {
    List<Category> findAll();
    Category findByName(String name);
    Category findById(long id);
    List<Category> findByNameOrderByName(String name);
    List<Category> findByOrderByName();
    int countByName(String name);
    long countById(long id);

}
