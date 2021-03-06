package com.javaquiz.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository <User,Integer> {

    List<User> findByName(String name);
}
