package com.mahmoud.module.projectmanagement.domain.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name = "PROJECTS", schema = "PROJECT_MANAGEMENT", catalog = "PROJECT_MANAGEMENT")
// TODO add schemas to each module
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
    private String projectManagerEmail;

    protected Project() {

    }

    public Project(String name, String description, String projectManagerEmail) {
        this.name = name;
        this.description = description;
        this.projectManagerEmail = projectManagerEmail;
    }

    @CreationTimestamp
    private LocalDate createdAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getProjectManagerEmail() {
        return projectManagerEmail;
    }
}
