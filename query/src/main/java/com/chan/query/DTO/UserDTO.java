package com.chan.query.DTO;

public class UserDTO {
    private String username;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

}
