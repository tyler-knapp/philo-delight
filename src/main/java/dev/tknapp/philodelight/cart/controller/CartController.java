package dev.tknapp.philodelight.cart;

import dev.tknapp.philodelight.item.model.Item;
import dev.tknapp.philodelight.item.model.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.tknapp.philodelight.common.Constants.API_V1_CART_FULL;
import static dev.tknapp.philodelight.common.Constants.API_V1_ITEM_FULL;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1_CART_FULL)
public class CartController {
    
    CartRepository cartRepository;
    
    ItemRepository itemRepository;
    
    //TODO More logical endpoint order?...
    @PutMapping("/{cartId}/items/{itemId}")
    Cart enrollItemToCart(@PathVariable Long cartId, @PathVariable Long itemId){
    Cart cart = cartRepository.getOne(cartId);
    Item item = itemRepository.getOne(itemId);
    cart.enrollItem(item);
    return cartRepository.save(cart);
    }
}
