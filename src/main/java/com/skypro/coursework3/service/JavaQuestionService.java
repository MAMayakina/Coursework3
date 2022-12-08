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
    private int count = 1;

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
        Question removeQuestion = null;

        for (Question value : questions.values()) {
            if (value.getQuestion().equals(question)) {
                removeQuestion = value;
            }
        }

        if (removeQuestion.getQuestion() == null) {
            throw new RuntimeException("Такого вопроса нет");
        }

        questions.remove(removeQuestion);
        count--;

        return removeQuestion;
    }

    public Collection<Question> getAll() {
        return questions.values();
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(count));
    }
}
