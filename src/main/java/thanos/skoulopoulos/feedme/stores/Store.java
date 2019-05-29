package thanos.skoulopoulos.feedme.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Store {

    @JsonProperty("id")
    private int id;
    @JsonProperty("storeName")
    private String storeName;
    @JsonProperty("storeAddress")
    private String storeAddress;
    @JsonProperty("storeWebSite")
    private String storeWebSite;



    public Store(String storeName, int id, String storeAddress, String storeWebSite) {
        this.storeName = storeName;
        this.id = id;
        this.storeAddress = storeAddress;
        this.storeWebSite = storeWebSite;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getId() {
        return id;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStoreWebSite() {
        return storeWebSite;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public void setStoreWebSite(String storeWebSite) {
        this.storeWebSite = storeWebSite;
    }
}
