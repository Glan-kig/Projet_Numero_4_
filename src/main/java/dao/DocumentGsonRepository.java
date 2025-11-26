package dao;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import entity.Document;

import java.util.List;

public class DocumentGsonRepository implements DocumentRepository{
    private String filename;


    public DocumentGsonRepository(String filename){

    }

    @Override
    public void save(List<Document> documents) {

    }

    @Override
    public List<Document> load() {
        return List.of();
    }

    @Override
    public void update(Document document) {

    }

    @Override
    public void delet(Document document) {

    }
}
