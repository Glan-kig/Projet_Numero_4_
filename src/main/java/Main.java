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

            } else if (choix == 3) {

            } else if (choix == 4) {

            }else {
                System.out.println("Choix invalide.");
                break;
            }
        } else if (choix == 3) {

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
    String date = ent.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
    LocalDate dat = LocalDate.parse(date, formatter);

    /*Journal.add(titre, auteur, code, annee_publication, nombre_exemplaire, disponibilite, dat);*/
}