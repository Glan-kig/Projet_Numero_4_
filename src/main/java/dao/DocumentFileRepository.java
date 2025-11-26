package dao;

import entity.Document;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DocumentFileRepository implements DocumentRepository{
    private String filename;

    public DocumentFileRepository(String filename){
        this.filename = filename;
    }

    @Override
    public void save(List<Document> documents) {
        try {
            ObjectOutputStream enregistreurObjet;
            FileOutputStream enregistrateurFichier = new FileOutputStream(filename);
            enregistreurObjet = new ObjectOutputStream(enregistrateurFichier);
            enregistreurObjet.writeObject(documents);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Document> load() {
        try {
            ObjectInputStream chargeur;
            FileInputStream chargeurFichier = new FileInputStream(filename);
            chargeur = new ObjectInputStream(chargeurFichier);
            List<Document>documents = (List<Document>) chargeur.readObject();
            return documents;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Document document) {

    }

    @Override
    public void delet(Document document) {

    }
}
