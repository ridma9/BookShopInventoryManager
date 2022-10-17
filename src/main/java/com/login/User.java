package com.login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    Path userDataFile= Paths.get("E:\\Coding\\InventoryManagementSystem\\UserData.json");
    ObjectMapper mapper=new ObjectMapper();
    public void setUser() throws IOException {
        User newUser = new User(this.username,this.password);
        mapper.writerWithDefaultPrettyPrinter().writeValue(userDataFile.toFile(),newUser);
    }

    public User getUser() throws IOException {
        User user = mapper.readValue(userDataFile.toFile(), new TypeReference<User>() {});
        return user;
    }
}
