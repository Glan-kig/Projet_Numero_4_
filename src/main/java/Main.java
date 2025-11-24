import dao.DocumentListRepository;
import entity.*;

void main() {
    List<Document> Doc = new ArrayList<>();
    Doc.add(new Livre(
            "Life",
            "Gilkay",
            01,
            1985,
            10,
            "Disponible",
            450
    ));
    Doc.add(new Magazine(
            "M1",
            "Glk",
            02,
            1990,
            15,
            "Rupture de stock",
            01
    ));
    Doc.add(new Journal(
            "J1",
            "JJ",
            03,
            2000,
            20,
            "Disponibilité",
            LocalDate.of(2000, 11, 22)
    ));
    Doc.add(new Cd_dvd(
            "D1",
            "DD",
            04,
            1980,
            15,
            "Disponibilité",
            24.30
    ));

    DocumentListRepository repos = new DocumentListRepository();
    repos.save(Doc);

    while (true) {
        Menu();
        Scanner ent = new Scanner(System.in);
        int choix = ent.nextInt();

        if (choix == 1){
            for (Document d : repos.load()){
                d.information();
            }
        } else if (choix == 2) {
            AjoutDocument();
            choix = ent.nextInt();
            if (choix == 1){
                AjoutLivre(repos);
            } else if (choix == 2) {
                AjoutJournal(repos);
            } else if (choix == 3) {
                AjoutMagazine(repos);
            } else if (choix == 4) {
                AjoutCd_dvd(repos);
            }else {
                System.out.println("Choix invalide.");
                break;
            }
        } else if (choix == 3) {
            ModifierDoc();
            choix = ent.nextInt();
            if (choix == 1){
                ModifierLivre(repos);
            } else if (choix == 2) {
                ModifierJournal(repos);
            } else if (choix == 3) {
                ModifierMagazine(repos);
            } else if (choix == 4) {
                ModifierCd_dvd(repos);
            }else {
                System.out.println("Choix invalide.");
                break;
            }
        } else if (choix == 4) {

        } else if (choix == 5) {

        } else if (choix == 6) {

        } else if (choix == 0) {
            System.out.println("Au revoir!");
            break;
        }else {
            System.out.println("Choix invalide.");
            break;
        }
    }

}

public void Menu(){
    System.out.println(" ==========Menu========== ");
    System.out.println("1. Afficher Les Documents en stock ");
    System.out.println("2. Ajouter Document ");
    System.out.println("3. Modifier Document ");
    System.out.println("4. Supprimer Document ");
    System.out.println("5. Empruter Document ");
    System.out.println("6. Retourner Document ");
    System.out.println("0. Quitter. ");
}

public void AjoutDocument(){
    System.out.println("Choisir le type de Document : ");
    System.out.println("1. Livre ");
    System.out.println("2. Journal ");
    System.out.println("3. Magazine ");
    System.out.println("4. Cd_dvd ");
}

public void AjoutLivre(DocumentListRepository repos){
    List<Document>Livre = new ArrayList<>();
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir le titre du livre : ");
    String titre = ent.next();
    System.out.println("Saisir le nom de l'auteur : ");
    String auteur = ent.nextLine();
    System.out.println("Saisir le code du livre : ");
    int code = ent.nextInt();
    System.out.println("Saisir l'année de publication du livre : ");
    int annee_publication = ent.nextInt();
    System.out.println("Saisir le nombre d'exemplaire du livre : ");
    int nombre_exemplaire = ent.nextInt();
    System.out.println("Saisir la disponibilité du livre : ");
    String disponibilite = ent.nextLine();
    System.out.println("Saisir le nombre de page du livre : ");
    int nombre_page = ent.nextInt();

    Livre.add(new Livre(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, nombre_page));
    repos.save(Livre);
}

public void AjoutJournal(DocumentListRepository repos){
    List<Document>Journal = new ArrayList<>();
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir le titre du Journal : ");
    String titre = ent.next();
    System.out.println("Saisir le nom de l'auteur : ");
    String auteur = ent.nextLine();
    System.out.println("Saisir le code du Journal : ");
    int code = ent.nextInt();
    System.out.println("Saisir l'année de publication du Journal : ");
    int annee_publication = ent.nextInt();
    System.out.println("Saisir le nombre d'exemplaire du Journal : ");
    int nombre_exemplaire = ent.nextInt();
    System.out.println("Saisir la disponibilité du Journal : ");
    String disponibilite = ent.nextLine();
    System.out.println("Saisir la date de parution du Journal au format (YYYY-MM-dd): ");
    System.out.print("Année : ");
    int annee = ent.nextInt();
    System.out.print("Mois : ");
    int mois = ent.nextInt();
    System.out.print("Jour : ");
    int jour = ent.nextInt();
    LocalDate dat = LocalDate.of(annee, mois, jour);

    Journal.add(new Journal( titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, dat));
}

public void AjoutMagazine(DocumentListRepository repos){
    List<Document>Magazine = new ArrayList<>();
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir le titre du Magazine : ");
    String titre = ent.next();
    System.out.println("Saisir le nom de l'auteur : ");
    String auteur = ent.nextLine();
    System.out.println("Saisir le code du Magazine : ");
    int code = ent.nextInt();
    System.out.println("Saisir l'année de publication du Magazine : ");
    int annee_publication = ent.nextInt();
    System.out.println("Saisir le nombre d'exemplaire du Magazine : ");
    int nombre_exemplaire = ent.nextInt();
    System.out.println("Saisir la disponibilité du Magazine : ");
    String disponibilite = ent.nextLine();
    System.out.println("Saisir  d'édition du Magazine : ");
    int numero_edition = ent.nextInt();

    Magazine.add(new Magazine(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, numero_edition));
    repos.save(Magazine);
}

public void AjoutCd_dvd(DocumentListRepository repos) {
    List<Document> Cd_dvd = new ArrayList<>();
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir le titre du Disque : ");
    String titre = ent.next();
    System.out.println("Saisir le nom de l'auteur : ");
    String auteur = ent.nextLine();
    System.out.println("Saisir le code du Disque : ");
    int code = ent.nextInt();
    System.out.println("Saisir l'année de publication du Disque : ");
    int annee_publication = ent.nextInt();
    System.out.println("Saisir le nombre d'exemplaire du Disque : ");
    int nombre_exemplaire = ent.nextInt();
    System.out.println("Saisir la disponibilité du Disque : ");
    String disponibilite = ent.nextLine();
    System.out.println("Saisir la durée du Disque : ");
    double duree = ent.nextDouble();

    Cd_dvd.add(new Cd_dvd(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, duree));
    repos.save(Cd_dvd);
}

public void ModifierDoc(){
    System.out.println("Saisir type document à modifier : ");
    System.out.println("1. Livre ");
    System.out.println("2. Journal ");
    System.out.println("3. Magazine ");
    System.out.println("4. Cd_dvd ");
}

public void ModifierLivre(DocumentListRepository repos){
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir Titre du Livre : ");
    String titre = ent.nextLine();

    for (Document r : repos.load()){
        if (r.getTitre() == titre || r instanceof Livre){
            System.out.println("Saisir le titre du livre : ");
            String Titre = ent.next();
            System.out.println("Saisir le nom de l'auteur : ");
            String auteur = ent.nextLine();
            System.out.println("Saisir le code du livre : ");
            int code = ent.nextInt();
            System.out.println("Saisir l'année de publication du livre : ");
            int annee_publication = ent.nextInt();
            System.out.println("Saisir le nombre d'exemplaire du livre : ");
            int nombre_exemplaire = ent.nextInt();
            System.out.println("Saisir la disponibilité du livre : ");
            String disponibilite = ent.nextLine();
            System.out.println("Saisir le nombre de page du livre : ");
            int nombre_page = ent.nextInt();

            r = new Livre(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, nombre_page);
            System.out.println("Journal modifier avec succes.");
        }else {
            System.out.println("Livre introuvable.");
        }
    }
}

public void ModifierJournal(DocumentListRepository repos){
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir Titre du Journal : ");
    String titre = ent.nextLine();

    for (Document d : repos.load()){
        if (d instanceof Journal || d.getTitre() == titre){
            System.out.println("Saisir le titre du Journal : ");
            String Titre = ent.next();
            System.out.println("Saisir le nom de l'auteur : ");
            String auteur = ent.nextLine();
            System.out.println("Saisir le code du Journal : ");
            int code = ent.nextInt();
            System.out.println("Saisir l'année de publication du Journal : ");
            int annee_publication = ent.nextInt();
            System.out.println("Saisir le nombre d'exemplaire du Journal : ");
            int nombre_exemplaire = ent.nextInt();
            System.out.println("Saisir la disponibilité du Journal : ");
            String disponibilite = ent.nextLine();
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

public void ModifierMagazine(DocumentListRepository repos){
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir Titre du Magazine : ");
    String titre = ent.nextLine();

    for (Document d : repos.load()){
        if (d instanceof Magazine || d.getTitre() == titre){
            System.out.println("Saisir le titre du Magazine : ");
            String Titre = ent.next();
            System.out.println("Saisir le nom de l'auteur : ");
            String auteur = ent.nextLine();
            System.out.println("Saisir le code du Magazine : ");
            int code = ent.nextInt();
            System.out.println("Saisir l'année de publication du Magazine : ");
            int annee_publication = ent.nextInt();
            System.out.println("Saisir le nombre d'exemplaire du Magazine : ");
            int nombre_exemplaire = ent.nextInt();
            System.out.println("Saisir la disponibilité du Magazine : ");
            String disponibilite = ent.nextLine();
            System.out.println("Saisir  d'édition du Magazine : ");
            int numero_edition = ent.nextInt();

            d = new Magazine(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, numero_edition);
            System.out.println("Magazine Modifier avec succes.");
        }else {
            System.out.println("Magazine introuvable.");
        }
    }
}

public void ModifierCd_dvd(DocumentListRepository repos){
    Scanner ent = new Scanner(System.in);
    System.out.println("Saisir Titre du Cd_dvd : ");
    String titre = ent.nextLine();

    for (Document d : repos.load()){
        if (d instanceof Cd_dvd || d.getTitre() == titre){
            System.out.println("Saisir le titre du Disque : ");
            String Titre = ent.next();
            System.out.println("Saisir le nom de l'auteur : ");
            String auteur = ent.nextLine();
            System.out.println("Saisir le code du Disque : ");
            int code = ent.nextInt();
            System.out.println("Saisir l'année de publication du Disque : ");
            int annee_publication = ent.nextInt();
            System.out.println("Saisir le nombre d'exemplaire du Disque : ");
            int nombre_exemplaire = ent.nextInt();
            System.out.println("Saisir la disponibilité du Disque : ");
            String disponibilite = ent.nextLine();
            System.out.println("Saisir la durée du Disque : ");
            double duree = ent.nextDouble();

            d = new Cd_dvd(Titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, duree);
            System.out.println("Cd_dvd modifier avec succes.");
        }else {
            System.out.println("CD_dvd introuvable.");
        }
    }
}