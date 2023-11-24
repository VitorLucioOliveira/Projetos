package com.example.Todoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Todoapp.model.ToDo;
import com.example.Todoapp.repo.iToDoRepo;

@Service
public class ToDoService {

	@Autowired
	iToDoRepo repo;

	public List<ToDo> getAllToDoItems() {

		ArrayList<ToDo> todoList = new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));

		return todoList;
	}

	public ToDo getToDoItemById(Long id) {

		return repo.findById(id).get();
	}

	public boolean saveUpdateToDoItem(ToDo todo) {
		ToDo updateObj = repo.save(todo);

		if (getToDoItemById(updateObj.getId()) != null) {
			return true;

		}

		return false;
	}

	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);

		if (repo.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}
}
