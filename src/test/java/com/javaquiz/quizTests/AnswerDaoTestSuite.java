package com.javaquiz.quizTests;

import com.javaquiz.domain.Answer;
import com.javaquiz.domain.AnswerDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerDaoTestSuite {

    @Autowired
    private AnswerDao answerDao;

    private Answer answer = new Answer(1,"Content 1",true);
    private Answer answer1 = new Answer(2,"Content 2",false);
    private Answer answer2 = new Answer(3,"Content 3",false);

    @Test
    public void testAnswerDaoTestSave(){
        //given
        answerDao.save(answer);
        answerDao.save(answer1);
        answerDao.save(answer2);
        //when
        List<Answer> answerList = answerDao.findByContent("Content 1");
        //then
        Assert.assertEquals(1,answerList.size());
        //clean up
        answerDao.deleteAll();
    }

    @Test
    public void testAnswerDaoTestAnswerIsTrue(){
        //given
        answerDao.save(answer);
        answerDao.save(answer1);
        answerDao.save(answer2);
        //when
        List<Answer> answerList = answerDao.findAnswerByCorrectTrue();
        //then
        Assert.assertEquals(1,answerList.size());
        //clean up
        answerDao.deleteAll();
    }

    @Test
    public void testAnswerDaoTestAnswerIsFalse(){
        //given
        answerDao.save(answer);
        answerDao.save(answer1);
        answerDao.save(answer2);
        //when
        List<Answer> answerList = answerDao.findAnswerByCorrectFalse();
        //then
        Assert.assertEquals(2,answerList.size());
        //clean up
        answerDao.deleteAll();
    }

    @Test
    public void testAnswerDaoTestFindById(){
        //given
        answerDao.save(answer);
        answerDao.save(answer1);
        answerDao.save(answer2);
        //when
        List<Answer> answerList = answerDao.findById(2);
        //then
        Assert.assertEquals(1,answerList.size());
        //clean up
        answerDao.deleteAll();

    }


}
