package dev.tknapp.philodelight.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.tknapp.philodelight.cart.model.Cart;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledItems")
    private Set<Cart> carts = new HashSet<>();
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Cart> getCarts() {
        return carts;
    }
    
}
