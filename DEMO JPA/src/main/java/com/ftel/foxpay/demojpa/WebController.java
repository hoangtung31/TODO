package com.ftel.foxpay.demojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class WebController {
    List<Todo> todoList = new CopyOnWriteArrayList<>();
    List<Expense> expenseList = new ArrayList<Expense>();
    @Autowired
    ExpenseRepository repository;

    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.
        Iterable<Expense> iterator = repository.findAll();
        expenseList.clear();
        iterator.forEach(item -> expenseList.add(item));
        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
        model.addAttribute("expenseList", limit != null ? expenseList.subList(0, limit) : expenseList);
        //model.addAttribute("todoList", iterator);
        // Trả về template "listTodo.html"
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        // Thêm mới một đối tượng Todo vào model
        model.addAttribute("todo", new Todo());
        // Trả về template addTodo.html
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        // Thêm đối tượng todo vào list
        todoList.add(todo);
        // Trả về trang thành công success.html
        return "success";
    }
}
