package com.example.Todoapp.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Todoapp.model.ToDo;
import com.example.Todoapp.service.ToDoService;

@Controller
public class ToDoController {

	@Autowired
	private ToDoService service;

	@GetMapping({ "/", "viewToDoList" })
	public String viewAllTodoItems(Model model, @ModelAttribute("message") String message) {
		List<ToDo> todoList = service.getAllToDoItems();

		// Ordenar a lista de lembretes por data
		todoList.sort(Comparator.comparing(ToDo::getDate));

		model.addAttribute("list", todoList);
		model.addAttribute("message", message);

		// Adicione um objeto vazio 'todo' ao modelo
		model.addAttribute("todo", new ToDo());

		return "ViewToDoList";
	}

	@PostMapping("/saveToDoItem")
	public String saveTodoItem(@ModelAttribute("todo") ToDo todo, RedirectAttributes redirectAttributes) {
		if (service.saveUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Save Failure");
		}
		return "redirect:/viewToDoList";
	}

	@GetMapping("/deleteToDoItem/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.deleteToDoItem(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Delete Failure");
		}
		return "redirect:/viewToDoList";
	}
}
