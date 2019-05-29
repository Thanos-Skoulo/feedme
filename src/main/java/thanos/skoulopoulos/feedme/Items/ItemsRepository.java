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
        if(item != null)
        items.add(item);
    }
}
