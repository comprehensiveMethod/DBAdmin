module com.database.dbadmin{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires java.sql;
    requires org.junit.platform.commons;
    requires org.junit.jupiter.api;
    requires static lombok;


    opens com.database.dbadmin to javafx.fxml;
    exports com.database.dbadmin;
    exports com.database.dbadmin.controllers;
    opens com.database.dbadmin.controllers to javafx.fxml;
    exports com.database.dbadmin.database;
    opens com.database.dbadmin.database to javafx.fxml;
}
