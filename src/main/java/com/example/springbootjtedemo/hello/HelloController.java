package com.example.springbootjtedemo.hello;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/hello")
public class HelloController {

    private final List<Book> books = new ArrayList<>();
    private final PageInfo pageInfo =
            new PageInfo("Hello JTE", "This page description is rendered via Spring Boot JTE app!");

    @PostConstruct
    public void setBooks() {
        books.addAll(List.of(
                new Book(UUID.randomUUID().toString(), "Book1", "Author1"),
                new Book(UUID.randomUUID().toString(), "Book2", "Author2"),
                new Book(UUID.randomUUID().toString(), "Book3", "Author3")));
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("books", new ArrayList<Book>());
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("books", books);
        model.addAttribute("name", "Guest");
        return "index";
    }
}
