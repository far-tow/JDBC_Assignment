package se.lexicon;

import se.lexicon.dao.CityDao;
import se.lexicon.dao.CityDaoJDBC;
import se.lexicon.model.City;

import java.util.List;


public class App
{

    public static void main( String[] args ) {
       /* System.out.println("------------------------------");
        System.out.println("findById(): ");
        CityDao dao = new CityDaoJDBC();
        City city = dao.findById(143);
        System.out.println("city = " + city);*/

        // findByCode()
        System.out.println("------------------------------");
        System.out.println("findByCode(): ");
        CityDao dao = new CityDaoJDBC();
        List<City> cities = dao.findByCode("IRN");
        cities.forEach(System.out::println);


    }
}
