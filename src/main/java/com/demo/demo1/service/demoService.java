package com.demo.demo1.service;
import com.demo.demo1.entity.demoEntity;
import com.demo.demo1.repository.demoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class demoService {

    @Autowired
    private demoRepo demorepo;

    public demoEntity saveAll(demoEntity demoentity){
        return demorepo.save(demoentity);
    }

    public List<demoEntity> getAll(){
        return demorepo.findAll();
    }

    public Optional<demoEntity> getById(Integer id) {
        return demorepo.findById(id);
    }

    public demoEntity update(Integer id, demoEntity updatedData) {
        return demorepo.findById(id).map(existing -> {
            if (updatedData.getName() != null) existing.setName(updatedData.getName());
            if (updatedData.getAge() != 0) existing.setAge(updatedData.getAge());
            if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
            return demorepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
    }


    public void delete(Integer id) {
        demorepo.deleteById(id);
    }
}
