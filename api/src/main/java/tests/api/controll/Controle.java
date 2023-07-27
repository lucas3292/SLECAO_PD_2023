package tests.api.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tests.api.Service.Services;
import tests.api.model.Champ;
import tests.api.repo.Repo;

@RestController
public class Controle {

    @Autowired
    private Repo action;

    @Autowired
    private Services services;


    @PostMapping("/api")
    public ResponseEntity<?> champRegister(@RequestBody Champ champu){
        return services.register(champu);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selectChamps(){
        return services.selects();
    }

    @GetMapping("/api/{namec}")
    public ResponseEntity<?> selectChamp(@PathVariable String namec){
        return services.selectForName(namec);
    }
    @PutMapping("/api")
    public ResponseEntity<?> attChamp(@RequestBody Champ att){
        return services.edit(att);
    }

    @DeleteMapping("/api/{name}")
    public ResponseEntity<?> deletChamp(@PathVariable String name){
       return services.delete(name);
    }
    

    // @PutMapping("/api")
    // public Champ attChamp(@RequestBody Champ att){
    //     return action.save(att);
    // }

    @GetMapping("/api/count")
    public long countChamps(){
        return action.count();
    }

    // @DeleteMapping("/api/{name}")
    // public void deletChamp(@PathVariable String name){
    //     Champ champ = selectChamp(name);
    //     action.delete(champ);
    // }

    @GetMapping("/api/ordenaded")
    public List<Champ> deletChamp(){
        return action.findByOrderByName();
    }

    @GetMapping("/api/name")
    public List<Champ> selectFoName(){
        return action.findByNameOrderByName("ornn");
    }

    @GetMapping("/api/otherChamps")
    public List<String> selectOtherChamps(){
        return action.othersChamps();
    }

    @GetMapping("/api/unicChamp")
    public List<String> unicChamp(){
        return action.unicChamp("ornn");
    }

    @GetMapping("/status")
    public String register(){
        return "Config status";
    }

    @GetMapping("")
    public String mensagem(){
        return "Hello World";
    }

    @GetMapping("/outro/{nome}")
    public String outro(@PathVariable String nome){
        return "mais um passo " + nome;
    }

   
}
