package com.database.dbadmin.database;

import com.database.dbadmin.models.Book;
import com.database.dbadmin.models.LegalEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LegalEntityDatabase implements IDataBaseObject<LegalEntity> {

    public
    DBConnection dbConnection = new DBConnection(DBConnection.name, DBConnection.password);

    @Override
    public void save(LegalEntity legalEntity) {
        String query = "INSERT INTO book_store_schema.legal_entity_customer(fio_header, address, phone_number, bank_name, bank_account, inn, customer_name)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,legalEntity.getFIO_header());
            preparedStatement.setString(2,legalEntity.getAddress());
            preparedStatement.setString(3,legalEntity.getPhone_number());
            preparedStatement.setString(4,legalEntity.getBank_name());
            preparedStatement.setString(5,legalEntity.getBank_account());
            preparedStatement.setString(6,legalEntity.getInn());
            preparedStatement.setString(7,legalEntity.getCustomer_name());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage()+ "\n"+e.getCause());
        }
    }

    @Override
    public void delete(LegalEntity legalEntity) {
        String query = "delete from book_store_schema.legal_entity_customer where id = ?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,legalEntity.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage()+ "\n"+e.getCause());
        }
    }

    @Override
    public void update(LegalEntity legalEntity) {
        String query = "update book_store_schema.legal_entity_customer set fio_header= ?, address= ?, phone_number = ?, bank_name = ?, bank_account = ?, inn = ?, customer_name = ? where id = ?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,legalEntity.getFIO_header());
            preparedStatement.setString(2,legalEntity.getAddress());
            preparedStatement.setString(3,legalEntity.getPhone_number());
            preparedStatement.setString(4,legalEntity.getBank_name());
            preparedStatement.setString(5,legalEntity.getBank_account());
            preparedStatement.setString(6,legalEntity.getInn());
            preparedStatement.setString(7,legalEntity.getCustomer_name());
            preparedStatement.setInt(8,legalEntity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+ "\n"+e.getCause());
        }
    }

    @Override
    public LegalEntity get(Long id) {
        LegalEntity legalEntity = new LegalEntity();
        String query = "SELECT * FROM book_store_schema.legal_entity_customer WHERE id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(2,id);
            ResultSet set = statement.executeQuery();
            legalEntity.setAddress(set.getString("address"));
            legalEntity.setId(set.getInt("id"));
            legalEntity.setBank_account(set.getString("bank_account"));
            legalEntity.setBank_name(set.getString("bank_name"));
            legalEntity.setFIO_header(set.getString("fio_header"));
            legalEntity.setInn(set.getString("inn"));
            legalEntity.setCustomer_name(set.getString("customer_name"));
            legalEntity.setPhone_number(set.getString("phone_number"));
            return legalEntity;
        }catch (SQLException e){
            System.out.println(e.getMessage()+ "\n"+e.getCause());
        }
        return null;
    }
}
