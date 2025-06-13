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
    public ResponseEntity<List<demoEntity>> getData(){
        List<demoEntity> data = demoservice.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveData(@RequestBody demoEntity demoentity){
        demoservice.saveAll(demoentity);
        return new ResponseEntity<>("Pushed",HttpStatus.CREATED);
    }
}
