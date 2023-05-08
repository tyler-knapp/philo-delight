package dev.tknapp.philodelight.controller;

import dev.tknapp.philodelight.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private final List<Item> items;
    private final double tax;
    private final double totalAmount;
    private final String coupon;
    
    public ShoppingCart(){
        this.items = new ArrayList<>();
        this.coupon = "";
        this.totalAmount = 0;
        this.tax = 0;
    }
    
    public void addToCart(Item item){
        this.items.add(item);
    }
    
    public void showCart(){
        for (Item item : this.items) {
            System.out.println(item);
        }
    }
    
    public double getTax() {
        return tax;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    public String getCoupon() {
        return coupon;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", tax=" + tax +
                ", totalAmount=" + totalAmount +
                ", coupon='" + coupon + '\'' +
                '}';
    }
}
