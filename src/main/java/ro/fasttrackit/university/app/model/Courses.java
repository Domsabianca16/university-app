package ro.fasttrackit.university.app.model;

import java.util.Objects;

public class Courses {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return Objects.equals(id, courses.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
