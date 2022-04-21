package app.appmeteo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherDataDaily {

    private String cityName;
    private JSONObject jsonObject;
    private JSONObject jsonObjectArray;


    public WeatherDataDaily(String cityName){
        this.cityName=cityName;
    }


    public String getCityName(){
        return cityName;
    }

    public void FromWebToJSON(String cityName) throws IOException {

        String input;
        StringBuilder textePageApi = new StringBuilder();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=f5ed2e80c2cdf7b97a863c0777a52a8d&lang=fr");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((input = in.readLine()) != null) {
            //readLine input prend la valeur de in qui est lu de ligne en  ligne
            textePageApi.append(input);
        }
        in.close();

        jsonObject = new JSONObject(textePageApi.toString());
        JSONArray weather = (JSONArray) jsonObject.get("weather");
        // le tableau récupéré ci dessous ne contient qu'un élément "weather", on peut donc le décomposer en objet et le traiter comme tel
        jsonObjectArray = (JSONObject) weather.get(0);
    }



    public  int getCityTemperature() throws IOException {
        return (int)jsonObject.getJSONObject("main").getInt("temp") - 273;
    }

    public double getCityTemperatureFeels() throws IOException {
        return jsonObject.getJSONObject("main").getInt("feels_like") - 273.15;
    }

    public String getMeteoState(){
        return  jsonObjectArray.getString("main");
    }




}
