package com.mongodemo.mongodemo.repository;

import com.mongodemo.mongodemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudRepo extends MongoRepository<Student,String>{
//List<Student> getData(int id);
  @Query(value = "{'name':'?0'}")
  Student findByName(String name);

}
