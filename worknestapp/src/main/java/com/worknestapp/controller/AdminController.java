package com.worknestapp.controller;

import com.worknestapp.model.Task;
import com.worknestapp.model.User;
import com.worknestapp.service.TaskService;
import com.worknestapp.service.TaskServiceImpl;
import com.worknestapp.service.UserService;
import com.worknestapp.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService = new UserServiceImpl();
    private TaskService taskService = new TaskServiceImpl();

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        List<Task> tasks = taskService.listAll();
        model.addAttribute("tasks", tasks);
        return "admin-dashboard";
    }

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userService.listAll());
        return "users-list";
    }

    @GetMapping("/users/add")
    public String addUserForm(){ return "add-user"; }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam(defaultValue="USER") String role){
        userService.register(new User(username,password,role));
        return "redirect:/admin/users";
    }

    @GetMapping("/tasks/add")
    public String addTaskForm(Model model){
        model.addAttribute("users", userService.listAll());
        return "add-task";
    }

    @PostMapping("/tasks/add")
    public String addTask(@RequestParam String title, @RequestParam String description, @RequestParam String startDate,
                          @RequestParam String dueDate, @RequestParam Long assignedTo){
        Task t = new Task();
        t.setTitle(title); t.setDescription(description);
        t.setStartDate(LocalDate.parse(startDate));
        t.setDueDate(LocalDate.parse(dueDate));
        t.setStatus("PENDING");
        User u = userService.findById(assignedTo);
        t.setAssignedTo(u);
        taskService.create(t);
        return "redirect:/admin/dashboard";
    }
}
