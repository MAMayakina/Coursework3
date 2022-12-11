package com.skypro.coursework3.controller;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/")
    public Collection<Question> getAll() {
        return this.javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return this.javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question) {
        return this.javaQuestionService.remove(question);
    }


}
