package com.javaquiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table (name = "QUESTIONS")
public class Question {

    private int id;
    private String content;
    private String section;
    private List<Answer> answers;
    private QuestionSet questionSet;

    public Question(int id, String content, String section) {
        this.id = id;
        this.content = content;
        this.section = section;
    }

    public Question(){}

    @Id
    @GeneratedValue
    @Column (name = "ID_QUESTION", unique = true)
    @NotNull
    public int getId() {
        return id;
    }

    @Column (name = "CONTENT")
    public String getContent() {
        return content;
    }

    @Column (name = "SECTION")
    public String getSection() {
        return section;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setSection(String section) {
        this.section = section;
    }


    @OneToMany(
            targetEntity = Answer.class,
            mappedBy = "question",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @ManyToOne
    @JoinColumn(name = "QUESTION_SET_ID")
    public QuestionSet getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(QuestionSet questionSet) {
        this.questionSet = questionSet;
    }
}
