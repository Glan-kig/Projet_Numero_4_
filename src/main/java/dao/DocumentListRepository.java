package dao;

import entity.Document;

import java.util.List;

public class DocumentListRepository implements DocumentRepository{
    private List<Document>documents;

    @Override
    public void save(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public List<Document> load() {
        return this.documents;
    }
}
