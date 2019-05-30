package thanos.skoulopoulos.feedme.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StoreController {

    @Autowired
    private StoresRepository storesRepository;


    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public ArrayList<Store> getStores(){
        return storesRepository.getStores();
    }

    @RequestMapping(value = "/stores/new",  method = RequestMethod.POST)
    public ArrayList<Store> addStore(@RequestBody Store store){
        storesRepository.addStore(store);
        return storesRepository.getStores();
    }

    @RequestMapping(value = "/stores/all",  method = RequestMethod.POST)
    public ArrayList<Store> addStores(@RequestBody  ArrayList<Store> stores){
        storesRepository.addAll(stores);
        return storesRepository.getStores();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.DELETE)
    public ArrayList<Store> deleteStore(@PathVariable ("id") int id){
        storesRepository.deleteStore(id);
        return storesRepository.getStores();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    public ArrayList<Store> changeStore(@PathVariable ("id") int id,@RequestBody Store newStore){
        storesRepository.changeStore(id,newStore);
        return storesRepository.getStores();
    }



}
