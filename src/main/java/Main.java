import dao.DocumentListRepository;
import entity.*;

void main() {
    List<Document>Doc = new ArrayList<>();
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

    for (Document d : repos.load()){
        d.information();
    }

}