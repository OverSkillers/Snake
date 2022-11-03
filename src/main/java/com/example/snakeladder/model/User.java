package com.example.snakeladder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private int position;

    @Column(name = "lastRoll")
    private int roll;


    public User() {

    }

    public User(long id,String name, int position, int roll) {
        super();
        this.id = id;
        this.name=name;
        this.position=position;
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String firstName) {
        this.name = firstName;
    }
    public int getPosition() {
        return position;
    }
    public void setposition(int position) {
        this.position = position;
    }
}
