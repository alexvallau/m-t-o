package app.appmeteo;


import java.io.*;
import java.util.ArrayList;

public class FavCityList {

    private ArrayList<String> favCity;
    private String cityToAdd;


    public FavCityList() {

    }


    public  ArrayList<String> extractListFromFile() throws IOException, ClassNotFoundException {

        ArrayList<String> villesFavories;
        try (FileInputStream rFavoriteCityFile = new FileInputStream("favoriteCityFile")) {
            //transforme le fichier.txt en objet
            ObjectInputStream rFavoriteCityObject = new ObjectInputStream(rFavoriteCityFile);
            villesFavories = (ArrayList<String>) rFavoriteCityObject.readObject();
            rFavoriteCityObject.close();
            rFavoriteCityFile.close();
        }

        return villesFavories;

    }

    public void saveListInFile(ArrayList<String> listToSave) throws IOException, ClassNotFoundException {

        FileOutputStream wFavoriteCityFile = new FileOutputStream("favoriteCityFile");
        ObjectOutputStream wFavoriteCityFileObject = new ObjectOutputStream(wFavoriteCityFile);
        wFavoriteCityFileObject.writeObject(listToSave);

    }

    public ArrayList<String> getVillesFavories() throws IOException, ClassNotFoundException {

        return extractListFromFile();
    }


    public void addCity(String cityToAdd) throws IOException, ClassNotFoundException {

        File rechercheFichier = new File("favoriteCityFile");
        String villeLowered = cityToAdd.toLowerCase();
        //on fait une condition pour voir si le fichier existe déjà ou non

        //si il n'existe pas, on le créé:
      /*  if (!rechercheFichier.isFile()) {
            ArrayList<String> villesFavories = getVillesFavories();
            villesFavories.add(villeLowered);
            saveListInFile(villesFavories);
            System.out.println("Ville Insérée1");


        }
        //si le fichier externe existe: on le récupère, on le transforme en objet, puis en liste
        //puis on ajoute la ville désirée puis on retransforme en objet ls liste..
        else {     //récupère le fichier.txt

       */


        ArrayList<String> villeFavories = extractListFromFile();
        if (cityDoestExist(villeLowered))
            System.out.println("La ville" + villeLowered + " est déjà dans vos villes favories!");

        else{
            villeFavories.add(villeLowered);
            saveListInFile(villeFavories);
        }



    }




    public  boolean cityDoestExist(String ville) throws IOException, ClassNotFoundException {

        //on met tout en minuscule pour être sur qu'une différence de majuscule ne trompe pas le programme
        String villeLowered = ville.toLowerCase();
        ArrayList<String> villeFavories = extractListFromFile();

        if (villeFavories.contains(villeLowered)) {
            return true;
        } else {
            return false;
        }

    }


    public  void deleteCity(String ville) throws IOException, ClassNotFoundException {

        ArrayList<String> villesFavories = extractListFromFile();
        String villeLowered = ville.toLowerCase();

        if (villesFavories.contains(villeLowered)) {
            villesFavories.remove(villeLowered);
            saveListInFile(villesFavories);
        }
    }



}
