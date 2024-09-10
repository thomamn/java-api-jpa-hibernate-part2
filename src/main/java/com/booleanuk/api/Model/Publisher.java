package com.booleanuk.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String location;

    public Integer getId() {return id;}

    public String getName() { return name;}

    public String getLocation() {return location;}

    public void setId(Integer id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setLocation(String location) {this.location = location;}
}
