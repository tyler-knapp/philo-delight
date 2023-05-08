package dev.tknapp.philodelight.item.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    //TODO - This may need to be a BigDecimal at some point?
    @Column(name = "price")
    private BigDecimal price;
    
}
