package app.appmeteo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class AppMeteoCLITest {
    private AppMeteoCLI appMeteoCLI = new AppMeteoCLI();
    @Test
    void rechercheMeteo() throws IOException {
    }

    @Test
    void insertVilleInExernFile() throws IOException, ClassNotFoundException {
        ArrayList<String> villeFavories = new ArrayList<>();
        String ville = "marseille";
        villeFavories.add(ville);
        String ville1 = "Marseille";
        AppMeteoCLI.insertVilleInExernFile(ville1);
        Assertions.assertEquals(villeFavories, AppMeteoCLI.getListFromFile());
    }

    @Test
    void villeDoestExist() throws IOException, ClassNotFoundException {
        String ville = "marseille";
        AppMeteoCLI.insertVilleInExernFile(ville);
        Assertions.assertTrue(AppMeteoCLI.villeDoestExist(ville));
        Assertions.assertFalse(AppMeteoCLI.villeDoestExist("dakar"));
    }

    @Test
    void getVillesFavories() throws IOException, ClassNotFoundException {
        ArrayList<String> villesFavories = new ArrayList<>();
        villesFavories.add("marseille");villesFavories.add("paris");
        AppMeteoCLI.insertVilleInExernFile("marseille");
        AppMeteoCLI.insertVilleInExernFile("paris");
        Assertions.assertEquals(villesFavories , appMeteoCLI.getVillesFavories());
    }

    @Test
    void deleteFavoriteVille() throws IOException, ClassNotFoundException {

        ArrayList<String> villeFavories = new ArrayList<>();
        villeFavories.add("dakar");
        AppMeteoCLI.insertVilleInExernFile("marseille");
        AppMeteoCLI.insertVilleInExernFile("dakar");
        appMeteoCLI.deleteFavoriteVille("marseille");

        Assertions.assertEquals(villeFavories, appMeteoCLI.getVillesFavories());



    }


    @Test
    void saveListInFile() throws IOException, ClassNotFoundException {
        ArrayList<String> villeFavories = new ArrayList<>();
        villeFavories.add("dakar");
        appMeteoCLI.saveListInFile(villeFavories);
        Assertions.assertEquals(villeFavories,appMeteoCLI.getVillesFavories());

    }

    @Test
    void getListFromFile() throws IOException, ClassNotFoundException {
        ArrayList<String> villeFavories = new ArrayList<>();
        villeFavories.add("paris");
        appMeteoCLI.insertVilleInExernFile("paris");
        Assertions.assertEquals(villeFavories, appMeteoCLI.getListFromFile());
    }
}