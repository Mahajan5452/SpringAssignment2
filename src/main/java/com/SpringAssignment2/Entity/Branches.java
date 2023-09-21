package com.SpringAssignment2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Branches {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)@Column(name = "id",nullable = false)
    private Long id;

    private String name;
    @ManyToOne
    @JsonIgnore
    College college;

    public Long getId() {
        return id;
    }

    public College getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Branches{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college=" + college +
                '}';
    }
}
