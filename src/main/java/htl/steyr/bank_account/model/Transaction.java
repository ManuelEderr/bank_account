package htl.steyr.bank_account.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
    private int transaction_id;
    private String owner_iban;
    private int amount;
    private int info_id;


    public Transaction(ResultSet results) throws SQLException {
        this.transaction_id = results.getInt("transaction_id");
        this.owner_iban = results.getString("owner_iban");
        this.amount = results.getInt("amount");
        this.info_id = results.getInt("info_id");
    }

    @Override
    public String toString() {
        return "Amount: " + amount;
    }

    public String getInfo() throws SQLException {
        Connection c = Database.getConnection();
        String info = "";

        Statement s = c.createStatement();

        ResultSet resultSet = s.executeQuery("SELECT info FROM transaction INNER JOIN transaction_info ti on transaction.info_id = ti.info_id\n" +
                "WHERE ti.info_id =  " + this.info_id);

        while (resultSet.next()){
            info = resultSet.getString(1);
        }


        return info;
    }
}
