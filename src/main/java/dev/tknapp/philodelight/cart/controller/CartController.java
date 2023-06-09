package dev.tknapp.philodelight.cart.controller;

import dev.tknapp.philodelight.cart.dto.AddItemRequest;
import dev.tknapp.philodelight.cart.dto.AddItemResponse;
import dev.tknapp.philodelight.cart.model.Cart;
import dev.tknapp.philodelight.cart.model.CartRepository;
import dev.tknapp.philodelight.cart.pipeline.AddItemPipeline;
import dev.tknapp.philodelight.cart.pipeline.CheckoutPipeline;
import dev.tknapp.philodelight.item.model.Item;
import dev.tknapp.philodelight.item.model.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static dev.tknapp.philodelight.common.Constants.API_V1_CART_FULL;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1_CART_FULL)
public class CartController {
    
    private final CheckoutPipeline checkoutPipeline;
    
    private final AddItemPipeline addItemPipeline;
    
    private final CartRepository cartRepository;
    
    private final ItemRepository itemRepository;
    
    //TODO More logical endpoint order?...
    @PutMapping("/{cartId}/items/{itemId}")
    Cart enrollItemToCart(@PathVariable Long cartId, @PathVariable Long itemId){
    Cart cart = cartRepository.getOne(cartId);
    Item item = itemRepository.getOne(itemId);
    cart.enrollItem(item);
    return cartRepository.save(cart);
    }
    
    @PostMapping()
    public AddItemResponse addItem(@RequestBody AddItemRequest request){
        return addItemPipeline.add(request);
    }
}
