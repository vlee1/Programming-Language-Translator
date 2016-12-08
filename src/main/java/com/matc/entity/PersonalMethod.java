package com.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by student on 12/7/16.
 */
@Entity
@Table(name="method")
public class PersonalMethod {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="method_id")
    private  int method_id;

    @Column(name="method_name")
    private String method_name;

    @Column(name="method_modifier")
    private String method_modifier;


    @Column(name="method_type")
    private String method_type;

    public PersonalMethod() {}

    public PersonalMethod(String methodField) {
        extractName(methodField);
    }

    private void setMethodName(String name) { this.method_name = name; }

    private void extractName(String field) {
        String namePattern = "";

        Pattern pattern = Pattern.compile(namePattern);

        Matcher matcher = pattern.matcher(field);
    }

    private void extractModifier(String field) {
        String modifierPattern = "";

        Pattern pattern = Pattern.compile(modifierPattern);

        Matcher matcher = pattern.matcher(field);
    }

    private void extractType(String field) {
        String typePattern = "";

        Pattern pattern = Pattern.compile(typePattern);

        Matcher matcher = pattern.matcher(field);
    }
}
