package dev.tknapp.philodelight.cart.model;

import dev.tknapp.philodelight.item.model.Item;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "EMAIL")
    private String email;
    
    @ManyToMany
    @JoinTable(
            name = "cart_items",
    joinColumns = @JoinColumn(name = "cart_id"),
    inverseJoinColumns = @JoinColumn(name = "item_id"))
    private final Set<Item> enrolledItems = new HashSet<>();
    
    public Long getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Set<Item> getEnrolledItems() {
        return enrolledItems;
    }
    
    public void enrollItem(Item item) {
        enrolledItems.add(item);
    }
    
}
