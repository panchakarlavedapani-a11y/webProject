package com.worknestapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length=2000)
    private String description;
    private LocalDate startDate;
    private LocalDate dueDate;
    private String status; // PENDING, IN_PROGRESS, COMPLETED, DELAYED

    @ManyToOne
    @JoinColumn(name="user_id")
    private User assignedTo;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    public Task(){}
    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate startDate){this.startDate = startDate;}
    public LocalDate getDueDate(){return dueDate;}
    public void setDueDate(LocalDate dueDate){this.dueDate = dueDate;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}
    public User getAssignedTo(){return assignedTo;}
    public void setAssignedTo(User assignedTo){this.assignedTo = assignedTo;}
    public Set<Comment> getComments(){return comments;}
    public void setComments(Set<Comment> comments){this.comments = comments;}
}
