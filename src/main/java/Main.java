import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DocumentFileRepository;
import dao.DocumentGsonRepository;
import dao.DocumentListRepository;
import entity.*;
import gestion.LocalDateAdapter;
import static operation.MesOperations.*;

void main() {
    List<Document> Doc = new ArrayList<>();
    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
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

    DocumentFileRepository repoFile = new DocumentFileRepository("doc.txt");
    DocumentGsonRepository repoGson = new DocumentGsonRepository("doc.json");

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
                AjoutLivre(repos, Doc);
            } else if (choix == 2) {
                AjoutJournal(repos, Doc);
            } else if (choix == 3) {
                AjoutMagazine(repos, Doc);
            } else if (choix == 4) {
                AjoutCd_dvd(repos, Doc);
            }else {
                System.out.println("Choix invalide.");
                break;
            }
        } else if (choix == 3) {
            ModifierDocG();
            choix = ent.nextInt();
            if (choix == 1){
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
            } else if (choix == 2) {
                ModifierDoc();
                choix = ent.nextInt();
                if (choix == 1){
                    ModifierLivreTxt();
                } else if (choix == 2) {
                    ModifierJournalTxt();
                } else if (choix == 3) {
                    ModifierMagazineTxt();
                } else if (choix == 4) {
                    ModifierCd_dvdTxt();
                }else {
                    System.out.println("Choix invalide.");
                    break;
                }
            } else if (choix == 3) {
                ModifierDoc();
                choix = ent.nextInt();
                if (choix == 1){
                    ModifierLivreGson();
                } else if (choix == 2) {
                    ModifierJournalGson();
                } else if (choix == 3) {
                    ModifierMagazineGson();
                } else if (choix == 4) {
                    ModifierCd_dvdGson();
                }else {
                    System.out.println("Choix invalide.");
                    break;
                }
            }else {
                System.out.println("Choix invalide.");
                break;
            }

        } else if (choix == 4) {
            SupprimerDocument();
            choix = ent.nextInt();
            if (choix == 1){
                SupprimerDocumentG();
                choix = ent.nextInt();
                if (choix == 1){
                    SupprimerLivre(repos);
                } else if (choix == 2) {
                    SupprimerJournal(repos);
                } else if (choix == 3) {
                    SupprimerMagazine(repos);
                } else if (choix == 4) {
                    SupprimerCd_dvd(repos);
                }else {
                    System.out.println("Choix invalide.");
                    break;
                }
            } else if (choix == 2) {
                SupprimerDocumentG();
                choix = ent.nextInt();
                if (choix == 1){
                    SupprimerLivreTxt();
                } else if (choix == 2) {
                    SupprimerJournalTxt();
                } else if (choix == 3) {
                    SupprimerMagazineTxt();
                } else if (choix == 4) {
                    SupprimerCd_dvdTxt();
                }else {
                    System.out.println("Choix invalide.");
                    break;
                }
            } else if (choix == 3) {
                SupprimerDocumentG();
                choix = ent.nextInt();
                if (choix == 1){
                    SupprimerLivreGson();
                } else if (choix == 2) {
                    SupprimerJournalGson();
                } else if (choix == 3) {
                    SupprimerMagazineGson();
                } else if (choix == 4) {
                    SupprimerCd_dvdGson();
                }else {
                    System.out.println("Choix invalide.");
                    break;
                }
            }else {
                System.out.println("Choix invalide.");
                break;
            }

        } else if (choix == 5) {
            EmprunterDocument();
            choix= ent.nextInt();
            if (choix == 1){
                EmprunterLivre(repos);
            } else if (choix == 2) {
                EmprunterJournal(repos);
            } else if (choix == 3) {
                EmprunterMagazine(repos);
            } else if (choix == 4) {
                EmprunterCd_dvd(repos);
            }else {
                System.out.println("Choix invalide.");
                break;
            }
        } else if (choix == 6) {
            RetournerDocument();
            choix = ent.nextInt();
            if (choix == 1){
                RetournerLivre(repos);
            } else if (choix == 2) {
                RetournerJournal(repos);
            } else if (choix == 3) {
                RetournerMagazine(repos);
            } else if (choix == 4) {
                RetournerCd_dvd(repos);
            }else {
                System.out.println("Choix invalide.");
                break;
            }
        } else if (choix == 0) {
            System.out.println("Au revoir!");
            break;
        }else if (choix == 7){
            AjoutFichier();
            choix = ent.nextInt();
            if (choix == 1){
                AjoutFichierTxt(repos);
            } else if (choix == 2) {
                AjoutFichierGson(repos);
            }else {
                System.out.println("Choix invalide.");
                break;
            }
        }else {
            System.out.println("Choix invalide.");
            break;
        }
    }

}

