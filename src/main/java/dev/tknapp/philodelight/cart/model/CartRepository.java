package dev.tknapp.philodelight.cart.model;

import dev.tknapp.philodelight.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
