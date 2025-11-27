package operation;

import dao.DocumentFileRepository;
import dao.DocumentGsonRepository;
import dao.DocumentListRepository;
import entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MesOperations {


    public static void Menu(){
        System.out.println(" ==========Menu========== ");
        System.out.println("1. Afficher Les Documents en stock ");
        System.out.println("2. Ajouter Document ");
        System.out.println("3. Modifier Document ");
        System.out.println("4. Supprimer Document ");
        System.out.println("5. Empruter Document ");
        System.out.println("6. Retourner Document ");
        System.out.println("7. Importer information dans un fichier ");
        System.out.println("0. Quitter. ");
    }

    public static void AjoutDocument(){
        System.out.println("Choisir le type de Document : ");
        System.out.println("1. Livre ");
        System.out.println("2. Journal ");
        System.out.println("3. Magazine ");
        System.out.println("4. Cd_dvd ");
    }

    public static void AjoutLivre(DocumentListRepository repos, List<Document>documents){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir le titre du livre : ");
        String titre = ent.next();
        System.out.println("Saisir le nom de l'auteur : ");
        String auteur = ent.nextLine();
        auteur = ent.nextLine();
        System.out.println("Saisir le code du livre : ");
        int code = ent.nextInt();
        System.out.println("Saisir l'année de publication du livre : ");
        int annee_publication = ent.nextInt();
        System.out.println("Saisir le nombre d'exemplaire du livre : ");
        int nombre_exemplaire = ent.nextInt();
        System.out.println("Saisir la disponibilité du livre : ");
        String disponibilite = ent.nextLine();
        disponibilite = ent.nextLine();
        System.out.println("Saisir le nombre de page du livre : ");
        int nombre_page = ent.nextInt();

        documents.add(new Livre(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, nombre_page));
        repos.save(documents);
        System.out.println("Livre Ajouter avec succes.");
    }

    public static void AjoutJournal(DocumentListRepository repos, List<Document>documents){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir le titre du Journal : ");
        String titre = ent.next();
        System.out.println("Saisir le nom de l'auteur : ");
        String auteur = ent.nextLine();
        auteur = ent.nextLine();
        System.out.println("Saisir le code du Journal : ");
        int code = ent.nextInt();
        System.out.println("Saisir l'année de publication du Journal : ");
        int annee_publication = ent.nextInt();
        System.out.println("Saisir le nombre d'exemplaire du Journal : ");
        int nombre_exemplaire = ent.nextInt();
        System.out.println("Saisir la disponibilité du Journal : ");
        String disponibilite = ent.nextLine();
        disponibilite = ent.nextLine();
        System.out.println("Saisir la date de parution du Journal au format (YYYY-MM-dd): ");
        System.out.print("Année : ");
        int annee = ent.nextInt();
        System.out.print("Mois : ");
        int mois = ent.nextInt();
        System.out.print("Jour : ");
        int jour = ent.nextInt();
        LocalDate dat = LocalDate.of(annee, mois, jour);

        documents.add(new Journal( titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, dat));
        repos.save(documents);
        System.out.println("Journal Ajouter avec succes.");
    }

    public static void AjoutMagazine(DocumentListRepository repos, List<Document>documents){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir le titre du Magazine : ");
        String titre = ent.next();
        System.out.println("Saisir le nom de l'auteur : ");
        String auteur = ent.nextLine();
        auteur = ent.nextLine();
        System.out.println("Saisir le code du Magazine : ");
        int code = ent.nextInt();
        System.out.println("Saisir l'année de publication du Magazine : ");
        int annee_publication = ent.nextInt();
        System.out.println("Saisir le nombre d'exemplaire du Magazine : ");
        int nombre_exemplaire = ent.nextInt();
        System.out.println("Saisir la disponibilité du Magazine : ");
        String disponibilite = ent.nextLine();
        disponibilite = ent.nextLine();
        System.out.println("Saisir  d'édition du Magazine : ");
        int numero_edition = ent.nextInt();

        documents.add(new Magazine(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, numero_edition));
        repos.save(documents);
        System.out.println("Magazine Ajouter avec succes.");
    }

    public static void AjoutCd_dvd(DocumentListRepository repos, List<Document>documents) {
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir le titre du Disque : ");
        String titre = ent.next();
        System.out.println("Saisir le nom de l'auteur : ");
        String auteur = ent.nextLine();
        auteur = ent.nextLine();
        System.out.println("Saisir le code du Disque : ");
        int code = ent.nextInt();
        System.out.println("Saisir l'année de publication du Disque : ");
        int annee_publication = ent.nextInt();
        System.out.println("Saisir le nombre d'exemplaire du Disque : ");
        int nombre_exemplaire = ent.nextInt();
        System.out.println("Saisir la disponibilité du Disque : ");
        String disponibilite = ent.nextLine();
        disponibilite = ent.nextLine();
        System.out.println("Saisir la durée du Disque : ");
        double duree = ent.nextDouble();

        documents.add(new Cd_dvd(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, duree));
        repos.save(documents);
        System.out.println("Cd_dvd Ajouter avec succes.");
    }

    public static void ModifierDocG(){
        System.out.println("Saisir type document à modifier : ");
        System.out.println("1. Livre ");
        System.out.println("2. Journal ");
        System.out.println("3. Magazine ");
        System.out.println("4. Cd_dvd ");
    }

    public static void ModifierDoc(){
        System.out.println("Saisir le type de stockage : ");
        System.out.println("1. List ");
        System.out.println("2. Texte ");
        System.out.println("3. Json ");
    }

    public static void ModifierLivre(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document r : repos.load()){
            if (r.getTitre().equalsIgnoreCase(titre) && r instanceof Livre){
                System.out.println("Saisir le titre du livre : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du livre : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du livre : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du livre : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du livre : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir le nombre de page du livre : ");
                int nombre_page = ent.nextInt();

                r = new Livre(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, nombre_page);
                System.out.println("Livre modifier avec succes.");
                break;
            }else if (r.getTitre() != titre && r instanceof Livre){
                System.out.println("Livre introuvable.");
            }
        }
    }

    public static void ModifierJournal(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Journal){
                System.out.println("Saisir le titre du Journal : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Journal : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Journal : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Journal : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Journal : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la date de parution du Journal au format (YYYY-MM-dd): ");
                System.out.print("Année : ");
                int annee = ent.nextInt();
                System.out.print("Mois : ");
                int mois = ent.nextInt();
                System.out.print("Jour : ");
                int jour = ent.nextInt();
                LocalDate dat = LocalDate.of(annee, mois, jour);

                d = new Journal(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, dat);
                System.out.println("Journal modifier avec succes.");
            }else {
                System.out.println("Journal introuvable.");
            }
        }
    }

    public static void ModifierMagazine(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Magazine){
                System.out.println("Saisir le titre du Magazine : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Magazine : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Magazine : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Magazine : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Magazine : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir  d'édition du Magazine : ");
                int numero_edition = ent.nextInt();

                d = new Magazine(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, numero_edition);
                System.out.println("Magazine Modifier avec succes.");
            }else {
                System.out.println("Magazine introuvable.");
            }
        }
    }

    public static void ModifierCd_dvd(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Cd_dvd){
                System.out.println("Saisir le titre du Disque : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Disque : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Disque : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Disque : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Disque : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la durée du Disque : ");
                double duree = ent.nextDouble();

                d = new Cd_dvd(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, duree);
                System.out.println("Cd_dvd modifier avec succes.");
            }else {
                System.out.println("CD_dvd introuvable.");
            }
        }
    }

    public static void SupprimerDocumentG(){
        System.out.println("Saisir type document à Supprimer : ");
        System.out.println("1. Livre ");
        System.out.println("2. Journal ");
        System.out.println("3. Magazine ");
        System.out.println("4. Cd_dvd ");
    }

    public static void SupprimerDocument(){
        System.out.println("Saisir le type de stockage : ");
        System.out.println("1. List ");
        System.out.println("2. Texte ");
        System.out.println("3. Json ");
    }

    public static void SupprimerLivre(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Livre Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerJournal(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Journal Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerMagazine(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Magazine Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerCd_dvd(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Disque Supprimer avec succes.");
                break;
            }
        }
    }

    public static void EmprunterDocument(){
        System.out.println("Saisir type document à emprunter : ");
        System.out.println("1. Livre ");
        System.out.println("2. Journal ");
        System.out.println("3. Magazine ");
        System.out.println("4. Cd_dvd ");
    }

    public static void EmprunterLivre(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                ((Livre) d).changer_disponibilite();
                System.out.println("Livre Emprunter avec succes.");
                break;
            }else if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                System.out.println("Livre indisponible");
            }
        }
    }

    public static void EmprunterJournal(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                ((Journal) d).changer_disponibilite();
                System.out.println("Journal Emprunter avec succes.");
                break;
            }else if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                System.out.println("Journal indisponible");
            }
        }
    }

    public static void EmprunterMagazine(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                ((Magazine) d).changer_disponibilite();
                System.out.println("Magazine Emprunter avec succes.");
                break;
            }else if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                System.out.println("Magazine indisponible");
            }
        }
    }

    public static void EmprunterCd_dvd(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                ((Cd_dvd) d).changer_disponibilite();
                System.out.println("Cd_dvd Emprunter avec succes.");
                break;
            }else if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                System.out.println("Cd_dvd indisponible");
            }
        }
    }

    public static void RetournerDocument(){
        System.out.println("Saisir type document à retourner : ");
        System.out.println("1. Livre ");
        System.out.println("2. Journal ");
        System.out.println("3. Magazine ");
        System.out.println("4. Cd_dvd ");
    }

    public static void RetournerLivre(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                ((Livre) d).changer_disponibilite();
                System.out.println("Livre Retourner avec succes.");
                break;
            }else if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                System.out.println("Livre pas Emprunter");
            }
        }
    }

    public static void RetournerJournal(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                ((Journal) d).changer_disponibilite();
                System.out.println("Journal Retourner avec succes.");
                break;
            }else if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                System.out.println("Journal pas Emprunter");
            }
        }
    }

    public static void RetournerMagazine(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                ((Magazine) d).changer_disponibilite();
                System.out.println("Magazine Retourner avec succes.");
                break;
            }else if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                System.out.println("Magazine pas Emprunter");
            }
        }
    }

    public static void RetournerCd_dvd(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Rupture de stock"){
                ((Cd_dvd) d).changer_disponibilite();
                System.out.println("Cd_dvd Retourner avec succes.");
                break;
            }else if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre) && d.getDisponibilite() == "Disponible"){
                System.out.println("Cd_dvd pas Emprunter");
            }
        }
    }

    public static void AjoutFichier(){
        System.out.println("Importer les donnees dans quel type de fichier ? ");
        System.out.println("1. Texte");
        System.out.println("2. Gson");
    }

    public static void AjoutFichierTxt(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir le nom du fichier sans Extention! : ");
        String filename = ent.nextLine() + ".txt";

        List<Document> documents = new ArrayList<>();
        for (Document d : repos.load()){
            documents.add(d);
        }
        try {
            DocumentFileRepository doc = new DocumentFileRepository(filename);
            doc.save(documents);
            System.out.println("Fichier creer avec succes!");
        }catch (Exception e){
            System.out.println("Erreur lors de la creation du fichier");
        }
    }

    public static void AjoutFichierGson(DocumentListRepository repos){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisir le nom du fichier sans Extention! : ");
        String filename = ent.nextLine() + ".json";

        List<Document>documents = new ArrayList<>();
        for (Document d : repos.load()){
            documents.add(d);
        }
        try {
            DocumentGsonRepository doc = new DocumentGsonRepository(filename);
            doc.save(documents);
            System.out.println("Fichier creer avec succes!");
        } catch (Exception e) {
            System.out.println("Erreur lors de la creation du fichier");
        }

    }

    public static void AfficherInfoTxt(DocumentFileRepository repos){
        List<Document>documents = repos.load();
        try {
            for (Document d : documents){
                System.out.println(d);
            }
        } catch (Exception e) {

        }
    }

    public static void AfficherInfoGson(DocumentGsonRepository repos){
        List<Document>documents = repos.load();
        try {
            for (Document d : documents){
                System.out.println(d);
            }
        }catch (Exception e){

        }
    }

    public static void ModifierLivreTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Livre){
                System.out.println("Saisir le titre du Livre : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Livre : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Livre : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Livre : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Livre : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la durée du Livre : ");
                int nombre_page = ent.nextInt();

                d = new Livre(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, nombre_page);
                System.out.println("Livre modifier avec succes.");
            }else {
                System.out.println("Livre introuvable.");
            }
        }
    }

    public static void ModifierJournalTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Journal){
                System.out.println("Saisir le titre du Journal : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Journal : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Journal : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Journal : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Journal : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la date de parution du Journal au format (YYYY-MM-dd): ");
                System.out.print("Année : ");
                int annee = ent.nextInt();
                System.out.print("Mois : ");
                int mois = ent.nextInt();
                System.out.print("Jour : ");
                int jour = ent.nextInt();
                LocalDate dat = LocalDate.of(annee, mois, jour);

                d = new Journal(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, dat);
                System.out.println("Journal modifier avec succes.");
            }else {
                System.out.println("Journal introuvable.");
            }
        }
    }

    public static void ModifierMagazineTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Magazine){
                System.out.println("Saisir le titre du Magazine : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Magazine : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Magazine : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Magazine : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Magazine : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir  d'édition du Magazine : ");
                int numero_edition = ent.nextInt();

                d = new Magazine(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, numero_edition);
                System.out.println("Magazine Modifier avec succes.");
            }else {
                System.out.println("Magazine introuvable.");
            }
        }
    }

    public static void ModifierCd_dvdTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Cd_dvd){
                System.out.println("Saisir le titre du Disque : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Disque : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Disque : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Disque : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Disque : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la durée du Disque : ");
                double duree = ent.nextDouble();

                d = new Cd_dvd(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, duree);
                System.out.println("Cd_dvd modifier avec succes.");
            }else {
                System.out.println("CD_dvd introuvable.");
            }
        }
    }

    public static void ModifierLivreGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Livre){
                System.out.println("Saisir le titre du Livre : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Livre : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Livre : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Livre : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Livre : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la durée du Livre : ");
                int nombre_page = ent.nextInt();

                d = new Livre(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, nombre_page);
                System.out.println("Livre modifier avec succes.");
            }else {
                System.out.println("Livre introuvable.");
            }
        }
    }

    public static void ModifierJournalGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Journal){
                System.out.println("Saisir le titre du Journal : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Journal : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Journal : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Journal : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Journal : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la date de parution du Journal au format (YYYY-MM-dd): ");
                System.out.print("Année : ");
                int annee = ent.nextInt();
                System.out.print("Mois : ");
                int mois = ent.nextInt();
                System.out.print("Jour : ");
                int jour = ent.nextInt();
                LocalDate dat = LocalDate.of(annee, mois, jour);

                d = new Journal(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, dat);
                System.out.println("Journal modifier avec succes.");
            }else {
                System.out.println("Journal introuvable.");
            }
        }
    }

    public static void ModifierMagazineGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Magazine){
                System.out.println("Saisir le titre du Magazine : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Magazine : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Magazine : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Magazine : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Magazine : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir  d'édition du Magazine : ");
                int numero_edition = ent.nextInt();

                d = new Magazine(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, numero_edition);
                System.out.println("Magazine Modifier avec succes.");
            }else {
                System.out.println("Magazine introuvable.");
            }
        }
    }

    public static void ModifierCd_dvdGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if ( d.getTitre().equalsIgnoreCase(titre) && d instanceof Cd_dvd){
                System.out.println("Saisir le titre du Disque : ");
                String Titre = ent.next();
                System.out.println("Saisir le nom de l'auteur : ");
                String auteur = ent.nextLine();
                auteur = ent.nextLine();
                System.out.println("Saisir le code du Disque : ");
                int code = ent.nextInt();
                System.out.println("Saisir l'année de publication du Disque : ");
                int annee_publication = ent.nextInt();
                System.out.println("Saisir le nombre d'exemplaire du Disque : ");
                int nombre_exemplaire = ent.nextInt();
                System.out.println("Saisir la disponibilité du Disque : ");
                String disponibilite = ent.nextLine();
                disponibilite = ent.nextLine();
                System.out.println("Saisir la durée du Disque : ");
                double duree = ent.nextDouble();

                d = new Cd_dvd(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, duree);
                System.out.println("Cd_dvd modifier avec succes.");
            }else {
                System.out.println("CD_dvd introuvable.");
            }
        }
    }

    public static void SupprimerLivreTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentFileRepository repos = new DocumentFileRepository(filename);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Livre Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerJournalTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentFileRepository repos = new DocumentFileRepository(filename);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Journal Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerMagazineTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentFileRepository repos = new DocumentFileRepository(filename);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Magazine Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerCd_dvdTxt(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".txt";
        DocumentFileRepository repos = new DocumentFileRepository(filename);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Disque Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerLivreGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Livre : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Livre && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Livre Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerJournalGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Journal : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Journal && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Journal Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerMagazineGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Magazine : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Magazine && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Magazine Supprimer avec succes.");
                break;
            }
        }
    }

    public static void SupprimerCd_dvdGson(){
        Scanner ent = new Scanner(System.in);
        System.out.println("Saisire le nom du fichier sans Extention : ");
        String filename = ent.nextLine() + ".json";
        DocumentGsonRepository repos = new DocumentGsonRepository(filename);
        System.out.println("Saisir Titre du Cd_dvd : ");
        String titre = ent.nextLine();

        for (Document d : repos.load()){
            if (d instanceof Cd_dvd && d.getTitre().equalsIgnoreCase(titre)){
                repos.load().remove(d);
                System.out.println("Disque Supprimer avec succes.");
                break;
            }
        }
    }
}
