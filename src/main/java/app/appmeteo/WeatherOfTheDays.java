package app.appmeteo;

import griffon.core.ApplicationClassLoader;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.lang.*;




public class WeatherOfTheDays {

    private String cityName;
    private float longitude;
    private float latitude;
    private HashMap<Integer, JSONObject> hashMapOfJson = new HashMap<Integer, JSONObject>();

    public WeatherOfTheDays(String cityName){
        this.cityName= cityName;

    }
    public void setLatAndLong(){
        String input;
        StringBuilder textePageApi = new StringBuilder();
        URL url = null;
        try {
            url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+this.cityName+"&appid=c20d187883a70f683816fb55e5027b90");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((input = in.readLine()) != null) {
                //readLine input prend la valeur de in qui est lu de ligne en  ligne
                textePageApi.append(input);
            }
            in.close();
            //JSONObject jsonObject = new JSONObject(textePageApi.toString());
            JSONArray jsonArray = new JSONArray(textePageApi.toString());
            longitude = jsonArray.getJSONObject(0).getFloat("lon");
            latitude = jsonArray.getJSONObject(0).getFloat("lat");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void fromWebToJson() throws IOException {
        String input;
        StringBuilder textePageApi = new StringBuilder();
        URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&appid=c20d187883a70f683816fb55e5027b90&lang=fr");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((input = in.readLine()) != null) {
            //readLine input prend la valeur de in qui est lu de ligne en  ligne
            textePageApi.append(input);
        }
        in.close();
        JSONObject jsonObject = new JSONObject(textePageApi.toString());
        JSONArray list = (JSONArray) jsonObject.get("daily");
        String dateCutted = new String();
        for(int i = 0; i<6; i++){
            JSONObject dayJsonObject = (JSONObject) list.get(i);
            hashMapOfJson.put(i, dayJsonObject);
        }


    }


       /* public Object[] dataWeather(int jour){
            JSONObject dataWeather = hashMapOfJson.get(jour);
             return

        }*/

    public float getLongitudeTest(){
        return longitude;
    }

    public float getLatitudeTest(){
        return latitude;
    }




    //données par jour(le jour commence à 0)
    public Object[] dataWeather(int jour){

        JSONObject dataWeather = hashMapOfJson.get(jour);
        JSONArray weatherDescription = (JSONArray) dataWeather.get("weather");
        JSONObject description = (JSONObject) weatherDescription.get(0);

        String descriptionString = description.getString("description");
        String mainString = description.getString("main");
        double dayTemp = dataWeather.getJSONObject("temp").getInt("day") - 273.15;
        int dayTempCasted = (int) dayTemp;

        double dayTempMin = dataWeather.getJSONObject("temp").getInt("min") - 273.15;
        int dayTempMinCasted = (int) dayTempMin;

        double dayTempMax = dataWeather.getJSONObject("temp").getInt("min") - 273.15;
        int dayTempMaxCasted = (int) dayTempMax;

        double dayWind = dataWeather.getInt("wind_speed") ;
        int dayWindCasted = (int) dayWind;


        double mornTemp = dataWeather.getJSONObject("temp").getInt("morn") - 273.15;
        int mornTempCasted = (int) dayTemp;

        double nightTemp = dataWeather.getJSONObject("temp").getInt("night") - 273.15;
        int nightTempCasted = (int) nightTemp;

        Object[] valeurAStocker = new Object[8];
        //valeurAStocker[0] =
        valeurAStocker[0] = new String(descriptionString);
        valeurAStocker[1] = Integer.valueOf(dayTempCasted);
        valeurAStocker[2] = Integer.valueOf(mornTempCasted);
        valeurAStocker[3] = Integer.valueOf(nightTempCasted);
        valeurAStocker[4] = Integer.valueOf(dayTempMaxCasted);
        valeurAStocker[5] = Integer.valueOf(dayTempMinCasted);
        valeurAStocker[6] = Integer.valueOf(dayWindCasted);
        valeurAStocker[7] = new String(mainString);

        return valeurAStocker;
    }



}

