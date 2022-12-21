package se.lexicon.dao;

import se.lexicon.dao.dataBase.DbConnection;
import se.lexicon.extentions.DBConnectionException;
import se.lexicon.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {

    public City findById(int id) {
        String query = "SELECT * FROM city WHERE id = ?";
        City city = new City();

        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
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

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return city;
    }

    public List<City> findByCode(String code) {
        String query = "SELECT * FROM city WHERE countrycode = ?";
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
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

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cities;
    }

    public List<City> findByName(String name) {
        String query = "SELECT * FROM city WHERE name = ?";
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, name);
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

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cities;
    }

    public List<City> findAll() {
        String query = "SELECT * FROM city";
        List<City> cities = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cities;
    }

    public City add(City city) {
        String query = "insert into city (name, countrycode, district, population) values (?, ?, ?, ?) ";


        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, city.getName());
            ps.setString(2, city.getCountryCode());
            ps.setString(3, city.getDistrict());
            ps.setInt(4, city.getPopulation());

            int result = ps.executeUpdate();
            System.out.println((result == 1) ? "Added successfully" : "Not added!");
            try (ResultSet resultSet = ps.getGeneratedKeys();) {

                int keyId = 0;
                while (resultSet.next()) {
                    keyId = resultSet.getInt(1);
                }
                city.setId(keyId);
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return city;
    }

    public City update(City city) {
        String query = "update city set name = ?, countrycode = ?, district = ?, population = ? where id = ? ";
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, city.getName());
            ps.setString(2, city.getCountryCode());
            ps.setString(3, city.getDistrict());
            ps.setInt(4, city.getPopulation());
            ps.setInt(5, city.getId());


            int result = ps.executeUpdate();
            System.out.println((result == 1) ? "Updated successfully" : "Not updated!");
            try (ResultSet resultSet = ps.getGeneratedKeys();) {

                int keyId = 0;
                while (resultSet.next()) {
                    keyId = resultSet.getInt(1);
                }
                city.setId(keyId);
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return city;
    }

    public int delete(City city) {
        String query = "delete from city where id= ?";
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, city.getId());
            int result = ps.executeUpdate();
            System.out.println((result == 1) ? "Deleted successfully" : "Not deleted!");
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 1;
    }
}
