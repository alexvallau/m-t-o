package app.appmeteo;

import org.joda.time.DateTime;


import java.text.DateFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateClass {

    //private Date dateInitiale;
    private DateTime dateInitiale;
    private DateTime dateFinale;
    private ArrayList<String> listOfStringDate;
    private List<DateTime> dateTimeList;

    private ArrayList<DateTime> listOfDTDate;


    private ArrayList<String> jourUn = new ArrayList<String>();
    private ArrayList<String> jourDeux;
    private ArrayList<String> jourTrois;
    private ArrayList<String> jourQuatre;
    private ArrayList<String> jourCinq;
    private ArrayList<String> jourSix;

    private ArrayList<ArrayList<String>> listOfList = new ArrayList<ArrayList<String>>();


    public DateClass(ArrayList<String> listOfStringDate) {
        this.listOfStringDate = listOfStringDate;

    }

    public void arrayInitialization() {
        listOfList.add(jourUn);
        listOfList.add(jourDeux);
        listOfList.add(jourTrois);
        listOfList.add(jourQuatre);
        listOfList.add(jourCinq);
        listOfList.add(jourSix);
    }

    public void getDaysArrayFilled() throws ParseException {

        int dateBeforeInt;
        int dateAfterInt;
        int j = 0;
        Calendar calendar = Calendar.getInstance();


        //on convertit d'abord en date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date dateBefore = new Date();
        Date dateAfter = new Date();


        //variable d'un des champs de la liste string
        String dateBeforeString = new String();
        String dateAfterString = new String();

        //ArrayList a mettre dans notre Liste d'arrayList

        ArrayList<String> jourX = new ArrayList<String>();

        for (int i = 1; i < this.listOfStringDate.size(); i++) {


            dateBeforeString = listOfStringDate.get(i - 1);
            dateAfterString = listOfStringDate.get(i);

            dateBefore = formatter.parse(dateAfterString);
            calendar.setTime(dateBefore);
            dateBeforeInt = calendar.get(Calendar.DATE);

            dateAfter = formatter.parse(dateBeforeString);
            calendar.setTime(dateAfter);
            dateAfterInt = calendar.get(Calendar.DATE);

            //Il prend la date sous forme 2022-03-02 21:00:00
            //                              2022-03-03 00:00:00

            if (dateBeforeInt == dateAfterInt) {
                //gérer le premier jour car notre boucle commence a 1
                if (i == 1) {

                    jourX.add(listOfStringDate.get(0));
                    jourX.add(dateAfterString);
                }
                //
                else if (i == 39) {
                    jourX.add(listOfStringDate.get(39));

                } else {
                    jourX.add(dateAfterString);

                }
                listOfList.set(j, jourX);
            } else {

                listOfList.set(j, new ArrayList(jourX));
                jourX.clear();

                j++;

                jourX.add(dateAfterString);
                listOfList.set(j, jourX);
            }

        }
    }

    public ArrayList<String> getFirstDayDates() {
        return listOfList.get(0);
    }

    public ArrayList<String> getSecondDayDates() {
        return listOfList.get(1);
    }

    public ArrayList<String> getThirdDayDates() {
        return listOfList.get(2);
    }


    public ArrayList<String> getFourthDayDates() {
        return listOfList.get(3);
    }

    public ArrayList<String> getFifthDayDates() {
        return listOfList.get(4);
    }

    public ArrayList<String> getSixthDayDates() {
        return listOfList.get(5);
    }

    public ArrayList<String> transformdateIntoHour(ArrayList<String> listOfDate) throws ParseException {
        String oldFormat = "yyyy-mm-dd hh:mm:ss";
        String newFormat = "HH:mm";
        ArrayList<String> dateConverted = new ArrayList<String>();
        SimpleDateFormat formatterOldFormat = new SimpleDateFormat(oldFormat);
        SimpleDateFormat formatterNewFormat = new SimpleDateFormat(newFormat);
        String dateString = new String();
        for (int i = 0; i < listOfDate.size(); i++) {
            Date d = formatterOldFormat.parse(listOfDate.get(i));
            dateString = formatterNewFormat.format(d);
            dateConverted.add(dateString);
        }
        return dateConverted;
    }

    public ArrayList<String> getFirstDayHour() throws ParseException {
        return transformdateIntoHour((listOfList.get(0)));
    }

    public ArrayList<String> getSecondDayHour() throws ParseException {
        return transformdateIntoHour((listOfList.get(1)));
    }

    public ArrayList<String> getThirdDayHour() throws ParseException {
        return transformdateIntoHour((listOfList.get(2)));
    }

    public ArrayList<String> getFourthDayHour() throws ParseException {
        return transformdateIntoHour((listOfList.get(3)));
    }

    public ArrayList<String> getFifthDayHour() throws ParseException {
        return transformdateIntoHour((listOfList.get(4)));
    }

    public ArrayList<String> getSixthDayHour() throws ParseException {
        return transformdateIntoHour((listOfList.get(5)));
    }


    public ArrayList<String> dateCalledByName() {

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, d MMMM", Locale.FRANCE);
        ArrayList<String> listOfDates = new ArrayList<String>();

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 5; i++) {
            calendar.setTime(date);
            calendar.add(Calendar.DATE, i);
            String dateString = formatter.format(calendar.getTime());
            listOfDates.add(dateString);
        }

        return listOfDates;

    }


}