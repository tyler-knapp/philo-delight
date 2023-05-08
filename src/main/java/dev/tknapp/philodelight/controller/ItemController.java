package dev.tknapp.philodelight.controller;

import dev.tknapp.philodelight.model.Item;
import dev.tknapp.philodelight.model.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.tknapp.philodelight.constants.Constants.*;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1_ITEM_FULL)
public class ItemController {
    
    ItemRepository itemRepository;
    //Admin Access
    @PostMapping("/add")
    public Item hello(@RequestBody Item item){
        return itemRepository.save(item);
    }
    
    @GetMapping("/all")
    public List<Item> findAll(){
        return itemRepository.findAll();
    }
    
    @DeleteMapping("/remove")
    public void deleteItem(@RequestBody Item item){
        Long itemId = item.getId();
        itemRepository.deleteById(itemId);
    }
    
}
 