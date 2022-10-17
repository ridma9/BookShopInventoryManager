package com.inventoryManager;

import com.dbmanager.DbHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemHandler {
    /**
     * add items
     * read all items
     * search items
     * update items
     * delete items
     * purchase items
     */
    //Path inventoryFile=Paths.get("E:\\Coding\\InventoryManagementSystem\\inventory.json");
    Path inventoryFile2 = Paths.get("E:\\Coding\\InventoryManagementSystem\\inventory2.json");

    public void addItem(Item item) throws IOException, SQLException {
        List<Item> itemList = readAllItems();
        itemList.add(item);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(inventoryFile2.toFile(), itemList);

    }

    public List<Item> readAllItems() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ObjectMapper().readValue(inventoryFile2.toFile(), new TypeReference<List<Item>>() {
        });
        return items;
    }

    public void searchItem(String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ObjectMapper().readValue(inventoryFile2.toFile(), new TypeReference<List<Item>>() {});
        Item searchedItem = null;
        boolean found = false;
        for (Item item : items) {
            if (item.getItemName().equals(name)) {
                //System.out.println(item.toString());
                searchedItem = item;
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Book not Found..");
        } else {
            System.out.print("Book Found : ");
            System.out.println(searchedItem.toString());
        }
    }

    public void purchaseItem(String name,int qty) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ObjectMapper().readValue(inventoryFile2.toFile(), new TypeReference<List<Item>>() {});
        boolean bookFound=false;
        for (Item tempItem : items) {
            if (tempItem.getItemName().equals(name)) {
                bookFound=true;
                if (tempItem.getItemqty()>qty){
                    tempItem.setItemqty(tempItem.getItemqty()-qty);
                    System.out.println("Purchased "+qty+" "+name+" books.");
                    mapper.writerWithDefaultPrettyPrinter().writeValue(inventoryFile2.toFile(), items);
                }else {
                    System.out.println("Not enough books. Only availabe "+tempItem.getItemqty()+" books.");
                }
            }
        }
        if (!bookFound) System.out.println("Book not found.");
        for (Item item:items) {
            System.out.println(item.toString());
        }
    }

    public void updateQty(String name, int newQty) throws IOException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ObjectMapper().readValue(inventoryFile2.toFile(), new TypeReference<List<Item>>() {});
        boolean found = false;
        for (Item item : items) {
            if (item.getItemName().equals(name)) {
                item.setItemqty(item.getItemqty()+newQty);
                mapper.writerWithDefaultPrettyPrinter().writeValue(inventoryFile2.toFile(), items);
                found = true;
                System.out.println("Updated quantity of "+item.getItemName()+". New quantity is :"+item.getItemqty());
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    public void deleteItem(String name) throws IOException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ObjectMapper().readValue(inventoryFile2.toFile(), new TypeReference<List<Item>>() {});
        boolean found = false;
        for (Item item : items) {
            if (item.getItemName().equals(name)) {
                items.remove(item);
                mapper.writerWithDefaultPrettyPrinter().writeValue(inventoryFile2.toFile(), items);
                System.out.println("Book removed Succesfully.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Book Not Found.");
    }




}

