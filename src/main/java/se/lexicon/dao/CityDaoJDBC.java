package se.lexicon.dao;

import se.lexicon.dao.dataBase.DbConnection;
import se.lexicon.extentions.DBConnectionException;
import se.lexicon.model.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {

    public City findById(int id) {
        String query = "SELECT * FROM city WHERE id = ?";
        City city = new City();

        try (
                PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
        ) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                city.setId(resultSet.getInt(1));
                city.setName(resultSet.getString(2));
                city.setCountryCode(resultSet.getString(3));
                city.setDistrict(resultSet.getString(4));
                city.setPopulation(resultSet.getInt(5));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return city;
    }

    public List<City> findByCode(String code) {
        String query = "SELECT * FROM city WHERE countrycode = ?";
        List<City> cities = new ArrayList<>();
        try (
                PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
        ) {
            ps.setString(1, code);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public List<City> findByName(String name) {
        String query = "SELECT * FROM city WHERE name = ?";
        List<City> cities = new ArrayList<>();
        try (
                PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
        ) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                cities.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public List<City> findAll() {
        return null;
    }

    public City add(City city) {
        return null;
    }

    public City update(City city) {
        return null;
    }

    public int delete(City city) {
        return 0;
    }
}
