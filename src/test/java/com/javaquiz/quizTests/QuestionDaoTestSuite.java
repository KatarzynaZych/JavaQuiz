package com.javaquiz.quizTests;

import com.javaquiz.domain.Answer;
import com.javaquiz.domain.Question;
import com.javaquiz.domain.QuestionDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionDaoTestSuite {

    @Autowired
    private QuestionDao questionDao;

    @Test
    public void testQuestionDaoSave(){
        //given
        Question question = new Question(1,"What is the difference between JDK and JRE?", "Basics");

        //when
        questionDao.save(question);

        //then
        String section = question.getSection();
        List<Question> result = questionDao.findBySection(section);
        Assert.assertEquals("Basics", result.get(0).getSection());

        //cleanUp
        int id = result.get(0).getId();
        questionDao.delete(id);

    }

    @Test
    public void testQuestionDaoSaveWithAnswers(){
        //given
        Question question1 = new Question(1,"What is the difference between JDK and JRE?", "Basics");
        Question question2 = new Question(2,"What is Java Virtual Machine?", "Basics");
        Question question3 = new Question(3,"What is JIT compiler?", "Basics");

        Answer answer1 = new Answer(1,"It is a way of executing computer code that involves compilation during execution of a program – at run time.",true);
        Answer answer2 = new Answer(2,"It is a compiler that worsens performance in Java.",false);
        Answer answer3 = new Answer(3,"It is a style of dance music popular in Zimbabwe.", false);
        Answer answer4 = new Answer(4,"It is a compiler which output is a description of the hardware configuration instead of a sequence of instructions",false);

        Answer answer5 = new Answer(5,"It is an abstract machine that executes Java Bytecode.", true);
        Answer answer6 = new Answer(6,"It is  is the environment within which the java virtual machine runs.", false);
        Answer answer7 = new Answer(7,"It is a machine which contains JRE and development tools.",false);
        Answer answer8 = new Answer(8,"It is a platform independent, that is why you have one JVM for different operating systems.",false);

        Answer answer9 = new Answer(9,"JDK is a software development environment used for developing Java applications and applets. It includes the Java Runtime Environment.", true);
        Answer answer10 = new Answer(10,"JRE is a software development environment used for developing Java applications and applets. It includes the Java Development Kit", false);
        Answer answer11 = new Answer(11,"There is no difference and you can use the abbreviations alternately.",false);
        Answer answer12 = new Answer(12, "JRK contains compilers and debuggers needed to compile Java program, and JDK not", false);

        answer1.setQuestion(question3);
        answer2.setQuestion(question3);
        answer3.setQuestion(question3);
        answer4.setQuestion(question3);

        answer5.setQuestion(question2);
        answer6.setQuestion(question2);
        answer7.setQuestion(question2);
        answer8.setQuestion(question2);

        answer9.setQuestion(question1);
        answer10.setQuestion(question1);
        answer11.setQuestion(question1);
        answer12.setQuestion(question1);

        List<Answer> answersForQuest1 = new ArrayList<>();
        answersForQuest1.add(answer9);
        answersForQuest1.add(answer10);
        answersForQuest1.add(answer11);
        answersForQuest1.add(answer12);

        List<Answer> answersForQuest2 = new ArrayList<>();
        answersForQuest2.add(answer5);
        answersForQuest2.add(answer6);
        answersForQuest2.add(answer7);
        answersForQuest2.add(answer8);

        List<Answer> answersForQuest3 = new ArrayList<>();
        answersForQuest3.add(answer1);
        answersForQuest3.add(answer2);
        answersForQuest3.add(answer3);
        answersForQuest3.add(answer4);

        question1.setAnswers(answersForQuest1);
        question2.setAnswers(answersForQuest2);
        question3.setAnswers(answersForQuest3);

        //when
        questionDao.save(question3);
        questionDao.save(question2);
        questionDao.save(question1);

        int id1 = question1.getId();
        int id2 = question2.getId();
        int id3 = question3.getId();

        //then
        Assert.assertNotEquals(0,id1);
        Assert.assertNotEquals(0,id2);
        Assert.assertNotEquals(0,id3);

        //cleanUp
        try {
            questionDao.delete(id1);
            questionDao.delete(id2);
            questionDao.delete(id3);
        }catch ( Exception e ){
        }

    }
}
