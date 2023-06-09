package dev.tknapp.philodelight.item.service.impl;

import dev.tknapp.philodelight.item.model.Item;
import dev.tknapp.philodelight.item.model.ItemRepository;
import dev.tknapp.philodelight.item.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    
    ItemRepository repository;
    
    @Override
    public Item saveItem(Item item) {
        return repository.save(item);
    }
    
    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }
    
    @Override
    public void delete(Item item) {
        repository.delete(item);
    }
}
