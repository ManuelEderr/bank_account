module htl.steyr.bank_account {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires mysql.connector.java;


    opens htl.steyr.bank_account to javafx.fxml;
    exports htl.steyr.bank_account;
}