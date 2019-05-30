package thanos.skoulopoulos.feedme.Items;

import java.util.ArrayList;

class ItemsRepository {

    private ArrayList<Item> items;

    ItemsRepository() {
        items = new ArrayList<>();
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
    }

    void deleteItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }
}
