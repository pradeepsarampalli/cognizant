package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Named QuizUser (instead of User) to avoid colliding with the SQL
// reserved word USER and to keep the quiz-schema classes clearly grouped.
@Entity
@Table(name = "quiz_user")
public class QuizUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private int id;

    @Column(name = "us_username")
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "QuizUser [id=" + id + ", username=" + username + "]";
    }
}
