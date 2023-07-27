package tests.api.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tests.api.model.Users;

@Repository 
public interface UserRepo extends CrudRepository<Users,Integer>{
    List<Users> findAll();
    Users findByName(String name);
    List<Users> findByNameOrderByName(String name);
    List<Users> findByOrderByName();
    Users findById(long id);
    int countByName(String name);
    int countById(Long id);

    @Query(value="SELECT * FROM users", nativeQuery = true)
    List<String> listUsers();

    // @Query(value="SELECT * FROM champs WHERE name = :name", nativeQuery = true)
    // List<String> unicChamp(String name);
}
