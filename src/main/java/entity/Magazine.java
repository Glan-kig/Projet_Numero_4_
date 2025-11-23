package entity;

public class Magazine extends Document implements Disponibilisant{
    private int numero_edition;

    public Magazine(String titre, String auteur, int code, int annee_publication, int nombre_exemplaire, String disponibilite, int numero_edition){
        super(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite);
        this.numero_edition = numero_edition;
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
        System.out.println("Magazine : " + getTitre() + " est ou en : " + getDisponibilite());
    }

    public void setNumero_edition(int numero_edition){
        this.numero_edition = numero_edition;
    }

    public int getNumero_edition(){
        return this.numero_edition;
    }


    public void information(){
        System.out.println(" Titre du Magazine : " + titre + "\n Auteur : " + auteur + "\n Code : " + code +
                "\n Année de Publication : " + annee_publication + "\n Nombre d'exemplaire : " + nombre_exemplaire +
                "\n Disponibilité : " + disponibilite + "\n Numéro d'édition : " + numero_edition + "\n");
    }
}
