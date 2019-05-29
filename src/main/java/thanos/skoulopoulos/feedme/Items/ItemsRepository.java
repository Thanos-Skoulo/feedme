package thanos.skoulopoulos.feedme.Items;

import java.util.ArrayList;

public class ItemsRepository {

    private ArrayList<Item> items;

    public ItemsRepository() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {

        return items;
    }

    public void addItem(Item item) {
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
    }

    public void deleteItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }
}
