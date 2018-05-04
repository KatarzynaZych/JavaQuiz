package com.javaquiz.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZ_SET")
public class QuizSet {

    private int questionId;
    private int userAnswerId;
    private int point;

    public QuizSet(int questionId, int userAnswerId, int point) {
        this.questionId = questionId;
        this.userAnswerId = userAnswerId;
        this.point = point;
    }

    public QuizSet() {
    }



}
