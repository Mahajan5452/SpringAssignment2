package com.SpringAssignment2.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class College {

    public College() {
        System.out.println("Jay Ho Mahajan");
    }

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE)@Column(name = "id",nullable = false)
    private Long id;
    private  String name;
    private  String address;

    @OneToMany(mappedBy = "college")
    private List<Branches> branches;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Branches> getBranches() {
        return branches;
    }


    public void setBranches(List<Branches> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", branches=" + branches +
                '}';
    }
}
