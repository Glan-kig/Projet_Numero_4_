package dao;

import entity.Document;

import java.util.List;

public class DocumentFileRepository implements DocumentRepository{
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
