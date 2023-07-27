package tests.api.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tests.api.model.Champ;

@Repository
public interface Repo extends CrudRepository<Champ,Integer>{
    java.util.List<Champ> findAll();
    Champ findByName(String name);
    List<Champ> findByNameOrderByName(String name);
    List<Champ> findByOrderByName();
    int countByName(String name);
    int countById(int id);
    @Query(value="SELECT * FROM champs", nativeQuery = true)
    List<String> othersChamps();

    @Query(value="SELECT * FROM champs WHERE name = :name", nativeQuery = true)
    List<String> unicChamp(String name);
    
}

