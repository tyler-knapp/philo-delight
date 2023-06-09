package dev.tknapp.philodelight.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.tknapp.philodelight.item.model.Item;
import dev.tknapp.philodelight.item.model.ItemRepository;
import dev.tknapp.philodelight.item.service.ItemService;
import dev.tknapp.philodelight.util.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.tknapp.philodelight.common.Constants.*;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1_ITEM_FULL)
@Slf4j
public class ItemController {
    
    ItemRepository itemRepository;
    
    ItemService service;
    
    private static final ObjectMapper objectMapper = ObjectMapperUtils.getObjectMapper();
    
    @PostMapping("/add")
    public Item addItem(@RequestBody final Item item){
        return service.saveItem(item);
    }
    
    @GetMapping("/all")
    public List<Item> getAllItems(){
        return service.getAllItems();
    }
    
    //Admin Access
    //@PreAuthorize("ADMIN")
    @DeleteMapping("/remove")
    public void deleteItem(@RequestBody Item item){
        Long itemId = item.getId();
        itemRepository.deleteById(itemId);
    }
    
}
 