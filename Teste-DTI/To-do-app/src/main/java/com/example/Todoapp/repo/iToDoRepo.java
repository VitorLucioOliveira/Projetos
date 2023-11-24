package com.example.Todoapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Todoapp.model.ToDo;

@Repository
public interface iToDoRepo extends JpaRepository<ToDo, Long> {

}
