package com.albvs.todolist.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.albvs.todolist.model.DateContainer;
import com.albvs.todolist.model.Task;
import com.albvs.todolist.services.TaskService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	TaskService taskService;
	
	@RequestMapping("/")
	public String listTasks(Model model) {
		DateContainer dateContainer = new DateContainer(LocalDate.now());
		List<Task> tasks = taskService.findAllByGivenDate(dateContainer.getDate());
		model.addAttribute("dateContainer", dateContainer);
		model.addAttribute("tasks", tasks);
		return "task-list";
	}
	
	@RequestMapping("onDay")
	public String listTasksOnDay(@ModelAttribute("dateContainer") DateContainer dateContainer, Model model) {
		List<Task> tasks = taskService.findAllByGivenDate(dateContainer.getDate());
		model.addAttribute("dateContainer", dateContainer);
		model.addAttribute("tasks", tasks);
		return "task-list";
	}
	
	@RequestMapping("allTasks")
	public String showAllTasks(Model model) {
		DateContainer dateContainer = new DateContainer(LocalDate.now());
		List<Task> tasks = taskService.findAllOrderByDateTimeAsc();
		model.addAttribute("dateContainer", dateContainer);
		model.addAttribute("tasks", tasks);
		return "all-tasks";
	}
	
	@RequestMapping("showAddForm")
	public String showAddForm(Model model) {
		Task task = new Task();
		model.addAttribute("task", task);
		return "task-form";
	}
	
	@RequestMapping("showEditForm")
	public String showEditForm(@RequestParam("taskId") int id, Model model) {
		Task task = taskService.getById(id);
		model.addAttribute("task", task);
		return "task-form";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("taskId") int id) {
		taskService.deleteById(id);
		return "redirect:/";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("task") Task task) {
		taskService.save(task);
		return "redirect:/";
	}
}
