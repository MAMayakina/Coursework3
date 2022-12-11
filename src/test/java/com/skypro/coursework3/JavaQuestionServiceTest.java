package com.skypro.coursework3;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;
    private Set<Question> expected;

    @BeforeEach
    public void setup() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("question1", "answer1");
        javaQuestionService.add("question2", "answer2");
        javaQuestionService.add("question3", "answer3");
        javaQuestionService.add("question4", "answer4");

        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Question question3 = new Question("question3", "answer3");
        Question question4 = new Question("question4", "answer4");

        expected = new HashSet<>();
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);
        expected.add(question4);
    }

    @ParameterizedTest
    @MethodSource("addQuestion")
    public void add(String question, String answer) {
        Question act = javaQuestionService.add(question, answer);
        Question exp = new Question(question, answer);

        Assertions.assertEquals(exp.getQuestion(), act.getQuestion());
        Assertions.assertEquals(exp.getAnswer(), act.getAnswer());
    }

    @ParameterizedTest
    @MethodSource("removeQuestion")
    public void remove(String question) {
        for (Question exp : expected) {
            if (exp.getQuestion().equals(question)) {
                Assertions.assertEquals(exp, javaQuestionService.remove(question));
            }
        }
    }

    @Test
    public void getAll() {
        Assertions.assertEquals(expected.size(), javaQuestionService.getAll().size());

        for (Question act : javaQuestionService.getAll()) {
            if (!expected.contains(act)) {
                Assertions.fail();
            }
        }
    }

    @Test
    public void getRandomQuestion() {
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        if (!expected.contains(randomQuestion)){
            Assertions.fail();
        }
    }

    public static List<Arguments> addQuestion() {
        return List.of(
                Arguments.of("question5", "answer5"),
                Arguments.of("question6", "answer6")
        );
    }

    public static List<Arguments> removeQuestion() {
        return List.of(
                Arguments.of("question1"),
                Arguments.of("question4")
        );
    }
}
