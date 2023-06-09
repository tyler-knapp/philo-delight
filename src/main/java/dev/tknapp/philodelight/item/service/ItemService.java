package dev.tknapp.philodelight.item.service;

import dev.tknapp.philodelight.item.model.Item;

import java.util.List;

public interface ItemService {
    
    Item saveItem(Item item);
    
    List<Item> getAllItems();
    
    void delete(Item item);
}
