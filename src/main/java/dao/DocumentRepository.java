package dao;

import entity.Document;

import java.util.List;

public interface DocumentRepository {
    public void save(List<Document>documents);
    public List<Document> load();
}
