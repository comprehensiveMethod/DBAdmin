package com.database.dbadmin.database;

import com.database.dbadmin.models.Book;
import com.database.dbadmin.models.NaturalPerson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NaturalPersonDataBase implements IDataBaseObject<NaturalPerson> {
    DBConnection dbConnection = new DBConnection(DBConnection.name,DBConnection.password);
    @Override
    public void save(NaturalPerson naturalPerson) {
        String query = "INSERT INTO book_store_schema.natural_person(fio, telephone, passport) " +
                "VALUES(?, ?, ?)";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,naturalPerson.getFio());
            statement.setString(2,naturalPerson.getTelephone());
            statement.setString(3,naturalPerson.getPassport());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(NaturalPerson naturalPerson) {
        String query = "DELETE from book_store_schema.natural_person where id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,naturalPerson.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(NaturalPerson naturalPerson) {
        String query = "update book_store_schema.natural_person set fio = ?, telephone = ?, passport = ? where id = ?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,naturalPerson.getFio());
            statement.setString(2,naturalPerson.getTelephone());
            statement.setString(3,naturalPerson.getPassport());
            statement.setInt(4,naturalPerson.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public NaturalPerson get(Long id) {
        NaturalPerson naturalPerson = new NaturalPerson();
        String query = "SELECT * FROM book_store_schema.natural_person WHERE id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1,id);
            ResultSet set = statement.executeQuery();
            naturalPerson.setFio(set.getString("fio"));
            naturalPerson.setPassport(set.getString("passport"));
            naturalPerson.setTelephone(set.getString("telephone"));
            return naturalPerson;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
