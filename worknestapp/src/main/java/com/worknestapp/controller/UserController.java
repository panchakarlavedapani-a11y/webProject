package com.worknestapp.controller;

import com.worknestapp.model.Comment;
import com.worknestapp.model.Task;
import com.worknestapp.model.User;
import com.worknestapp.service.TaskService;
import com.worknestapp.service.TaskServiceImpl;
import com.worknestapp.service.UserService;
import com.worknestapp.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private TaskService taskService = new TaskServiceImpl();
    private UserService userService = new UserServiceImpl();

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        User current = (User) session.getAttribute("currentUser");
        if(current==null) return "redirect:/login";
        List<Task> tasks = taskService.listByUser(current.getId());
        model.addAttribute("tasks", tasks);
        return "user-dashboard";
    }

    @GetMapping("/task/{id}")
    public String viewTask(@PathVariable Long id, Model model){
        Task t = taskService.findById(id);
        model.addAttribute("task", t);
        return "task-details";
    }

    @PostMapping("/task/{id}/comment")
    public String addComment(@PathVariable Long id, @RequestParam String text, HttpSession session){
        Task t = taskService.findById(id);
        Comment c = new Comment(text, ((User)session.getAttribute("currentUser")).getUsername());
        c.setTask(t);
        t.getComments().add(c);
        taskService.update(t);
        return "redirect:/user/task/"+id;
    }

    @PostMapping("/task/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status){
        Task t = taskService.findById(id);
        t.setStatus(status);
        taskService.update(t);
        return "redirect:/user/dashboard";
    }
}
