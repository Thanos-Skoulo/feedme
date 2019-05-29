package thanos.skoulopoulos.feedme.Items;

import org.springframework.web.bind.annotation.*;
import thanos.skoulopoulos.feedme.stores.StoresRepository;

import java.util.ArrayList;

@RestController
public class ItemController {

    private ItemsRepository itemsRepository = new ItemsRepository();
    private StoresRepository storesRepository = new StoresRepository();

        @RequestMapping(value = "/items", method = RequestMethod.GET)
        public ArrayList<Item> getItems(){

          return  itemsRepository.getItems();
        }

        @RequestMapping(value = "/items", method = RequestMethod.POST )
        public ArrayList<Item> addItem(@RequestBody Item item){
            itemsRepository.addItem(item);
            return itemsRepository.getItems();

        }

}
