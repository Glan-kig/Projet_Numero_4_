package entity;

public class Livre extends Document implements Disponibilisant{
    private int nombre_page;

    public Livre(String titre, String auteur, int code, int annee_publication, int nombre_exemplaire, String disponibilite, int nombre_page) {
        super(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite);
        this.nombre_page = nombre_page;
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
        System.out.println("Livre : " + getTitre() + " est ou en : " + getDisponibilite());
    }

    public void setNombre_page(int nombre_page){
        this.nombre_page = nombre_page;
    }

    public int getNombre_page(){
        return this.nombre_page;
    }

    public void information(){
        System.out.println(" Titre du Livre : " + titre + "\n Auteur : " + auteur + "\n Code : " + code +
                "\n Année de Publication : " + annee_publication + "\n Nombre d'exemplaire : " + nombre_exemplaire +
                "\n Disponibilité : " + disponibilite + "\n Nombre de Pages : " + nombre_page + "\n");
    }
}
