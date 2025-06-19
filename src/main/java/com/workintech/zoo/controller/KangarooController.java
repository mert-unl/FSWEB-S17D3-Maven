package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Long, Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
    }


    @GetMapping
    public ResponseEntity<List<Kangaroo>> getKangarooList() {
        //     return kangaroos;

        return ResponseEntity.ok(new ArrayList<>(kangaroos.values()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Kangaroo> getKangarooById(@PathVariable Long id) {
        Kangaroo kangaroo = kangaroos.get(id);

        if (kangaroo == null) {
            throw new ZooException("Hata", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(kangaroo);
    }

    //Create
    @PostMapping
    public ResponseEntity<Kangaroo> saveKangaroo(@RequestBody Kangaroo kangaroo) {
        if (kangaroo == null) {
            throw new ZooException("Hata", HttpStatus.BAD_REQUEST);
        }

        if (kangaroo.getId() <= 0) {
            throw new ZooException("Hata", HttpStatus.BAD_REQUEST);
        }

        kangaroos.put(kangaroo.getId(), kangaroo);
        return ResponseEntity.ok(kangaroo);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Kangaroo> updateKangaroo(@PathVariable long id, @RequestBody Kangaroo kangaroo) {
        Kangaroo kangaroo1 = kangaroos.get(id);

        if (kangaroo1 == null) {
            throw new ZooException("Hata", HttpStatus.NOT_FOUND);
        }
        kangaroos.put(id, kangaroo);
        return ResponseEntity.ok(kangaroo);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kangaroo> deleteKangaroo(@PathVariable long id) {
        Kangaroo kangaroo = kangaroos.get(id);
        if (kangaroo == null) {
            throw new ZooException("Hata", HttpStatus.NOT_FOUND);
        }
        kangaroos.remove(id);
        return ResponseEntity.ok(kangaroo);

    }

}
