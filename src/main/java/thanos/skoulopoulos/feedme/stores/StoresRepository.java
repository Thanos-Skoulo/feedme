package thanos.skoulopoulos.feedme.stores;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StoresRepository {
    private ArrayList<Store> stores;



    public StoresRepository(ArrayList<Store> stores) {
        this.stores = stores;
    }



    ArrayList<Store> getStores() {
        return stores;
    }

    void addStore(Store store) {
        boolean idExists = false;
        if(store != null)
            for(Store newStore: stores){
                if(newStore.getId()==store.getId()){
                    idExists = true;
                }
            }
        if(idExists){
            System.out.println("already exists");
        }else{
            stores.add(store);
            saveToFile();
        }



    }

    void addAll(ArrayList<Store> stores) {
        this.stores.addAll(stores);
        saveToFile();
    }

    void deleteStore(int id) {
        stores.removeIf(store -> store.getId()==id);
        saveToFile();
    }


    void changeStore(int id, Store newStore) {
        Store storeToChange = null;
         for(Store store: stores){
             if(store.getId() == id){
                 storeToChange = store;
             }
         }
         if(storeToChange!= null){
        storeToChange.setStoreName(newStore.getStoreName());
        storeToChange.setStoreAddress(newStore.getStoreAddress());
        storeToChange.setStoreWebSite(newStore.getStoreWebSite());
        saveToFile();}

    }

    private void saveToFile(){
        try
                (FileWriter fileWriter =new FileWriter("SavedStores.json")){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(stores, fileWriter);
        }catch (IOException e){

        }
    }
}
