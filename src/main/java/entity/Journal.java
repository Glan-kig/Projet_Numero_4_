package entity;

import java.time.LocalDate;

public class Journal extends Document implements Disponibilisant{
    private LocalDate date_parution;

    public Journal(String titre, String auteur, int code, int annee_publication, int nombre_exemplaire, String disponibilite, LocalDate date_parution) {
        super(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite);
        this.date_parution = date_parution;
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
        System.out.println("Journal : " + getTitre() + " est ou en : " + getDisponibilite());
    }

    public void setDate_parution(LocalDate date_parution){
        this.date_parution = date_parution;
    }

    public LocalDate getDate_parution(){
        return this.date_parution;
    }

    public void information(){
        System.out.println(" Titre du Journal : " + titre + "\n Auteur : " + auteur + "\n Code : " + code +
                "\n Année de Publication : " + annee_publication + "\n Nombre d'exemplaire : " + nombre_exemplaire +
                "\n Disponibilité : " + disponibilite + "\n Date de Parution : " + date_parution + "\n");
    }
}
