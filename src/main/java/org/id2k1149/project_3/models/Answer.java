package org.id2k1149.project_3.models;

import javax.persistence.*;

@Entity
@Table
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence"
    )
    private Long id;
    private String title;
    private boolean active;

    public Answer() {
    }

    public Answer(String title, boolean active) {
        this.title = title;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + title + '\'' +
                ", is active=" + active +
                '}';
    }
}
