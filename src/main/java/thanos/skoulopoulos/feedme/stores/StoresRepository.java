package thanos.skoulopoulos.feedme.stores;

import java.util.ArrayList;

public class StoresRepository {
    private ArrayList<Store> stores;

    public StoresRepository() {
        stores = new ArrayList<>();
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void addStore(Store store) {
        if(store != null)
            stores.add(store);
    }

    public void addAll(ArrayList<Store> stores) {
        this.stores.addAll(stores);
    }

    public void deleteStore(int id) {
        stores.removeIf(store -> store.getId()==id);
    }


}
