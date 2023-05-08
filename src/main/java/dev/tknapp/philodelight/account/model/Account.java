package dev.tknapp.philodelight.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String email;
}
