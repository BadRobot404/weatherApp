package controller;
/*κλάση διαχείρησης του entity City*/

import static controller.Controller.em;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.City;
import remote.JsonManager;



public class ControllerCity extends Controller
{
    public ControllerCity()
    {
        super();
    }
    
    /*Εύρεση πόλης με το αντίστοιχο Id*/
    public City findCityByCityId(int cityId)
    {
        return em.find(City.class, cityId);
    }
    
    public void refreshCities(List<City> cities)
    {
        
        
        em.getTransaction().begin();
        for (City c : cities)
        {
            //System.out.println(c.getCityname());
            em.persist(c);
        }
        em.getTransaction().commit();
    }
    
    
    
    @Override
    public void clearTable()
    {
        clearTbl("City.deleteAll");
    }
}
