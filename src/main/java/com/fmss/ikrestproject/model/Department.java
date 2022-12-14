package com.fmss.ikrestproject.model;

import lombok.Data;

import javax.persistence.*;

import static com.fmss.ikrestproject.model.EntityConstantsUtil.PREFIX_TB;


@Entity
@Data
@Table(name = PREFIX_TB + "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
