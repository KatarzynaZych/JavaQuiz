package com.javaquiz.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface QuestionSetDao extends CrudRepository <QuestionSet, Integer> {

    List<QuestionSet> findByUser(User user);
    List<QuestionSet> findById(int id);
}
