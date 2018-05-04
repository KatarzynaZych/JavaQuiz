package com.javaquiz.domain;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ANSWERS")
public class Answer {

    private int id;
    private String content;
    private boolean isCorrect;
    private Question question;


    public Answer(int id, String content, boolean isCorrect) {
        this.id = id;
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public Answer() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ANSWER_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    @Column(name = "IS_CORRECT")
    public boolean isCorrect() {
        return isCorrect;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
