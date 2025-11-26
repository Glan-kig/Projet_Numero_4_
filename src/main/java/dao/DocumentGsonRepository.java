package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import entity.Document;
import gestion.LocalDateAdapter;

import java.time.LocalDate;
import java.util.List;

public class DocumentGsonRepository implements DocumentRepository{
    private final String filename;
    private final Gson gson;

    public DocumentGsonRepository(String filename){
        this.filename = filename;
        this.gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
    }

    @Override
    public void save(List<Document> documents) {
        try(FileWriter writer = new FileWriter(filename)) {
            gson.toJson(documents, writer);
        }catch (IOException e){
            throw new RuntimeException("Erreur lors de la sauvegarde des Documents : "+ e.getMessage(), e);
        }
    }

    @Override
    public List<Document> load() {
        try(FileReader reader = new FileReader(filename)){
            Type type = new TypeToken<List<Document>>(){}.getType();
            return gson.fromJson(reader, type);
        }catch (IOException e){
            throw new RuntimeException("Erreur lors du chargement des Document : "+ e.getMessage(), e);
        }
    }

    @Override
    public void update(Document document) {

    }

    @Override
    public void delet(Document document) {

    }
}
