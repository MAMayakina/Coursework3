package com.skypro.coursework3.service;

import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    public Set<Question> questions = new HashSet<>();
    private int count = 0;

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        if (question.isEmpty() || answer.isEmpty()) {
            throw new IllegalArgumentException("Введите вопрос и ответ");
        }

        questions.add(newQuestion);
        count++;

        return newQuestion;
    }

    public Question remove(String question) {
        for (Question value : questions) {
            if (value.getQuestion().equals(question)) {
                questions.remove(value);
                count--;
                return value;
            }
        }
        throw new RuntimeException("Такого вопроса нет");
    }

    public Collection<Question> getAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        if (count == 0) {
            throw new RuntimeException("В базе нет вопросов");
        }
        Random random = new Random();
        int i=0;
        for (Question question : questions) {
            if(i==random.nextInt(count)){
                return question;
            }
        }
        throw new RuntimeException("Нет такого вопроса");
    }
}
