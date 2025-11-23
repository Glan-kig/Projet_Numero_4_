package entity;

public abstract class Document {
    protected String titre;
    protected String auteur;
    protected int code;
    protected int annee_publication;
    protected int nombre_exemplaire;
    protected String disponibilite;

    public Document(String titre, String auteur, int code, int annee_publication, int nombre_exemplaire, String disponibilite){
        this.titre = titre;
        this.auteur = auteur;
        this.code = code;
        this.annee_publication = annee_publication;
        this.nombre_exemplaire = nombre_exemplaire;
        this.disponibilite = disponibilite;
    }

    public abstract void information();

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setAnnee_publication(int annee_publication){
        this.annee_publication = annee_publication;
    }

    public void setNombre_exemplaire(int nombre_exemplaire){
        this.nombre_exemplaire = nombre_exemplaire;
    }

    public void setDisponibilite(String disponibilite){
        this.disponibilite = disponibilite;
    }

    public String getDisponibilite(){
        return this.disponibilite;
    }

    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public int getAnnee_publication() {
        return this.annee_publication;
    }

    public int getCode() {
        return this.code;
    }

    public int getNombre_exemplaire(){
        return this.nombre_exemplaire;
    }
}
