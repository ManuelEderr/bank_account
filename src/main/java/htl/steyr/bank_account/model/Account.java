package htl.steyr.bank_account.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
    private String iban;
    private String owner;



    public Account(ResultSet resultSet) throws SQLException {
        this.iban = resultSet.getString("iban");
        this.owner = resultSet.getString("owner");
    }

    public static ObservableList<Account> getAccount(){
        Connection connection = Database.getConnection();

        ObservableList<Account> list = FXCollections.observableArrayList();
        try {
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery("SELECT * FROM t_account");

            while(results.next()){
                list.add(new Account(results));
            }
            results.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static ObservableList<Transaction> getTransactions(String iban){
        Connection connection = Database.getConnection();

        ObservableList<Transaction> list = FXCollections.observableArrayList();
        try {
            Statement s = connection.createStatement();
            String executionQuery = "SELECT * FROM transaction t INNER JOIN t_account ta on t.owner_iban = ta.iban WHERE ta.iban = '" + iban + "'";
            ResultSet results = s.executeQuery(executionQuery);

            while(results.next()){
                list.add(new Transaction(results));
            }
            results.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String getDate(){
        Connection connection = Database.getConnection();

        String returnString = "";
        try {
            Statement s = connection.createStatement();
            String executionQuery = "SELECT date FROM transaction_info INNER JOIN";
            ResultSet results = s.executeQuery(executionQuery);

            while(results.next()){
                returnString = "";
            }
            results.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnString;
    }


    @Override
    public String toString() {
        return "IBAN: " + iban + " " + "OWNER: " + owner;
    }

    public String getIban() {
        return iban;
    }

    public String getOwner() {
        return owner;
    }
}
