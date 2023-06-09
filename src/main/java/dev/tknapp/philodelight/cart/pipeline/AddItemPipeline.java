package dev.tknapp.philodelight.cart.pipeline;

import dev.tknapp.philodelight.cart.dto.AddItemRequest;
import dev.tknapp.philodelight.cart.dto.AddItemResponse;

public interface AddItemPipeline {
    
    AddItemResponse add(AddItemRequest request);
}
