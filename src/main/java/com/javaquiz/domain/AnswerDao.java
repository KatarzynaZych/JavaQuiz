package com.javaquiz.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AnswerDao extends CrudRepository <Answer, Integer> {

    List<Answer> findByContent(String content);

    List<Answer> findAnswerByCorrectTrue();

    List<Answer> findAnswerByCorrectFalse();

    List<Answer> findById(int id);
}
