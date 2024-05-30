package com.in28minutes.springboot.web.entity;

public class User {

    private Long id;

    private String name;

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User() {
    }
}
