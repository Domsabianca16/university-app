package ro.fasttrackit.university.app.model;

import jakarta.persistence.*;

import java.util.Objects;



public class Student {


    private Long id;
    private Long human_id;


    private Human human;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHuman_id() {
        return human_id;
    }

    public void setHuman_id(Long human_id) {
        this.human_id = human_id;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", human=" + human +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

