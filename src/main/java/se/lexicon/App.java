package se.lexicon;

import se.lexicon.dao.CityDao;
import se.lexicon.dao.CityDaoJDBC;
import se.lexicon.model.City;

import java.util.List;


public class App
{

    public static void main( String[] args ) {
       CityDao dao = new CityDaoJDBC();
      /* City city = dao.findById(43);
        System.out.println("city = " + city);*/

        // findByCode()
       /*List<City> cities = dao.findByCode("IRN");
        cities.forEach(System.out::println);*/

        // findByName()
        /*List<City> cities1 = dao.findByName("Teheran");
        cities1.forEach(System.out::println);*/

        // findAll()
        /*List<City> cities2 = dao.findAll();
        cities2.forEach(System.out::println);*/

        // add()
        /*City addCity = new City("Mörrum", "SWE", "Blekinge",4123);
        City addedCity = dao.add(addCity);*/

        // update()
        /*City update = new City(4081,"Mörrum", "SWE", "BLEKINGE LÄN",3900);
        City updated = dao.update(update);*/

        // delete()
       City delete = new City(4081, "Mörrum", "SWE", "BLEKEINGE LÄN", 3900);
        int deleted = dao.delete(delete);




    }
}
