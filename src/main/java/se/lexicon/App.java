package se.lexicon;

import se.lexicon.dao.CityDao;
import se.lexicon.dao.CityDaoJDBC;
import se.lexicon.model.City;

import java.util.List;


public class App
{

    public static void main( String[] args ) {
       /*CityDao dao = new CityDaoJDBC();
        City city = dao.findById(143);
        System.out.println("city = " + city);*/

        // findByCode()
       /* CityDao dao = new CityDaoJDBC();
        List<City> cities = dao.findByCode("IRN");
        cities.forEach(System.out::println);*/

        // findByName()
        CityDao dao = new CityDaoJDBC();
        List<City> cities1 = dao.findByName("Teheran");
        cities1.forEach(System.out::println);




    }
}
