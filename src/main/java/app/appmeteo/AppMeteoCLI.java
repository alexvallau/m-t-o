package app.appmeteo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMeteoCLI {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // int taille = getSizeArray();
        //ArrayList<String> test = getListFromFile();

        int input = 1;
        boolean first = true;
        System.out.println("Bienvenue dans l'application météo révolutionnaire,que voulez vous faire? \n 1) Recherche Rapide \n 2) Consulter ses villes favorites \n 3) Ajouter Une ville aux Favoris \n 4) Supprimer une ville des favoris \n 0) Quitter \n tapez : ");
        while (input != 0) {
            if(!first) {
                System.out.println(" que voulez vous faire? \n 1) Recherche Rapide \n 2) " +
                        "Consulter ses villes favorites \n 3) Ajouter Une ville aux Favoris \n 4) Supprimer une ville des favoris \n 0) Quitter \n tapez : ");
            }
            first = false;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {

                input = scanner.nextInt();
                if (input == 1 || input == 2 || input == 3 || input == 4) {
                    //recherche rapide
                    if (input == 1) {
                        System.out.println("Système de recherche Rapide, veuillez entrer la ville désirée");
                        scanner.nextLine();
                        String ville = scanner.nextLine();

                        Object[] donneesMeteo = rechercheMeteo(ville);
                        System.out.println("Données Météorologiques pour " + donneesMeteo[0] + "\n" + "Température: " + donneesMeteo[1] + " Degrès \n température ressentie: " +
                                donneesMeteo[2] + "degrés \nTemps:" + donneesMeteo[3]);

                        //consulter ses villes favories
                    } else if (input == 2) {
                        ArrayList<String> villesFavories = getVillesFavories();
                        int nombreVille = getSizeArray();
                        if (nombreVille == 0) {

                            System.out.println("Vous N'avez aucune ville favorite, voulez vous en ajouter une? Veuillez entrer 1 pour Oui \n 2 pour Non ");

                            if (scanner.hasNextInt()) {
                                int choixReponse = scanner.nextInt();

                                if (choixReponse == 1) {
                                    System.out.println("veuillez écrire la ville à ajouter aux Favoris");
                                    scanner.nextLine();
                                    String ville = scanner.nextLine();
                                    insertVilleInExernFile(ville);
                                } else
                                    System.out.println("Au revoir");

                            } else {
                                System.out.println("ça n'est pas un entier, réessayez !");
                            }
                        } else {

                            System.out.println("Voici la météo de vos villes favories \n");
                            for (int i = 0; i < villesFavories.size(); i++) {
                                String nomVille = villesFavories.get(i);
                                Object[] donneesMeteo = rechercheMeteo(villesFavories.get(i));
                                System.out.println("Données Météorologiques pour " + donneesMeteo[0] + "\n" +
                                        "Température: " + donneesMeteo[1] + " Degrès \n température ressentie: " + donneesMeteo[2] + "degrés \n Temps:" + donneesMeteo[3]);
                            }
                        }
                    }

                    //ajouter une ville a ses favoris
                    else if (input == 3) {

                        //on récupère débord le fichier externe pour y vérifier si la ville qui est sur le point d'être mise n'est pas déjà présente

                        System.out.println("veuillez écrire la ville à ajouter aux Favoris");
                        scanner.nextLine();
                        String ville = scanner.nextLine();

                        if (villeDoestExist(ville))
                            System.out.println("La ville" + ville + " est déjà dans vos villes favories!");

                        else {
                            insertVilleInExernFile(ville);
                        }


                        //supprimer une ville des favoris
                    } else if (input == 4) {

                        System.out.println("veuillez entrer la ville a supprimer svp");
                        scanner.nextLine();
                        String ville = scanner.nextLine();

                        deleteFavoriteVille(ville);
                        System.out.println(ville + " a été supprimé");
                    }
                } else {
                    System.out.println("Votre chiffre est different de ceux proposés, Réessayez !");
                }


            }
        }

    }


    public static Object[] rechercheMeteo(String ville) throws IOException {

        String input;
        StringBuilder textePageApi = new StringBuilder();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + ville + "&appid=f5ed2e80c2cdf7b97a863c0777a52a8d&lang=fr");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((input = in.readLine()) != null) {
            //readLine input prend la valeur de in qui est lu de ligne en  ligne
            textePageApi.append(input);
            //System.out.println(input);
        }
        in.close();

        JSONObject jsonObject = new JSONObject(textePageApi.toString());

        //récupère un tableau d'objet, ici représente la tableau commençant a weather, on a donc récupéré un tableau que l'on va pouvoir exploiter
        JSONArray weather = (JSONArray) jsonObject.get("weather");
        // le tableau récupéré ci dessous ne contient qu'un élément "weather", on peut donc le décomposer en objet et le traiter comme tel
        JSONObject recoverWeather = (JSONObject) weather.get(0);

        double villeTemp = jsonObject.getJSONObject("main").getInt("temp") - 273.15;
        double villeTempRessentie = jsonObject.getJSONObject("main").getInt("feels_like") - 273.15;

        //récupérer objet dans crochets
        String detailTemps = recoverWeather.getString("main");


        int villeTempCasted = (int) villeTemp;
        int villeTempRessCasted = (int) villeTempRessentie;
        //Récupérer objet sans accolades ni crochets
        String nomVille = jsonObject.getString("name");
        //Non objet: faire cette manoeuvre
        //int tempsVille = (int) jsonObject.getInt("timezone");


        Object[] valeurAStocker = new Object[4];

        valeurAStocker[0] = new String(nomVille);
        valeurAStocker[1] = Integer.valueOf(villeTempCasted);
        valeurAStocker[2] = Integer.valueOf(villeTempRessCasted);
        valeurAStocker[3] = new String(detailTemps);

        return valeurAStocker;
    }


    public static void insertVilleInExernFile(String ville) throws IOException, ClassNotFoundException {

        File rechercheFichier = new File("favoriteCityFile");
        String villeLowered = ville.toLowerCase();
        //on fait une condition pour voir si le fichier existe déjà ou non

        //si il n'existe pas, on le créé:
        if (!rechercheFichier.isFile()) {
            ArrayList<String> villesFavories = getVillesFavories();
            villesFavories.add(villeLowered);
            saveListInFile(villesFavories);
            System.out.println("Ville Insérée1");


        }
        //si le fichier externe existe: on le récupère, on le transforme en objet, puis en liste
        //puis on ajoute la ville désirée puis on retransforme en objet ls liste..
        else {     //récupère le fichier.txt


            ArrayList<String> villeFavories = getListFromFile();
            villeFavories.add(villeLowered);
            saveListInFile(villeFavories);
            System.out.println("Ville Insérée1");

        }

    }

    public static boolean villeDoestExist(String ville) throws IOException, ClassNotFoundException {

        //on met tout en minuscule pour être sur qu'une différence de majuscule ne trompe pas le programme
        String villeLowered = ville.toLowerCase();
        ArrayList<String> villeFavories = getListFromFile();

        if (villeFavories.contains(villeLowered)) {
            return true;
        } else {
            return false;
        }

    }

    public static ArrayList<String> getVillesFavories() throws IOException, ClassNotFoundException {

        return getListFromFile();
    }


    public static void deleteFavoriteVille(String ville) throws IOException, ClassNotFoundException {

        ArrayList<String> villesFavories = getListFromFile();
        String villeLowered = ville.toLowerCase();

        if (villesFavories.contains(villeLowered)) {
            villesFavories.remove(villeLowered);
            saveListInFile(villesFavories);
        }
    }


    public static int getSizeArray() throws IOException, ClassNotFoundException {

        ArrayList<String> villesFavories = getListFromFile();
        return villesFavories.size();
    }


    public static void saveListInFile(ArrayList<String> listToSave) throws IOException {

        FileOutputStream wFavoriteCityFile = new FileOutputStream("favoriteCityFile");
        ObjectOutputStream wFavoriteCityFileObject = new ObjectOutputStream(wFavoriteCityFile);
        wFavoriteCityFileObject.writeObject(listToSave);

    }

    public static ArrayList<String> getListFromFile() throws IOException, ClassNotFoundException {
        FileInputStream rFavoriteCityFile = new FileInputStream("favoriteCityFile");
        //transforme le fichier.txt en objet
        ObjectInputStream rFavoriteCityObject = new ObjectInputStream(rFavoriteCityFile);

        ArrayList<String> villesFavories = (ArrayList<String>) rFavoriteCityObject.readObject();
        rFavoriteCityObject.close();
        rFavoriteCityFile.close();

        return villesFavories;

    }

}
