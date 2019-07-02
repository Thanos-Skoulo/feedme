package thanos.skoulopoulos.feedme.Items;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ItemsRepository {


    private ArrayList<Item> items;

    public ItemsRepository(ArrayList<Item> items) {
        this.items = items;
    }



    ArrayList<Item> getItems() {

        return items;
    }



     void addItem(Item item) {
        boolean idExists = false;
        if(item != null)
            for(Item newItem: items){
                if(newItem.getItemId()==item.getItemId()){
                    idExists = true;
                }
            }
        if(idExists){
            System.out.println("already exists");
        }else{
            items.add(item);
        }
        saveItems();
    }

    void deleteItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }

    private void saveItems() {
        try
            (FileWriter fileWriter = new FileWriter("SavedItems.json")){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(items, fileWriter);
            }catch (IOException e){
            e.printStackTrace();

        }

    }

}
