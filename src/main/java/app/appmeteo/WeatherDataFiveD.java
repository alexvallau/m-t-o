package app.appmeteo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class WeatherDataFiveD {


    private String cityName;
    private ArrayList<String> dateTXT = new ArrayList<String>();
    private ArrayList<String> dateCutTXT = new ArrayList<String>();
    private JSONObject jsonObjectArray;
    private HashMap<String, JSONObject> hashMapOfJson = new HashMap<String, JSONObject>();


    public WeatherDataFiveD(String cityName) {
        this.cityName = cityName;

    }
    public boolean urlTest(String ville) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" +ville+ "&appid=f5ed2e80c2cdf7b97a863c0777a52a8d&lang=fr");

            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL("https://api.openweathermap.org/data/2.5/forecast?q=" +ville+ "&appid=f5ed2e80c2cdf7b97a863c0777a52a8d&lang=fr").openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void fromWebToJson(String cityName) throws IOException {
        String input;
        StringBuilder textePageApi = new StringBuilder();
        URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=f5ed2e80c2cdf7b97a863c0777a52a8d&lang=fr");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((input = in.readLine()) != null) {
            //readLine input prend la valeur de in qui est lu de ligne en  ligne
            textePageApi.append(input);
        }
        in.close();
        JSONObject jsonObject = new JSONObject(textePageApi.toString());
        JSONArray list = (JSONArray) jsonObject.get("list");
        String date = new String();
        String dateCutted = new String();
        for (int i = 0; i < 40; i++) {


            JSONObject listElement = (JSONObject) list.get(i);


            date = listElement.getString("dt_txt");
            //dateCutted = date.substring(0,10);

            // dateTXT.add(dateCutted);

            dateTXT.add(date);
            hashMapOfJson.put(date, listElement);


        }


        //JSONArray weather = (JSONArray) jsonObject.get("weather");
        // le tableau récupéré ci dessous ne contient qu'un élément "weather", on peut donc le décomposer en objet et le traiter comme tel
        // jsonObjectArray = (JSONObject) weather.get(0);
    }

    public Object[] dataWeather(String Date) {

        JSONObject dataWeather = hashMapOfJson.get(Date);
        double villeTemp = dataWeather.getJSONObject("main").getInt("temp") - 273.15;
        int villeTempCasted = (int) villeTemp;

        double villeTempRessentie = dataWeather.getJSONObject("main").getInt("feels_like") - 273.15;
        int villeTempRessCasted = (int) villeTempRessentie;

        double villeTempMin = dataWeather.getJSONObject("main").getInt("temp_min") - 273.15;
        int villeTempMinCasted = (int) villeTempRessentie;

        double villeTempMax = dataWeather.getJSONObject("main").getInt("temp_max") - 273.15;
        int villeTempMaxCasted = (int) villeTempMax;


        JSONArray weather = (JSONArray) dataWeather.get("weather");
        JSONObject recoverWeather = (JSONObject) weather.get(0);
        String detailTemps = recoverWeather.getString("description");

        double wind = dataWeather.getJSONObject("wind").getDouble("speed");
        int windCasted = (int) wind;


        Object[] valeurAStocker = new Object[7];
        //valeurAStocker[0] =
        valeurAStocker[0] = new String(Date);
        valeurAStocker[1] = Integer.valueOf(villeTempCasted);
        valeurAStocker[2] = Integer.valueOf(villeTempRessCasted);
        valeurAStocker[3] = Integer.valueOf(villeTempMaxCasted);
        valeurAStocker[4] = Integer.valueOf(villeTempMinCasted);
        valeurAStocker[5] = new String(detailTemps);
        valeurAStocker[6] = Integer.valueOf(windCasted);

        return valeurAStocker;

    }




    public ArrayList<String> returnDateList() {


        String word = new String();
        String word2 = new String();
        for (int i = 0; i < dateTXT.size(); i++) {

            word = dateTXT.get(i);

           /* for (int j = 0; j< word.length(); j++){
                word2+=toCut.charAt(i);
                dateCutTXT.add(word2);
            }*/

            dateCutTXT.add(word);
        }

        return dateCutTXT;
    }

}
