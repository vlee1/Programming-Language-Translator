package com.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 12/7/16.
 */
@Entity
@Table(name="Class")
public class PersonalClass {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="class_id")
    private int class_id;

    @Column(name="class_name")
    private String class_name;

    @Column(name="class_modifier")
    private String class_modifier;

    @Column(name="keyword")
    private String keyword;

    private String wholeClass;

    public PersonalClass() {}

    public PersonalClass(String name, String modifier, String keyword) {
        this.class_name = name;
        this.class_modifier = modifier;
        this.keyword = keyword;
    }

    public String getClassName() { return this.class_name; }
    public String getClassModifier() { return this.class_modifier; }
    public String getKeyword() { return this.keyword; }


}
