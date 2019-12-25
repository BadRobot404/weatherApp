package controller;
/*κλάση διαχείρησης του entity City*/

import static controller.Controller.em;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.City;
import model.WeathernowPK;
import remote.JsonManager;



public class ControllerWeatherNowPK extends Controller
{
    public ControllerWeatherNowPK()
    {
        super();
    }
    
        
    public void refreshWeathernowPK(List<WeathernowPK> wn)
    {
        //clearTable();
        
        em.getTransaction().begin();
        for (WeathernowPK w : wn)
        {
            //System.out.println(c.getCityname());
            em.persist(w);
        }
        em.getTransaction().commit();
    }
    
    
    
    @Override
    public void clearTable()
    {
        clearTbl("City.deleteAll");
    }
}
