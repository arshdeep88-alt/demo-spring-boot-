package com.demo.demo1.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "demoDB")//It is used to map a Java class to a collection in MongoDB.
@Data
public class demoEntity {

    @Id
    @NonNull
    private Integer id;
    private String name;
    private Integer age;
    private String address;
}
