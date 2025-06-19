package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {


    private Map<Long, Koala> koalas;

    @PostConstruct
    public void init(){
       koalas =   new HashMap<>();
    }


    //Genel getALLda globale at bunu;
    @GetMapping
    public ResponseEntity<List<Koala>> getAllKoalas() {
       // return ResponseEntity.ok(koalas);

        return ResponseEntity.ok(new ArrayList<>(koalas.values()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Koala> getKoalaById(@PathVariable long id) {
        if (koalas == null) {
            throw new ZooException("Hata", HttpStatus.BAD_GATEWAY);
        }
        Koala koala =  koalas.get(id);
        return ResponseEntity.ok(koala);

    }



    @PostMapping
    public ResponseEntity<Koala> createKoala(@RequestBody Koala koala) {
        if (koala == null) {
            throw new ZooException("Hata", HttpStatus.BAD_GATEWAY);
        }
        koalas.put(koala.getId(), koala);
        return ResponseEntity.ok(koala);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Koala> updateKoala(@PathVariable long id, @RequestBody Koala koala) {
        Koala koala1 = koalas.get(id);
        if (koala1 == null) {
            throw new ZooException("Hata", HttpStatus.BAD_GATEWAY);
        }
        koalas.put(id, koala);
        return ResponseEntity.ok(koala);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Koala> deleteKoala(@PathVariable long id) {
        Koala koala1 = koalas.get(id);
        if (koala1 == null) {
            throw new ZooException("Hata", HttpStatus.BAD_GATEWAY);
        }
        koalas.remove(id);
        Koala koala =  koalas.get(id);
        return ResponseEntity.ok(koala);


    }
}
