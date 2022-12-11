package com.skypro.coursework3.service;

import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    Map<Integer, Question> questions = new HashMap<>();
    private int count = 0;

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        if (question.isEmpty() || answer.isEmpty()) {
            throw new IllegalArgumentException("Введите вопрос и ответ");
        }

        questions.put(count, newQuestion);
        count++;

        return newQuestion;
    }

    public Question remove(String question) {
        for (Question value : questions.values()) {
            if (value.getQuestion().equals(question)) {
                questions.remove(value);
                count--;
                return value;
            }
        }
        throw new RuntimeException("Такого вопроса нет");
    }

    public Collection<Question> getAll() {
        return questions.values();
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(count));
    }
}
