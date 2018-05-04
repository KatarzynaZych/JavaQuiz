package com.javaquiz.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "SET_OF_QUESTIONS")
public class QuestionSet {

    private int id;
    private User user;
    private Set<Question> questionList = new HashSet<>();
    private int score;
    private boolean isAsnwered;

    public QuestionSet(int id) {
        this.id = id;
    }

    public QuestionSet() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID_QUESTION_SET", unique = true)
    @NotNull
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(
            targetEntity = Question.class,
            mappedBy = "questionSet",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public Set<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(Set<Question> questionList) {
        this.questionList = questionList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
