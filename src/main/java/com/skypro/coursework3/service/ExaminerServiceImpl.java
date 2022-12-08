package com.skypro.coursework3.service;

import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    Set<Question> examinerQuestion;

    public Collection<Question> getQuestion(int amount) {
        if (amount > javaQuestionService.questions.size()) {
            throw new IllegalArgumentException("Введенное число превышает количество существующих вопросов");
        }
        examinerQuestion = new HashSet<>();
        while (examinerQuestion.size() < amount) {
            examinerQuestion.add(javaQuestionService.getRandomQuestion());
        }
        return examinerQuestion;
    }
}
