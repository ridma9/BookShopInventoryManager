package com.inventoryManager;

public class Item {
    private String itemName;
    private int itemId;
    private int itemqty;

    private int itemPrice;

    public Item() {
    }

    public Item(String itemName, int itemId, int itemqty, int itemPrice) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemqty = itemqty;
        this.itemPrice = itemPrice;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemqty() {
        return itemqty;
    }

    public void setItemqty(int itemqty) {
        this.itemqty = itemqty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemId=" + itemId +
                ", itemqty=" + itemqty +
                '}';
    }
}
