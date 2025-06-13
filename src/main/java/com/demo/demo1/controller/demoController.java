package com.demo.demo1.controller;
import com.demo.demo1.entity.demoEntity;
import com.demo.demo1.service.demoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class demoController {

    @Autowired
    private demoService demoservice;

    @GetMapping
    public List<demoEntity> getData(){
        return demoservice.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<demoEntity> getDataById(@PathVariable Integer id){
        return demoservice.getById(id)
                .map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<demoEntity> create(@RequestBody demoEntity demoentity){
        return new ResponseEntity<>(demoservice.saveAll(demoentity),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<demoEntity> update(@PathVariable Integer id, @RequestBody demoEntity demoentity) {
        return new ResponseEntity<>(demoservice.update(id, demoentity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        demoservice.delete(id);
        return ResponseEntity.noContent().build();
    }

}
