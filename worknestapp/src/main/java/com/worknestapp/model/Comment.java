package com.worknestapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=2000)
    private String text;
    private String author;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    public Comment(){}
    public Comment(String text, String author){ this.text = text; this.author = author; this.createdAt = LocalDateTime.now(); }

    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getText(){return text;}
    public void setText(String text){this.text = text;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}
    public Task getTask(){return task;}
    public void setTask(Task task){this.task = task;}
}
