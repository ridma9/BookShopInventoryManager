package com.inventoryManager;

import com.login.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInputs {
    private Scanner scanner = new Scanner(System.in);
    private Display display;
    private ItemHandler itemHandler;

    public UserInputs(Scanner scanner, Display display, ItemHandler itemHandler) {
        this.scanner = scanner;
        this.display = display;
        this.itemHandler = itemHandler;
    }

    public User userLoginInput(){
        display.print("Enter Username : ");
        String username =scanner.nextLine();
        display.print("Enter Password : ");
        String password =scanner.nextLine();
        User user =new User(username,password);
        return user;
    }


    public Item addItemInputs() throws IOException {

        this.display.print("Enter Book Name : ");
        String bookName=this.scanner.nextLine();
        this.display.print("Enter Book ID : ");
        int boobId=this.scanner.nextInt();
        this.display.print("Enter Book Quantity : ");
        int bookQty=this.scanner.nextInt();
        this.display.print("Enter Book Price : ");
        int bookPrice=this.scanner.nextInt();
        return new Item(bookName,boobId,bookQty,bookPrice);
    }

    public String searchInput(){
        this.display.print("Enter Book name to search : ");
        String searchName=this.scanner.next();
        return searchName;
    }

    public Map<String,Integer> updateQtyInput(){
        Map<String,Integer> map = new HashMap<>();
        this.display.print("Enter Book name to change quantity : ");
        String bookName=this.scanner.next();
        this.display.print("Enter quantity to add : ");
        int qty=this.scanner.nextInt();
        map.put(bookName,qty);
        return map;
    }

    public Map<String,Integer> purchaseInput(){
        Map<String,Integer> map = new HashMap<>();
        this.display.print("Enter purchasing Book name : ");
        String bookName=this.scanner.next();
        this.display.print("Enter purchasing quantity : ");
        int qty=this.scanner.nextInt();
        map.put(bookName,qty);
        return map;
    }


    public String deleteItemInput(){
        this.display.print("Enter name of the book to delete : ");
        String bookName= scanner.nextLine();
        return bookName;
    }
}
