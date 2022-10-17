package com.login;

import com.inventoryManager.Display;

import java.util.Scanner;

public class Login {

    private User user;

    public Login(User user) {
        this.user = user;
    }
    Display display = new Display();
    Scanner scanner = new Scanner(System.in);

    public boolean userLogin(){
        display.print("Enter Username : ");
        String username=scanner.nextLine();
        if (user.getUsername().equals(username)){
            display.print("Enter Password : ");
            String password=scanner.nextLine();
            if (user.getPassword().equals(password)){
                display.print("Logged in.");
                return true;
            }else {
                display.print("Incorrect Password. Try Again.");
                return false;
            }
        }else{
            display.print("Username is Incorrect. Try Again.");
        }
        return false;
    }
}
