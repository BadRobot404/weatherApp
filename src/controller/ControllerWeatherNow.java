package controller;
/*κλάση διαχείρησης του entity WeatherNow*/

import java.util.List;
import javax.persistence.Query;
import model.City;
import model.Weathernow;
import remote.DbConnector;
import remote.JsonManager;



public final class ControllerWeatherNow extends Controller
{
    public ControllerWeatherNow()
    {
        super();
    }
    
    // Καθαρίζει τον πίνακα WEATHER_NOW
    public void clearTable()
    {
        clearTbl("WeatherNow.deleteAll");
    }
    
    // Εισαγωγή δεδομένων από JSON στον πίνακα WeatherNow   
    public void insertDataFromJson(List<Weathernow> wn)
    {
        
        
        
        em.getTransaction().begin();
        for (Weathernow w : wn)
        {
            em.persist(w);
        }
        em.getTransaction().commit();
    }
    
    // Ανάκτηση καιρικών συνθηκών για την επιλεγμένη πόλη
    public Weathernow selectWeatherNowByCityName(String cityName)
    {
        Query q = em.createNamedQuery("WeatherNow.findByCityName");
        q.setParameter("cityName", cityName);
        return (Weathernow) q.getSingleResult();
    }
    
    // Ανανέωση δεδομένων από JSON στον πίνακα WeatherNow  
    public void updateWeatherNowData()
    {
        clearTable();
        Query query = em.createNamedQuery("City.findAll");
        List<City> results = query.getResultList();
        
        em.getTransaction().begin();
        for (City c : results)
        {
            
            //em.persist(newWeatherNow);
        }
        em.getTransaction().commit();
    }
}
