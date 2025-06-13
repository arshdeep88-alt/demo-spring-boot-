package com.demo.demo1.service;
import com.demo.demo1.entity.demoEntity;
import com.demo.demo1.repository.demoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class demoService {

    @Autowired
    private demoRepo demorepo;

    public void saveAll(demoEntity demoentity){
        demorepo.save(demoentity);
    }

    public List<demoEntity> getAll(){
        return demorepo.findAll();
    }
}
