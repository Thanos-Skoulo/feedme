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

    boolean addStore(Store store) {
        boolean idExists = false;
        if(store != null)
            for(Store newStore: stores){
                if(newStore.getId()==store.getId()){
                    idExists = true;
                }
            }

        if(!idExists){
            stores.add(store);
            saveToFile();
        }
        return !idExists;
    }

    void addAll(ArrayList<Store> stores) {
        this.stores.addAll(stores);
        saveToFile();
    }

    boolean deleteStore(int id) {
        Store storeToDelete = null;
        boolean deleteStore = false;
        for(Store store: stores){
            if(store.getId() == id){
                storeToDelete = store;
            }
        }
        if(storeToDelete !=null){
            stores.remove(storeToDelete);
            deleteStore =true;
            saveToFile();
        }
        return deleteStore;
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

            e.printStackTrace();
        }
    }
}
