package com.booleanuk.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;
    private String last_name;
    private String email;
    private boolean alive;

    public Integer getId() {return id;}

    public String getEmail() { return email;}

    public String getFirst_name() {return first_name;}

    public String getLast_name() {return last_name;}

    public boolean isAlive() {return alive;}

    public void setId(Integer id) {this.id = id;}

    public void setEmail(String email) {this.email = email;}

    public void setAlive(boolean alive) {this.alive = alive;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}
}
