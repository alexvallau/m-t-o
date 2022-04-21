package app.appmeteo.controller;

import app.appmeteo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class AppMeteoController implements Initializable {
    public Label labaelVille;
    public Label labelers;
    public Label labeltemps;
    public Label labeltemp;
    public Label descriptionMaino;
    public ImageView imgmeteoauj;
    public ImageView imgMeteoAujdhui;
    public  ImageView imgMeteoAujdhui1;
    public ImageView imgMeteoAujdhui2;
    public ImageView imgMeteoAujdhui3;
    public ImageView imgMeteoAujdhui4;



    @FXML
    private Label labelTest;

    @FXML
    private ListView favList;
    @FXML
    private TextField addFavField;
    @FXML
    private ListView<String> listViewFavoris;


    //déclaration variable de sortie fenêtre du bas
    @FXML
    private Label c0Date;
    @FXML
    private Label c0Matin;
    @FXML
    private Label c0Journee;
    @FXML
    private Label c0Soir;
    @FXML
    private Label c0Description;


    @FXML
    private Label c1Date;
    @FXML
    private Label c1Matin;
    @FXML
    private Label c1Journee;
    @FXML
    private Label c1Soir;
    @FXML
    private Label c1Description;

    @FXML
    private Label c2Date;
    @FXML
    private Label c2Matin;
    @FXML
    private Label c2Journee;
    @FXML
    private Label c2Soir;
    @FXML
    private Label c2Description;

    @FXML
    private Label c3Date;
    @FXML
    private Label c3Matin;
    @FXML
    private Label c3Journee;
    @FXML
    private Label c3Soir;
    @FXML
    private Label c3Description;

    @FXML
    private Label c4Date;
    @FXML
    private Label c4Matin;
    @FXML
    private Label c4Journee;
    @FXML
    private Label c4Soir;
    @FXML
    private Label c4Description;


    @FXML
    private Label dateMainField;
    @FXML
    private Label descriptionMain;
    @FXML
    private Label TmaxMain;
    @FXML
    private Label TminMain;
    @FXML
    private Label vent;
    @FXML
    private Label heure01Temp;
    @FXML
    private Label heure02Temp;
    @FXML
    private Label heure03Temp;
    @FXML
    private Label heure04Temp;
    @FXML
    private Label heure05Temp;
    @FXML
    private Label heure06Temp;
    @FXML
    private Label heure07Temp;
    @FXML
    private Label heure08Temp;

    @FXML
    private Label heure01;
    @FXML
    private Label heure02;
    @FXML
    private Label heure03;
    @FXML
    private Label heure04;
    @FXML
    private Label heure05;
    @FXML
    private Label heure06;
    @FXML
    private Label heure07;
    @FXML
    private Label heure08;


    @FXML
    public void savetext(ActionEvent event) throws IOException, ParseException {
        String ville = addFavField.getText();

        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(ville);
        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(ville);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();
        //String date = adddate.getText();
        weatherdatafiveD.fromWebToJson(ville);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();
        String date0 = listeDate.get(0);


        WeatherDataDaily Research = new WeatherDataDaily(addFavField.getText());







        //Main
        Object[] windowMain = weatherdatafiveD.dataWeather(date0);
        // An image file on the hard drive.
        //../../../ressources/app.appmeteo.view/images/nuageux.jpg
        //../../../../main/resources/app/appmeteo/view/images/nuageux.jpg
        File file_nuageux = new File("src/main/resources/app/appmeteo/view/images/nuageux.jpg");
        File file_ciel_degage = new File("src/main/resources/app/appmeteo/view/images/ciel_degage.jpg");
        File file_partiellement_nuageux = new File("src/main/resources/app/appmeteo/view/images/partiellement_nuageux.jpg");
        File file_peu_nuageux = new File("src/main/resources/app/appmeteo/view/images/peu_nuageux.jpg");
        File file_legere_pluie = new File("src/main/resources/app/appmeteo/view/images/legere_pluie.gif");
        File file_image_nuit_partiellement_nuageux = new File("src/main/resources/app/appmeteo/view/images/nuit_partiellement_nuageux.jpg");
        File file_couvert = new File("src/main/resources/app/appmeteo/view/images/couvert.jpg");
        //peu nuageux
        //partiellement nuageux
        //ciel dégagé
        //nuageux

// --> file:/C:/MyImages/myphoto.jpg
        String localUrl_nuageux = file_nuageux.toURI().toURL().toString();
        String localUrl_ciel_deg  = file_ciel_degage.toURI().toURL().toString();
        String localUrl_partiellement_nuageux = file_partiellement_nuageux.toURI().toURL().toString();
        String localUrl_peu_nuageux  = file_peu_nuageux.toURI().toURL().toString();
        String  url_legere_pluie = file_legere_pluie.toURI().toURL().toString();
        String  localUrl_image_nuit_partiellement_nuageux = file_image_nuit_partiellement_nuageux.toURI().toURL().toString();
        String localUrl_couvert = file_couvert.toURI().toURL().toString();


        Image img_centre_Nuageux = new Image(localUrl_nuageux, 402, 150, false, true);
        Image img_centre_ciel_Deg = new Image(localUrl_ciel_deg,402,150,false, true);
        Image img_centre_Partielle_Nuageux = new Image(localUrl_partiellement_nuageux,402,150,false, true);
        Image image_centre_peu_nuageux = new Image(localUrl_peu_nuageux,402,150,false, true);
        Image image_centre_legere_pluie = new Image(url_legere_pluie,402,150,false,true);
        Image image_centre_nuit_partiellement_nuageux = new Image(localUrl_image_nuit_partiellement_nuageux,402,150,false,true);
        Image image_centre_couvert = new Image(localUrl_couvert, 402,150, false, true);

        Image image_jour_a_venir_nuageux = new Image(localUrl_nuageux, 170, 100, false, true);
        Image image_jour_a_venir_ciel_deg = new Image(localUrl_ciel_deg,170,100,false, true);
        Image image_jour_a_venir_Partiellement_Nuageux = new Image(localUrl_partiellement_nuageux,170,100,false, true);
        Image image_jour_Avenir_Peu_Nuageux = new Image(localUrl_peu_nuageux,170,100,false, true);
        Image image_jour_a_venir_legere_pluie = new Image(url_legere_pluie,170,100,false,true);
        Image image_jour_Avenir_nuit_partiellement_nuageux = new Image(localUrl_image_nuit_partiellement_nuageux,170,100,false,true);
        Image image_jour_a_venir_couvert = new Image(localUrl_couvert, 170,100, false, true);




        //dateMainField.setText(date0);
        //int hour  = java.time.LocalTime.now().getHour();
        Object[] windowZeroMain = weatherOfTheDays.dataWeather(0);
        descriptionMain.setText("" + windowZeroMain[0]);
        if (descriptionMain.getText().contains("ciel dégagé"))
            imgmeteoauj.setImage(img_centre_ciel_Deg);
        else if(descriptionMain.getText().contains("partiellement nuageux"))
            imgmeteoauj.setImage(img_centre_Partielle_Nuageux);
        else if(descriptionMain.getText().contains("peu nuageux"))
            imgmeteoauj.setImage(image_centre_peu_nuageux);
        else if(descriptionMain.getText().contains("nuageux"))
            imgmeteoauj.setImage(img_centre_Nuageux);
        else if (descriptionMain.getText().contains("légère pluie") || descriptionMain.getText().contains("pluie modéré") )
            imgmeteoauj.setImage(image_centre_legere_pluie);
        else if(descriptionMain.getText().contains("couvert"))
            imgmeteoauj.setImage(image_centre_couvert);


        /*TmaxMain.setText("T° " + windowMain[3]);
        TminMain.setText("T° " + windowMain[4]);*/


        //case 0
        //Object[] windowZero = weatherdatafiveD.dataWeather(date0);
        Object[] windowZero = weatherOfTheDays.dataWeather(0);
        //c0Date.setText(date0);
        c0Description.setText("" + windowZero[0]);
        if (c0Description.getText().contains("ciel dégagé"))
            imgMeteoAujdhui.setImage(image_jour_a_venir_ciel_deg);
        else if(c0Description.getText().contains("partiellement nuageux"))
            imgMeteoAujdhui.setImage(image_jour_a_venir_Partiellement_Nuageux);
        else if(c0Description.getText().contains("peu nuageux"))
            imgMeteoAujdhui.setImage(image_jour_Avenir_Peu_Nuageux);
        else if(c0Description.getText().contains("nuageux"))
            imgMeteoAujdhui.setImage(image_jour_a_venir_nuageux);
        else if (descriptionMain.getText().contains("légère pluie") || descriptionMain.getText().contains("pluie modérée") )
            imgMeteoAujdhui.setImage(image_jour_a_venir_legere_pluie);
        else if(descriptionMain.getText().contains("couvert"))
            imgMeteoAujdhui.setImage(image_jour_a_venir_couvert);


       /* c0Matin.setText("T° " + windowZero[4]);
        c0Journee.setText("T° " + windowZero[5]);
        c0Soir.setText("T° " + windowZero[6]);*/

        //case1
        String date1 = listeDate.get(12);
        Object[] windowOne = weatherOfTheDays.dataWeather(1);
        //c1Date.setText(date1);
        c1Description.setText("" + windowOne[0]);
        if (c1Description.getText().contains("ciel dégagé"))
            imgMeteoAujdhui1.setImage(image_jour_a_venir_ciel_deg);
        else if(c1Description.getText().contains("partiellement nuageux"))
            imgMeteoAujdhui1.setImage(image_jour_a_venir_Partiellement_Nuageux);
        else if(c1Description.getText().contains("peu nuageux"))
            imgMeteoAujdhui1.setImage(image_jour_Avenir_Peu_Nuageux);
        else if(c1Description.getText().contains("nuageux"))
            imgMeteoAujdhui1.setImage(image_jour_a_venir_nuageux);
        else if (c1Description.getText().contains("légère pluie")|| descriptionMain.getText().contains("pluie modérée"))
            imgMeteoAujdhui1.setImage(image_centre_legere_pluie);
        else if(c1Description.getText().contains("couvert"))
            imgMeteoAujdhui1.setImage(image_jour_a_venir_couvert);

        /*c1Matin.setText("T° " + windowOne[4]);
        c1Journee.setText("T° " + windowOne[5]);
        c1Soir.setText("T° " + windowOne[6]);*/

        //case2
        String date2 = listeDate.get(20);
        Object[] windowTwo = weatherOfTheDays.dataWeather(2);
        //c2Date.setText(date2);
        c2Description.setText("" + windowTwo[0]);
        if (c2Description.getText().contains("ciel dégagé"))
            imgMeteoAujdhui2.setImage(image_jour_a_venir_ciel_deg);
        else if(c2Description.getText().contains("partiellement nuageux"))
            imgMeteoAujdhui2.setImage(image_jour_a_venir_Partiellement_Nuageux);
        else if(c2Description.getText().contains("peu nuageux"))
            imgMeteoAujdhui2.setImage(image_jour_Avenir_Peu_Nuageux);
        else if(c2Description.getText().contains("nuageux"))
            imgMeteoAujdhui2.setImage(image_jour_a_venir_nuageux);
        else if (c2Description.getText().contains("légère pluie")|| descriptionMain.getText().contains("pluie modérée"))
            imgMeteoAujdhui2.setImage(image_centre_legere_pluie);
        else if(c2Description.getText().contains("couvert"))
            imgMeteoAujdhui2.setImage(image_jour_a_venir_couvert);


        /*c2Matin.setText("T° " + windowTwo[4]);
        c2Journee.setText("T° " + windowTwo[5]);
        c2Soir.setText("T° " + windowTwo[6]);*/

        //case3
        String date3 = listeDate.get(28);
        Object[] windowThree = weatherOfTheDays.dataWeather(3);
        //c3Date.setText(date3);
        c3Description.setText(""+ windowThree[0]);
        System.out.println(c3Description.getText());
        if (c3Description.getText().contains("ciel dégagé"))
            imgMeteoAujdhui3.setImage(image_jour_a_venir_ciel_deg);
        else if(c3Description.getText().contains("partiellement nuageux"))
            imgMeteoAujdhui3.setImage(image_jour_a_venir_Partiellement_Nuageux);
        else if(c3Description.getText().contains("peu nuageux"))
            imgMeteoAujdhui3.setImage(image_jour_Avenir_Peu_Nuageux);
        else if(c3Description.getText().contains("nuageux"))
            imgMeteoAujdhui3.setImage(image_jour_a_venir_nuageux);
        else if (c3Description.getText().contains("légère pluie") || descriptionMain.getText().contains("pluie modérée"))
            imgMeteoAujdhui3.setImage(image_centre_legere_pluie);
        else if(c3Description.getText().contains("couvert"))
            imgMeteoAujdhui3.setImage(image_jour_a_venir_couvert);


        /*c3Matin.setText("T° " + windowThree[4]);
        c3Journee.setText("T° " + windowThree[5]);
        c3Soir.setText("T° " + windowThree[6]);*/



        //case4
        String date4 = listeDate.get(36);
        Object[] windowFour = weatherOfTheDays.dataWeather(4);
        //c4Date.setText(date4);
        c4Description.setText( windowFour[0] + ""  );
        if (c4Description.getText().contains("ciel dégagé"))
            imgMeteoAujdhui4.setImage(image_jour_a_venir_ciel_deg);
        else if(c4Description.getText().contains("partiellement nuageux"))
            imgMeteoAujdhui4.setImage(image_jour_a_venir_Partiellement_Nuageux);
        else if(c4Description.getText().contains("peu nuageux"))
            imgMeteoAujdhui4.setImage(image_jour_Avenir_Peu_Nuageux);
        else if(c4Description.getText().contains("nuageux"))
            imgMeteoAujdhui4.setImage(image_jour_a_venir_nuageux);
        else if (c4Description.getText().contains ("légère pluie")|| descriptionMain.getText().contains("pluie modérée"))
            imgMeteoAujdhui4.setImage(image_centre_legere_pluie);
        else if(c4Description.getText().contains( "couvert"))
            imgMeteoAujdhui4.setImage(image_jour_a_venir_couvert);




        /*c4Matin.setText("T° " + windowFour[2]);
        c4Journee.setText("T° " + windowFour[1]);
        c4Soir.setText("T° " + windowFour[3]);*/




        //utile à toutes les cases


        Boolean urlDoesExist = weatherdatafiveD.urlTest(ville);
        if (urlDoesExist) {
            labelTest.setText("");
            weatherdatafiveD.fromWebToJson(ville);
            //ArrayList<String> listeDate = weatherdatafiveD.returnDateList();
            rechercherjourUn();


            //WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(addFavField.getText());
            weatherOfTheDays.setLatAndLong();
            weatherOfTheDays.fromWebToJson();

            Object[] dataDayZero = weatherOfTheDays.dataWeather(0);

            DateClass dateClass = new DateClass(listeDate);
            ArrayList<String> listOfDate = dateClass.dateCalledByName();
            String jour1 = listOfDate.get(0);

            c0Date.setText("" + jour1);
            c0Description.setText("" + dataDayZero[0]);
            c0Matin.setText(dataDayZero[2] + "°");
            c0Journee.setText(dataDayZero[1] + "°");
            c0Soir.setText(dataDayZero[3] + "°");


            dateMainField.setText("" + jour1);
            descriptionMain.setText("" + dataDayZero[0]);
            TmaxMain.setText(dataDayZero[4] + "°");
            TminMain.setText(dataDayZero[5] + "°");
            vent.setText(dataDayZero[6] + "m/s");


            //jour02

            Object[] dataDayOne = weatherOfTheDays.dataWeather(1);
            String jour2 = listOfDate.get(1);
            c1Date.setText("" + jour2);
            c1Description.setText("" + dataDayOne[0]);
            c1Matin.setText(dataDayOne[2] + "°");
            c1Journee.setText(dataDayOne[1] + "°");
            c1Soir.setText(dataDayOne[3] + "°");

            //jour03

            Object[] dataDayTwo = weatherOfTheDays.dataWeather(2);
            String jour3 = listOfDate.get(2);
            c2Date.setText("" + jour3);
            c2Description.setText("" + dataDayTwo[0]);
            c2Matin.setText(dataDayTwo[2] + "°");
            c2Journee.setText(dataDayTwo[1] + "°");
            c2Soir.setText(dataDayTwo[3] + "°");


            //Jour04

            Object[] dataDayThree = weatherOfTheDays.dataWeather(3);
            String jour4 = listOfDate.get(3);
            c3Date.setText("" + jour4);
            c3Description.setText("" + dataDayThree[0]);
            c3Matin.setText(dataDayThree[2] + "°");
            c3Journee.setText(dataDayThree[1] + "°");
            c3Soir.setText(dataDayThree[3] + "°");


            //Jour05

            Object[] dataDayFour = weatherOfTheDays.dataWeather(4);
            String jour5 = listOfDate.get(4);
            c4Date.setText("" + jour5);
            c4Description.setText("" + dataDayFour[0]);
            c4Matin.setText(dataDayFour[2] + "°");
            c4Journee.setText(dataDayFour[1] + "°");
            c4Soir.setText(dataDayFour[3] + "°");


            try {
                rechercherjourUn();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        } else {
            labelTest.setText("La ville n'éxiste pas ");
        }
    }


    @FXML
    public void rechercherjour2() throws IOException, IOException, ParseException {
        String ville = addFavField.getText();
        ArrayList<String> list = new ArrayList<String>();
        WeatherDataFiveD weatherDataFiveD = new WeatherDataFiveD(ville);
        weatherDataFiveD.fromWebToJson(ville);
        list = weatherDataFiveD.returnDateList();
        DateClass date = new DateClass(list);
        date.arrayInitialization();
        date.getDaysArrayFilled();


        ArrayList<String> list2 = new ArrayList<>();
        list2 = date.getSecondDayDates();

        // pour l'heure de la température

        DateClass dateclass1 = new DateClass(list);
        dateclass1.arrayInitialization();
        dateclass1.getDaysArrayFilled();

        ArrayList<String> list2Temp = new ArrayList<>();
        list2Temp = dateclass1.getSecondDayHour();


        Object[] obejet1 = new Object[7];
        Object[] obejet2 = new Object[7];
        Object[] obejet3 = new Object[7];
        Object[] obejet4 = new Object[7];
        Object[] obejet5 = new Object[7];
        Object[] obejet6 = new Object[7];
        Object[] obejet7 = new Object[7];
        Object[] obejet8 = new Object[7];


        obejet1 = weatherDataFiveD.dataWeather(list2.get(0));
        obejet2 = weatherDataFiveD.dataWeather(list2.get(1));
        obejet3 = weatherDataFiveD.dataWeather(list2.get(2));
        obejet4 = weatherDataFiveD.dataWeather(list2.get(3));
        obejet5 = weatherDataFiveD.dataWeather(list2.get(4));
        obejet6 = weatherDataFiveD.dataWeather(list2.get(5));
        obejet7 = weatherDataFiveD.dataWeather(list2.get(6));
        obejet8 = weatherDataFiveD.dataWeather(list2.get(7));


        heure01Temp.setText(obejet1[1] + "°");
        heure02Temp.setText(obejet2[1] + "°");
        heure03Temp.setText(obejet3[1] + "°");
        heure04Temp.setText(obejet4[1] + "°");
        heure05Temp.setText(obejet5[1] + "°");
        heure06Temp.setText(obejet6[1] + "°");
        heure07Temp.setText(obejet7[1] + "°");
        heure08Temp.setText(obejet8[1] + "°");

        heure01.setText("" + list2Temp.get(0));
        heure02.setText("" + list2Temp.get(1));
        heure03.setText("" + list2Temp.get(2));
        heure04.setText("" + list2Temp.get(3));
        heure05.setText("" + list2Temp.get(4));
        heure06.setText("" + list2Temp.get(5));
        heure07.setText("" + list2Temp.get(6));
        heure08.setText("" + list2Temp.get(7));

        //heure01.setText(list2Temp.get(0));

        //affichage dans le main
        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(ville);

        weatherdatafiveD.fromWebToJson(ville);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();


        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(ville);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();


        //Main

        Object[] dataDayZero = weatherOfTheDays.dataWeather(1);

        DateClass dateClass = new DateClass(listeDate);
        ArrayList<String> listOfDate = dateClass.dateCalledByName();
        String jour2 = listOfDate.get(1);


        dateMainField.setText("" + jour2);
        descriptionMain.setText("" + dataDayZero[0]);
        TmaxMain.setText(dataDayZero[4] + "°");
        TminMain.setText(dataDayZero[5] + "°");
        vent.setText(dataDayZero[6] + "m/s");


    }

    @FXML
    public void rechercherjour3() throws IOException, IOException, ParseException {
        String ville = addFavField.getText();
        ArrayList<String> list = new ArrayList<String>();
        WeatherDataFiveD weatherDataFiveD = new WeatherDataFiveD(ville);
        weatherDataFiveD.fromWebToJson(ville);
        list = weatherDataFiveD.returnDateList();
        DateClass date = new DateClass(list);
        date.arrayInitialization();
        date.getDaysArrayFilled();


        ArrayList<String> list3 = new ArrayList<>();
        list3 = date.getThirdDayDates();

        //affichage des heures de temp
        DateClass dateclass1 = new DateClass(list);
        dateclass1.arrayInitialization();
        dateclass1.getDaysArrayFilled();

        ArrayList<String> list3Temp = new ArrayList<>();
        list3Temp = dateclass1.getThirdDayHour();


        Object[] obejet1 = new Object[7];
        Object[] obejet2 = new Object[7];
        Object[] obejet3 = new Object[7];
        Object[] obejet4 = new Object[7];
        Object[] obejet5 = new Object[7];
        Object[] obejet6 = new Object[7];
        Object[] obejet7 = new Object[7];
        Object[] obejet8 = new Object[7];


        obejet1 = weatherDataFiveD.dataWeather(list3.get(0));
        obejet2 = weatherDataFiveD.dataWeather(list3.get(1));
        obejet3 = weatherDataFiveD.dataWeather(list3.get(2));
        obejet4 = weatherDataFiveD.dataWeather(list3.get(3));
        obejet5 = weatherDataFiveD.dataWeather(list3.get(4));
        obejet6 = weatherDataFiveD.dataWeather(list3.get(5));
        obejet7 = weatherDataFiveD.dataWeather(list3.get(6));
        obejet8 = weatherDataFiveD.dataWeather(list3.get(7));


        heure01Temp.setText(obejet1[1] + "°");
        heure02Temp.setText(obejet2[1] + "°");
        heure03Temp.setText(obejet3[1] + "°");
        heure04Temp.setText(obejet4[1] + "°");
        heure05Temp.setText(obejet5[1] + "°");
        heure06Temp.setText(obejet6[1] + "°");
        heure07Temp.setText(obejet7[1] + "°");
        heure08Temp.setText(obejet8[1] + "°");

        heure01.setText("" + list3Temp.get(0));
        heure02.setText("" + list3Temp.get(1));
        heure03.setText("" + list3Temp.get(2));
        heure04.setText("" + list3Temp.get(3));
        heure05.setText("" + list3Temp.get(4));
        heure06.setText("" + list3Temp.get(5));
        heure07.setText("" + list3Temp.get(6));
        heure08.setText("" + list3Temp.get(7));

        //affichage dans le main
        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(ville);

        weatherdatafiveD.fromWebToJson(ville);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();


        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(ville);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();


        //Main

        Object[] dataDayZero = weatherOfTheDays.dataWeather(2);

        DateClass dateClass = new DateClass(listeDate);
        ArrayList<String> listOfDate = dateClass.dateCalledByName();
        String jour3 = listOfDate.get(2);


        dateMainField.setText("" + jour3);
        descriptionMain.setText("" + dataDayZero[0]);
        TmaxMain.setText(dataDayZero[4] + "°");
        TminMain.setText(dataDayZero[5] + "°");
        vent.setText(dataDayZero[6] + "m/s");


    }

    @FXML
    public void rechercherjour4() throws IOException, IOException, ParseException {
        String ville = addFavField.getText();
        ArrayList<String> list=new ArrayList<String>();
        WeatherDataFiveD weatherDataFiveD = new WeatherDataFiveD(ville);
        weatherDataFiveD.fromWebToJson(ville);
        list=weatherDataFiveD.returnDateList();
        DateClass date= new DateClass(list);
        date.arrayInitialization();
        date.getDaysArrayFilled();


        ArrayList<String> list4 = new ArrayList<>();
        list4= date.getFourthDayDates();
        //affichage des heures des temps pour le jr3
        DateClass dateclass1= new DateClass(list);
        dateclass1.arrayInitialization();
        dateclass1.getDaysArrayFilled();

        ArrayList<String> list4Temp = new ArrayList<>();
        list4Temp = dateclass1.getFourthDayHour();

        Object[] obejet1= new Object[7];
        Object[] obejet2= new Object[7];
        Object[] obejet3= new Object[7];
        Object[] obejet4= new Object[7];
        Object[] obejet5= new Object[7];
        Object[] obejet6= new Object[7];
        Object[] obejet7= new Object[7];
        Object[] obejet8= new Object[7];


        obejet1= weatherDataFiveD.dataWeather(list4.get(0));
        obejet2= weatherDataFiveD.dataWeather(list4.get(1));
        obejet3= weatherDataFiveD.dataWeather(list4.get(2));
        obejet4= weatherDataFiveD.dataWeather(list4.get(3));
        obejet5= weatherDataFiveD.dataWeather(list4.get(4));
        obejet6= weatherDataFiveD.dataWeather(list4.get(5));
        obejet7= weatherDataFiveD.dataWeather(list4.get(6));
        obejet8=weatherDataFiveD.dataWeather(list4.get(7));

        heure01Temp.setText(obejet1[1]+"°");
        heure02Temp.setText(obejet2[1]+"°");
        heure03Temp.setText(obejet3[1]+"°");
        heure04Temp.setText(obejet4[1]+"°");
        heure05Temp.setText(obejet5[1]+"°");
        heure06Temp.setText(obejet6[1]+"°");
        heure07Temp.setText(obejet7[1]+"°");
        heure08Temp.setText(obejet8[1]+"°");

        heure01.setText(""+list4Temp.get(0));
        heure02.setText(""+list4Temp.get(1));
        heure03.setText(""+list4Temp.get(2));
        heure04.setText(""+list4Temp.get(3));
        heure05.setText(""+list4Temp.get(4));
        heure06.setText(""+list4Temp.get(5));
        heure07.setText(""+list4Temp.get(6));
        heure08.setText(""+list4Temp.get(7));

        //affichage dans le main

        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(ville);

        weatherdatafiveD.fromWebToJson(ville);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();


        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(ville);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();



        //Main

        Object[] dataDayZero = weatherOfTheDays.dataWeather(3);

        DateClass dateClass = new DateClass(listeDate);
        ArrayList<String> listOfDate = dateClass.dateCalledByName();
        String jour4 = listOfDate.get(3);


        dateMainField.setText(""+jour4);
        descriptionMain.setText(""+dataDayZero[0]);
        TmaxMain.setText(dataDayZero[4]+"°");
        TminMain.setText(dataDayZero[5]+"°");
        vent.setText(dataDayZero[6]+"m/s");


    }

    @FXML
    public void rechercherjour5() throws IOException, IOException, ParseException {
        String ville = addFavField.getText();
        ArrayList<String> list = new ArrayList<String>();
        WeatherDataFiveD weatherDataFiveD = new WeatherDataFiveD(ville);
        weatherDataFiveD.fromWebToJson(ville);
        list = weatherDataFiveD.returnDateList();
        DateClass date = new DateClass(list);
        date.arrayInitialization();
        date.getDaysArrayFilled();

        ArrayList<String> list5 = new ArrayList<>();
        list5 = date.getFifthDayDates();
        //affichage des heure
        DateClass dateclass1 = new DateClass(list);
        dateclass1.arrayInitialization();
        dateclass1.getDaysArrayFilled();

        ArrayList<String> list5Temp = new ArrayList<>();
        list5Temp = dateclass1.getFifthDayHour();

        Object[] obejet1 = new Object[7];
        Object[] obejet2 = new Object[7];
        Object[] obejet3 = new Object[7];
        Object[] obejet4 = new Object[7];
        Object[] obejet5 = new Object[7];
        Object[] obejet6 = new Object[7];
        Object[] obejet7 = new Object[7];
        Object[] obejet8 = new Object[7];


        obejet1 = weatherDataFiveD.dataWeather(list5.get(0));
        obejet2 = weatherDataFiveD.dataWeather(list5.get(1));
        obejet3 = weatherDataFiveD.dataWeather(list5.get(2));
        obejet4 = weatherDataFiveD.dataWeather(list5.get(3));
        obejet5 = weatherDataFiveD.dataWeather(list5.get(4));
        obejet6 = weatherDataFiveD.dataWeather(list5.get(5));
        obejet7 = weatherDataFiveD.dataWeather(list5.get(6));
        obejet8 = weatherDataFiveD.dataWeather(list5.get(7));

        heure01Temp.setText(obejet1[1] + "°");
        heure02Temp.setText(obejet2[1] + "°");
        heure03Temp.setText(obejet3[1] + "°");
        heure04Temp.setText(obejet4[1] + "°");
        heure05Temp.setText(obejet5[1] + "°");
        heure06Temp.setText(obejet6[1] + "°");
        heure07Temp.setText(obejet7[1] + "°");
        heure08Temp.setText(obejet8[1] + "°");

        heure01.setText("" + list5Temp.get(0));
        heure02.setText("" + list5Temp.get(1));
        heure03.setText("" + list5Temp.get(2));
        heure04.setText("" + list5Temp.get(3));
        heure05.setText("" + list5Temp.get(4));
        heure06.setText("" + list5Temp.get(5));
        heure07.setText("" + list5Temp.get(6));
        heure08.setText("" + list5Temp.get(7));
        //affichage dans le main
        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(ville);

        weatherdatafiveD.fromWebToJson(ville);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();


        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(ville);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();


        //Main

        Object[] dataDayZero = weatherOfTheDays.dataWeather(4);

        DateClass dateClass = new DateClass(listeDate);
        ArrayList<String> listOfDate = dateClass.dateCalledByName();
        String jour5 = listOfDate.get(4);


        dateMainField.setText("" + jour5);
        descriptionMain.setText("" + dataDayZero[0]);
        TmaxMain.setText(dataDayZero[4] + "°");
        TminMain.setText(dataDayZero[5] + "°");
        vent.setText(dataDayZero[6] + "m/s");


    }

    @FXML
    public void rechercherjourUn() throws IOException, IOException, ParseException {
        String ville = addFavField.getText();
        ArrayList<String> list = new ArrayList<String>();
        WeatherDataFiveD weatherDataFiveD = new WeatherDataFiveD(ville);
        weatherDataFiveD.fromWebToJson(ville);
        list = (ArrayList<String>) weatherDataFiveD.returnDateList();
        DateClass date = new DateClass(list);
        date.arrayInitialization();
        date.getDaysArrayFilled();
        ArrayList<String> list1 = new ArrayList<>();
        list1 = date.getFirstDayDates();
        ArrayList<String> list2 = new ArrayList<>();
        list2 = date.getSecondDayDates();

//      affichage des heure pour les temp
        DateClass dateclass1 = new DateClass(list);
        dateclass1.arrayInitialization();
        dateclass1.getDaysArrayFilled();
        //liste1Tem1 == heure
        ArrayList<String> list1Temp = new ArrayList<>();
        list1Temp = dateclass1.getFirstDayHour();
        ArrayList<String> list2Temp = new ArrayList<>();
        list2Temp = date.getSecondDayHour();


        Object[] objet1 = new Object[7];
        Object[] objet2 = new Object[7];
        Object[] objet3 = new Object[7];
        Object[] objet4 = new Object[7];
        Object[] objet5 = new Object[7];
        Object[] objet6 = new Object[7];
        Object[] objet7 = new Object[7];
        Object[] objet8 = new Object[7];


        if (list1.size() == 1) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list2.get(0));
            objet3 = weatherDataFiveD.dataWeather(list2.get(1));
            objet4 = weatherDataFiveD.dataWeather(list2.get(2));
            objet5 = weatherDataFiveD.dataWeather(list2.get(3));
            objet6 = weatherDataFiveD.dataWeather(list2.get(4));
            objet7 = weatherDataFiveD.dataWeather(list2.get(5));
            objet8 = weatherDataFiveD.dataWeather(list2.get(6));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");


            heure01.setText(list1Temp.get(0));
            heure02.setText(list2Temp.get(1));
            heure03.setText(list2Temp.get(2));
            heure04.setText(list2Temp.get(3));
            heure05.setText(list2Temp.get(4));
            heure06.setText(list2Temp.get(5));
            heure07.setText(list2Temp.get(6));
            heure08.setText(list2Temp.get(7));

        } else if (list1.size() == 2) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list2.get(0));
            objet4 = weatherDataFiveD.dataWeather(list2.get(1));
            objet5 = weatherDataFiveD.dataWeather(list2.get(2));
            objet6 = weatherDataFiveD.dataWeather(list2.get(3));
            objet7 = weatherDataFiveD.dataWeather(list2.get(4));
            objet8 = weatherDataFiveD.dataWeather(list2.get(5));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");
            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list2Temp.get(2));
            heure04.setText(list2Temp.get(3));
            heure05.setText(list2Temp.get(4));
            heure06.setText(list2Temp.get(5));
            heure07.setText(list2Temp.get(6));
            heure08.setText(list2Temp.get(7));
        } else if (list1.size() == 3) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list1.get(2));
            objet4 = weatherDataFiveD.dataWeather(list2.get(0));
            objet5 = weatherDataFiveD.dataWeather(list2.get(1));
            objet6 = weatherDataFiveD.dataWeather(list2.get(2));
            objet7 = weatherDataFiveD.dataWeather(list2.get(3));
            objet8 = weatherDataFiveD.dataWeather(list2.get(4));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");

            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list1Temp.get(2));
            heure04.setText(list2Temp.get(1));
            heure05.setText(list2Temp.get(2));
            heure06.setText(list2Temp.get(3));
            heure07.setText(list2Temp.get(4));
            heure08.setText(list2Temp.get(5));
        } else if (list1.size() == 4) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list1.get(2));
            objet4 = weatherDataFiveD.dataWeather(list1.get(3));
            objet5 = weatherDataFiveD.dataWeather(list2.get(0));
            objet6 = weatherDataFiveD.dataWeather(list2.get(1));
            objet7 = weatherDataFiveD.dataWeather(list2.get(2));
            objet8 = weatherDataFiveD.dataWeather(list2.get(3));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");
            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list1Temp.get(2));
            heure04.setText(list1Temp.get(3));
            heure05.setText(list2Temp.get(0));
            heure06.setText(list2Temp.get(1));
            heure07.setText(list2Temp.get(3));
            heure08.setText(list2Temp.get(4));
        } else if (list1.size() == 5) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list1.get(2));
            objet4 = weatherDataFiveD.dataWeather(list1.get(3));
            objet5 = weatherDataFiveD.dataWeather(list1.get(4));
            objet6 = weatherDataFiveD.dataWeather(list2.get(0));
            objet7 = weatherDataFiveD.dataWeather(list2.get(1));
            objet8 = weatherDataFiveD.dataWeather(list2.get(2));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");

            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list1Temp.get(2));
            heure04.setText(list1Temp.get(3));
            heure05.setText(list1Temp.get(4));
            heure06.setText(list2Temp.get(0));
            heure07.setText(list2Temp.get(1));
            heure08.setText(list2Temp.get(2));
        } else if (list1.size() == 6) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list1.get(2));
            objet4 = weatherDataFiveD.dataWeather(list1.get(3));
            objet5 = weatherDataFiveD.dataWeather(list1.get(4));
            objet6 = weatherDataFiveD.dataWeather(list1.get(5));
            objet7 = weatherDataFiveD.dataWeather(list2.get(0));
            objet8 = weatherDataFiveD.dataWeather(list2.get(1));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");
            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list1Temp.get(2));
            heure04.setText(list1Temp.get(3));
            heure05.setText(list1Temp.get(4));
            heure06.setText(list1Temp.get(5));
            heure07.setText(list2Temp.get(0));
            heure08.setText(list2Temp.get(1));
        } else if (list1.size() == 7) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list1.get(2));
            objet4 = weatherDataFiveD.dataWeather(list1.get(3));
            objet5 = weatherDataFiveD.dataWeather(list1.get(4));
            objet6 = weatherDataFiveD.dataWeather(list1.get(5));
            objet7 = weatherDataFiveD.dataWeather(list1.get(6));
            objet8 = weatherDataFiveD.dataWeather(list2.get(0));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");

            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list1Temp.get(2));
            heure04.setText(list1Temp.get(3));
            heure05.setText(list1Temp.get(4));
            heure06.setText(list1Temp.get(5));
            heure07.setText(list1Temp.get(6));
            heure08.setText(list2Temp.get(7));


        } else if (list1.size() == 8) {
            objet1 = weatherDataFiveD.dataWeather(list1.get(0));
            objet2 = weatherDataFiveD.dataWeather(list1.get(1));
            objet3 = weatherDataFiveD.dataWeather(list1.get(2));
            objet4 = weatherDataFiveD.dataWeather(list1.get(3));
            objet5 = weatherDataFiveD.dataWeather(list1.get(4));
            objet6 = weatherDataFiveD.dataWeather(list1.get(5));
            objet7 = weatherDataFiveD.dataWeather(list1.get(6));
            objet8 = weatherDataFiveD.dataWeather(list1.get(7));
            heure01Temp.setText(objet1[1] + "°");
            heure02Temp.setText(objet2[1] + "°");
            heure03Temp.setText(objet3[1] + "°");
            heure04Temp.setText(objet4[1] + "°");
            heure05Temp.setText(objet5[1] + "°");
            heure06Temp.setText(objet6[1] + "°");
            heure07Temp.setText(objet7[1] + "°");
            heure08Temp.setText(objet8[1] + "°");
            heure01.setText(list1Temp.get(0));
            heure02.setText(list1Temp.get(1));
            heure03.setText(list1Temp.get(2));
            heure04.setText(list1Temp.get(3));
            heure05.setText(list1Temp.get(4));
            heure06.setText(list1Temp.get(5));
            heure07.setText(list1Temp.get(6));
            heure08.setText(list1Temp.get(7));

        } else {
            rechercherjour2();
        }

        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(ville);

        weatherdatafiveD.fromWebToJson(ville);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();


        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(ville);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();


        //Main

        Object[] dataDayZero = weatherOfTheDays.dataWeather(0);

        DateClass dateClass = new DateClass(listeDate);
        ArrayList<String> listOfDate = dateClass.dateCalledByName();
        String jour1 = listOfDate.get(0);


        dateMainField.setText("" + jour1);
        descriptionMain.setText("" + dataDayZero[0]);
        TmaxMain.setText(dataDayZero[4] + "°");
        TminMain.setText(dataDayZero[5] + "°");
        vent.setText(dataDayZero[6] + "m/s");


    }


    public void displaySelected() throws IOException, ParseException {

        String villeList = (String) favList.getSelectionModel().getSelectedItem();
        addFavField.setText(villeList);
        String ville = addFavField.getText();
        rechercherjourUn();


        //utile à toutes les cases

        WeatherDataFiveD weatherdatafiveD = new WeatherDataFiveD(villeList);

        weatherdatafiveD.fromWebToJson(villeList);
        ArrayList<String> listeDate = weatherdatafiveD.returnDateList();


        WeatherOfTheDays weatherOfTheDays = new WeatherOfTheDays(villeList);
        weatherOfTheDays.setLatAndLong();
        weatherOfTheDays.fromWebToJson();
        Object[] data = weatherOfTheDays.dataWeather(1);


        //Main

        Object[] dataDayZero = weatherOfTheDays.dataWeather(0);

        DateClass dateClass = new DateClass(listeDate);
        ArrayList<String> listOfDate = dateClass.dateCalledByName();
        String jour1 = listOfDate.get(0);

        c0Date.setText("" + jour1);
        c0Description.setText("" + dataDayZero[0]);
        c0Matin.setText(dataDayZero[2] + "°");
        c0Journee.setText(dataDayZero[1] + "°");
        c0Soir.setText(dataDayZero[3] + "°");


        dateMainField.setText("" + jour1);
        descriptionMain.setText("" + dataDayZero[0]);
        TmaxMain.setText(dataDayZero[4] + "°");
        TminMain.setText(dataDayZero[5] + "°");
        vent.setText(dataDayZero[6] + "m/s");


        //jour02

        Object[] dataDayOne = weatherOfTheDays.dataWeather(1);
        String jour2 = listOfDate.get(1);
        c1Date.setText("" + jour2);
        c1Description.setText("" + dataDayOne[0]);
        c1Matin.setText(dataDayOne[2] + "°");
        c1Journee.setText(dataDayOne[1] + "°");
        c1Soir.setText(dataDayOne[3] + "°");

        //jour03

        Object[] dataDayTwo = weatherOfTheDays.dataWeather(2);
        String jour3 = listOfDate.get(2);
        c2Date.setText("" + jour3);
        c2Description.setText("" + dataDayTwo[0]);
        c2Matin.setText(dataDayTwo[2] + "°");
        c2Journee.setText(dataDayTwo[1] + "°");
        c2Soir.setText(dataDayTwo[3] + "°");


        //Jour04

        Object[] dataDayThree = weatherOfTheDays.dataWeather(3);
        String jour4 = listOfDate.get(3);
        c3Date.setText("" + jour4);
        c3Description.setText("" + dataDayThree[0]);
        c3Matin.setText(dataDayThree[2] + "°");
        c3Journee.setText(dataDayThree[1] + "°");
        c3Soir.setText(dataDayThree[3] + "°");


        //Jour05

        Object[] dataDayFour = weatherOfTheDays.dataWeather(4);
        String jour5 = listOfDate.get(4);
        c4Date.setText("" + jour5);
        c4Description.setText("" + dataDayFour[0]);
        c4Matin.setText(dataDayFour[2] + "°");
        c4Journee.setText(dataDayFour[1] + "°");
        c4Soir.setText(dataDayFour[3] + "°");

    }


    @FXML
    public void addCityButton() throws IOException, ClassNotFoundException {

        FavCityList favCityList = new FavCityList();
        String ville = addFavField.getText();

        WeatherDataFiveD weatherDataFiveD = new WeatherDataFiveD(ville);


        boolean doesCityExist = favCityList.cityDoestExist(ville);
        boolean doesURLExist = weatherDataFiveD.urlTest(ville);

        if (doesURLExist && !doesCityExist) {
            labelTest.setText("");
            favCityList.addCity(ville);
            favList.getItems().add(ville);

        } else {
            labelTest.setText("La ville n'est pas répertoriée dans nos bases de données ou est déjà dans vos Favoris.");

        }

    }

    @FXML
    public ArrayList<String> getList() throws IOException, ClassNotFoundException {
        FavCityList favCityList = new FavCityList();
        return favCityList.extractListFromFile();

    }

    @FXML
    public void deleteCityButton(ActionEvent event) throws IOException, ClassNotFoundException {

        FavCityList favCityList = new FavCityList();

        String cityToSearch = (String) favList.getSelectionModel().getSelectedItem();

        String ville = addFavField.getText().toLowerCase();
        boolean doesCityExist = favCityList.cityDoestExist(cityToSearch);


        if (doesCityExist) {
            favCityList.deleteCity(cityToSearch);
            favList.getItems().remove(cityToSearch);
        }

    }

    public void createList() throws IOException {
        ArrayList<String> listCreation = new ArrayList<String>();

        listCreation.add("Moscou");
        listCreation.add("Vallauris");

        FileOutputStream wFavoriteCityFile = new FileOutputStream("favoriteCityFile");
        ObjectOutputStream wFavoriteCityFileObject = new ObjectOutputStream(wFavoriteCityFile);
        wFavoriteCityFileObject.writeObject(listCreation);

        favList.getItems().addAll(listCreation);


    }

    public void displayList() throws IOException, ClassNotFoundException {

        ArrayList<String> listCreation = new ArrayList<String>();
        FavCityList favCityList = new FavCityList();
        listCreation = favCityList.extractListFromFile();
        String motsansmajuscule = new String();
        String motavecmajuscule = new String();
        for (int i = 0; i < listCreation.size(); i++) {
            motsansmajuscule = listCreation.get(i);
            motavecmajuscule = motsansmajuscule.substring(0, 1).toUpperCase() + motsansmajuscule.substring(1).toLowerCase();

            listCreation.set(i, motavecmajuscule);
        }
        favList.getItems().addAll(listCreation);

    }

    //    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        try {
            displayList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}