package com.skypro.coursework3.service;

import com.skypro.coursework3.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question remove (String question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
