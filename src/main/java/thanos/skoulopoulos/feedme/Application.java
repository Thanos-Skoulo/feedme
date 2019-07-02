package thanos.skoulopoulos.feedme;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import thanos.skoulopoulos.feedme.Items.Item;
import thanos.skoulopoulos.feedme.Items.ItemsRepository;
import thanos.skoulopoulos.feedme.stores.Store;
import thanos.skoulopoulos.feedme.stores.StoresRepository;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@SpringBootApplication
@ComponentScan
public class Application {

    private Gson gson = new Gson();


    @Bean
    public StoresRepository storesRepository(){
        ArrayList<Store> stores = new ArrayList<>();
        try(JsonReader jsonReader = new JsonReader(new FileReader("SavedStores.json"))){
            stores = gson.fromJson(jsonReader, new TypeToken<ArrayList<Store>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  new StoresRepository(stores);
    }

    @Bean
    public ItemsRepository itemRepository(){
        ArrayList<Item> items = new ArrayList<>();
        try (JsonReader jsonReader = new JsonReader(new FileReader("SavedItems.json"))){
            items = gson.fromJson(jsonReader, new TypeToken<ArrayList<Item>>(){}.getType());
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ItemsRepository(items);
    }


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


}
