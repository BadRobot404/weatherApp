/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import controller.ControllerCity;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.City;
import model.Weathernow;
import model.WeathernowPK;

/**
 *
 * @author Bill
 */
public class JsonManager {
    public static final String baseURL = "https://api.openweathermap.org/data/2.5/";
    private static String apiKey;
    private static String unitSystem;

    
    public void refreshCities(){
        
        ArrayList cities = new ArrayList();
        
        try
        {
            /*κατασκευή ενός URL για το ερώτημα JSON weather now*/
            URL url = new URL(createUrl());
            
            /*Ξεκινάει τη σύνδεση με τον server και αποθηκεύει τα δεδομένα στη ροή δεδομένων "is".*/          
            InputStream is = url.openStream(); 
            
            /*Διαβάζει τη ροή και μετατρέπει τα εισερχόμενα bytes σε χαρακτήρες.*/
            InputStreamReader isr = new InputStreamReader(is);                              
            
            /*Αναλύει την αρχική δομή του json που βρίσκεται στο isr, και επιστρέφει ένα JsonElement το οποίο μπορεί να είναι
            ένα  JsonObject, JsonArray, JsonPrimitive ή ένα JsonNull.*/
            JsonElement jElement = new JsonParser().parse(isr);
            
            /*εμείς γνωρίζουμε οτι είναι ένα JsonObject οπότε το αποθηκεύουμε σε μια αναφορά mainJsonObject*/   
            JsonObject mainJsonObject = jElement.getAsJsonObject(); 
            
            JsonObject node;
            City newCity;
            int count = mainJsonObject.get("count").getAsInt();
            for(int i =0 ; i<count;i++){
                node = mainJsonObject.getAsJsonArray("list").get(i).getAsJsonObject();
                newCity = new City(node.get("id").getAsInt());
                newCity.setCityname(node.get("name").getAsString());
                cities.add(newCity);
            }
            
            ControllerCity ctrlCity = new ControllerCity();
            ctrlCity.refreshCities(cities);
            
            JsonObject mainNode;
            for(int i =0 ; i<count;i++){
                node = mainJsonObject.getAsJsonArray("list").get(i).getAsJsonObject();
                mainNode=node.get("main").getAsJsonObject();
                WeathernowPK newWeatherNowPK = new WeathernowPK(new Date (node.get("dt").getAsLong()*1000),node.get("id").getAsInt());
                


                //System.out.println(newWeatherNow.getDate());
                
            }
            
        } 
        catch (MalformedURLException ex)
        {
            Logger.getLogger(JsonManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex)
        {
            Logger.getLogger(JsonManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String createUrl(){
        
        return baseURL + "find?lat=37&lon=22&cnt=50" + "&units=" + unitSystem + "&appId=" + apiKey + "&lang=el";
        
    }
    
    public static void setApiKey(String apiKey) {
        JsonManager.apiKey = apiKey;
    }

    public static void setUnitSystem(String unitSystem) {
        JsonManager.unitSystem = unitSystem;
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getUnitSystem() {
        return unitSystem;
    }
    
    
    






    
}
