package com.javaquiz.quizTests;

import com.javaquiz.domain.Question;
import com.javaquiz.domain.QuestionSet;
import com.javaquiz.domain.QuestionSetDao;
import com.javaquiz.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionSetDaoTestSuite {

    @Autowired
    private QuestionSetDao questionSetDao;

    @Test
    public void testQuestionSetDaoSave(){
        //given

        Question question1 = new Question(1,"What is the difference between JDK and JRE?", "Basics");
        Question question2 = new Question(2,"What is Java Virtual Machine?", "Basics");
        Question question3 = new Question(3,"What is JIT compiler?", "Basics");
        User user1 = new User(1,"Leon TheProfessional","leon.theprofessional@gmail.com");
        User user2 = new User(2,"Mathilda Lando","mathilda.lando@gmail.com");

        Set<Question> questionList1 = new HashSet<>();
        Set<Question> questionList2 = new HashSet<>();

        questionList1.add(question1);
        questionList1.add(question2);
        questionList2.add(question2);
        questionList2.add(question3);

        QuestionSet questionSet1 = new QuestionSet(1);
        QuestionSet questionSet2 = new QuestionSet(2);

        questionSet1.setQuestionList(questionList1);
        questionSet2.setQuestionList(questionList2);
        questionSet1.setUser(user1);
        questionSet2.setUser(user2);

        //when
        questionSetDao.save(questionSet1);
        questionSetDao.save(questionSet2);

        //then
        Assert.assertNotEquals(0,questionSetDao.findByUser(user1).size());
        Assert.assertNotEquals(0,questionSetDao.findById(1).size());

        //clean up
        questionSetDao.delete(questionSet1.getId());
        questionSetDao.delete(questionSet2.getId());
    }
}
