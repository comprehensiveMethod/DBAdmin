package com.database.dbadmin.database;

import com.database.dbadmin.models.NaturalPerson;
import com.database.dbadmin.models.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProviderDataBase implements IDataBaseObject<Provider> {
    DBConnection dbConnection = new DBConnection(DBConnection.name,DBConnection.password);
    @Override
    public void save(Provider provider) {
        String query = "INSERT INTO book_store_schema.provider(address, bank_account, bank_name, inn, company_name) " +
                "VALUES(?, ?, ?, ?, ?)";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,provider.getAddress());
            statement.setString(2,provider.getBank_account());
            statement.setString(3,provider.getBank_name());
            statement.setString(4,provider.getInn());
            statement.setString(5,provider.getCompany_name());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Provider provider) {
        String query = "DELETE  from book_store_schema.provider where id = ?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,provider.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Provider provider) {
        String query = "update book_store_schema.provider set address = ?, bank_account= ?, bank_name=?, inn=?, company_name=? where id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,provider.getAddress());
            statement.setString(2,provider.getBank_account());
            statement.setString(3,provider.getBank_name());
            statement.setString(4,provider.getInn());
            statement.setString(5,provider.getCompany_name());
            statement.setInt(6,provider.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Provider get(Long id) {
        Provider provider = new Provider();
        String query = "SELECT * FROM book_store_schema.provider WHERE id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1,id);
            ResultSet set = statement.executeQuery();
            provider.setAddress(set.getString("address"));
            provider.setBank_account(set.getString("bank_account"));
            provider.setInn(set.getString("inn"));
            provider.setBank_name(set.getString("bank_name"));
            provider.setCompany_name(set.getString("company_name"));
            return provider;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
