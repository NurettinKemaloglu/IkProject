package com.fmss.ikrestproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ıd;
    @Column(name = "title")
    private  String title;
    @Column(name = "description",length = 100)
    private String description;
    @CreatedDate
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "comment")
    private String comment;
}
