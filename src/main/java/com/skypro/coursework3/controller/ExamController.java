package com.skypro.coursework3.controller;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerServiceImpl = examinerService;
    }

    @GetMapping("/exam/get")
    public Collection<Question> getAll(@RequestParam("amount") int amount) {
        return this.examinerServiceImpl.getQuestion(amount);
    }

}
