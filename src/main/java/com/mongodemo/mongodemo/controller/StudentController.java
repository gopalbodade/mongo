package com.mongodemo.mongodemo.controller;

import com.mongodemo.mongodemo.model.Student;
import com.mongodemo.mongodemo.repository.StudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudRepo studRepo;

    @PostMapping(value = "save")
    ResponseEntity<?>saveData(@RequestBody Student student)
    {
        ResponseEntity<String>entity=null;
        studRepo.save(student);
        entity=new ResponseEntity<String>("save", HttpStatus.OK);
        return entity;
    }


    @GetMapping(value = "getdata/{id}")
    ResponseEntity<?>getDat(@PathVariable Integer id)
    {
        Student s=studRepo.findOne(String.valueOf(id));
    ResponseEntity<?>entity=ResponseEntity.ok(s);
    return entity;

    }

    @RequestMapping(value = "delete/{id}")
    ResponseEntity<?>deleteData(@PathVariable Integer id)
    {
        ResponseEntity<String>entity=null;
        studRepo.delete(String.valueOf(id));
        entity=new ResponseEntity<String>("Delete Success",HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "getdata1/{id}")
    Student getData1(@PathVariable Integer id){
        Student s=studRepo.findOne(String.valueOf(id));
        return s;
    }

    @GetMapping(value = "/getbyname")
    Student getData2(@RequestParam String name){
        Student ss=studRepo.findByName(name);
        return ss;
    }

}
