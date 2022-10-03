package com.database.dbadmin.database;

import com.database.dbadmin.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDataBase implements IDataBaseObject<Book> {
    public
    DBConnection dbConnection = new DBConnection(DBConnection.name, DBConnection.password);

    @Override
    public void save(Book book) {
        String query = "INSERT INTO book_store_schema.book(author, book_brief_description, publication_date, publisher_name, genre, pages, book_name) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,book.getAuthor());
            statement.setString(2,book.getBook_brief_description());
            statement.setDate(3,book.getPublication_date());
            statement.setString(4,book.getPublisher_name());
            statement.setString(5,book.getGenre());
            statement.setInt(6,book.getPages());
            statement.setString(7, book.getBook_name());
            statement.executeUpdate();
            System.out.println("SQL: Created book with name: " + book.getBook_name());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Book book) {
        String query = "DELETE FROM book_store_schema.book WHERE id = ?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setLong(1,book.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Book book) {
        String query = "UPDATE book_store_schema.book SET author=?, book_brief_description=?, publication_date=?, publisher_name=?, genre=?, pages=?, book_name=? WHERE id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,book.getAuthor());
            statement.setString(2,book.getBook_brief_description());
            statement.setDate(3,book.getPublication_date());
            statement.setString(4,book.getPublisher_name());
            statement.setString(5,book.getGenre());
            statement.setInt(6,book.getPages());
            statement.setString(7, book.getBook_name());
            statement.setLong(8,book.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Book get(Long id) {
        Book book = new Book();
        String query = "SELECT * FROM book_store_schema.book WHERE id=?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1,id);
            ResultSet set = statement.executeQuery();
            book.setBook_name(set.getString("book_name"));
            book.setId(set.getLong("id"));
            book.setAuthor(set.getString("author"));
            book.setBook_brief_description(set.getString("book_brief_description"));
            book.setGenre(set.getString("genre"));
            book.setPages(set.getInt("pages"));
            book.setPublication_date(set.getDate("publication_date"));
            book.setPublisher_name(set.getString("publisher_name"));
            return book;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Book> getAll(){
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM book_store_schema.book";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Book book = new Book();
                book.setBook_name(set.getString("book_name"));
                book.setId(set.getLong("id"));
                book.setAuthor(set.getString("author"));
                book.setBook_brief_description(set.getString("book_brief_description"));
                book.setGenre(set.getString("genre"));
                book.setPages(set.getInt("pages"));
                book.setPublication_date(set.getDate("publication_date"));
                book.setPublisher_name(set.getString("publisher_name"));
                bookList.add(book);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage() + "\n" +e.getCause());
        }
        return bookList;
    }
}
