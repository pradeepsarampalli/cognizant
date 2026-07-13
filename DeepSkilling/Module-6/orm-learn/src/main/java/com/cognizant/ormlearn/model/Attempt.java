package com.cognizant.ormlearn.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private QuizUser user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "at_date")
    private Date attemptedDate;

    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> attemptQuestionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuizUser getUser() {
        return user;
    }

    public void setUser(QuizUser user) {
        this.user = user;
    }

    public Date getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(Date attemptedDate) {
        this.attemptedDate = attemptedDate;
    }

    public Set<AttemptQuestion> getAttemptQuestionList() {
        return attemptQuestionList;
    }

    public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
        this.attemptQuestionList = attemptQuestionList;
    }

    @Override
    public String toString() {
        return "Attempt [id=" + id + ", attemptedDate=" + attemptedDate + "]";
    }
}
