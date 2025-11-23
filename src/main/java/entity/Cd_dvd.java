package entity;

public class Cd_dvd extends Document implements Disponibilisant{
    private double duree;

    public Cd_dvd(String titre, String auteur, int code, int annee_publication, int nombre_exemplaire, String disponibilite, double duree){
        super(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite);
        this.duree = duree;
    }

    @Override
    public void changer_disponibilite(){
        if (disponibilite == "Rupture de stock"){
            disponibilite = "Disponible";
        }else {
            disponibilite = "Rupture de stock";
        }
    }

    @Override
    public void voir_disponibilite() {
        System.out.println("Cd_dvd : " + getTitre() + " est ou en : " + getDisponibilite());
    }

    public void setDuree(double duree){
        this.duree = duree;
    }

    public double getDuree(){
        return this.duree;
    }

    public void information(){
        System.out.println(" Titre du Disque: " + titre + "\n Auteur : " + auteur + "\n Code : " + code +
                "\n Année de Publication : " + annee_publication + "\n Nombre d'exemplaire : " + nombre_exemplaire +
                "\n Disponibilité : " + disponibilite + "\n Durée : " + duree + " minutes \n");
    }
}
