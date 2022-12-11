package com.skypro.coursework3;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.ExaminerServiceImpl;
import com.skypro.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    private List<Question> actualQuestions;
    private Set<Question> examinerQuestion;

    @BeforeEach
    public void setup() {
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Question question3 = new Question("question3", "answer3");
        Question question4 = new Question("question4", "answer4");

        actualQuestions = new ArrayList<>();
        actualQuestions.add(question1);
        actualQuestions.add(question2);
        actualQuestions.add(question3);
        actualQuestions.add(question4);

        when(javaQuestionService.getRandomQuestion()).thenReturn(actualQuestions.get((int)(Math.random()* (actualQuestions.size()-1))));
    }

    @ParameterizedTest
    @MethodSource("getQuestionTest")
    public void getQuestionTest(int amount) {
        examinerQuestion = examinerServiceImpl.getQuestion(amount);
        System.out.println(examinerQuestion);
        for (Question question : examinerQuestion) {
            if (!actualQuestions.contains(question)) {
                Assertions.fail();
            }
        }
    }

    public static List<Arguments> getQuestionTest() {
        return List.of(
                Arguments.of(2),
                Arguments.of(3)
        );
    }

}
