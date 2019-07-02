package thanos.skoulopoulos.feedme.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ItemController {

    @Autowired
    private ItemsRepository itemsRepository;



        @RequestMapping(value = "/items", method = RequestMethod.GET)
        public ArrayList<Item> getItems(){

          return  itemsRepository.getItems();
        }

        @RequestMapping(value = "/items", method = RequestMethod.POST )
        public ArrayList<Item> addItem(@RequestBody Item item){
            itemsRepository.addItem(item);
            return itemsRepository.getItems();

        }

        @RequestMapping(value = "/items/{itemId}", method = RequestMethod.DELETE)
        public  ArrayList<Item> removeItem(@PathVariable ("itemId") int itemId) {
            itemsRepository.deleteItem(itemId);
            return itemsRepository.getItems();
        }



}
