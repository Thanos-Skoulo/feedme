package thanos.skoulopoulos.feedme;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import thanos.skoulopoulos.feedme.stores.Store;
import thanos.skoulopoulos.feedme.stores.StoresRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@SpringBootApplication
@ComponentScan
public class Application {

    @Bean
    public StoresRepository storesRepository(){
        Gson gson = new Gson();
        ArrayList<Store> stores = new ArrayList<>();
        try(JsonReader jsonReader = new JsonReader(new FileReader("SavedStores.json"))){
            stores = gson.fromJson(jsonReader, new TypeToken<ArrayList<Store>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  new StoresRepository(stores);
    }


    public static void main(String[] args) {



        SpringApplication.run(Application.class, args);
    }


}
