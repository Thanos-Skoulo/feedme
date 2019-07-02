package thanos.skoulopoulos.feedme.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thanos.skoulopoulos.feedme.common.ApiResponse;
import java.util.ArrayList;


@RestController
public class StoreController {

    @Autowired
    private StoresRepository storesRepository;

    public StoreController(StoresRepository storesRepository) {
        this.storesRepository = storesRepository;
    }


    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public ArrayList<Store> getStores(){
        return storesRepository.getStores();
    }



    @RequestMapping(value = "/stores/new", method = RequestMethod.POST)
    public ApiResponse<Store> addStore(@RequestBody Store store){
        if(storesRepository.addStore(store)){
            return new ApiResponse<>(store);
        }else
            return new ApiResponse<>("id already exists");
    }

    @RequestMapping(value = "/stores/all",  method = RequestMethod.POST)
    private ArrayList<Store> addStores(@RequestBody ArrayList<Store> stores){
        storesRepository.addAll(stores);
        return storesRepository.getStores();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.DELETE)
    public ApiResponse<Integer> deleteStore(@PathVariable ("id") int id){
        if(storesRepository.deleteStore(id)){
            return new ApiResponse<>(id);
        }else{
            return new ApiResponse<>("this id doesn't exist");
        }
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    private ArrayList<Store> changeStore(@PathVariable("id") int id, @RequestBody Store newStore){
        storesRepository.changeStore(id,newStore);
        return storesRepository.getStores();
    }

}
