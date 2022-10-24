package htl.steyr.bank_account;

import htl.steyr.bank_account.model.Account;
import htl.steyr.bank_account.model.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class HelloController {


    /**
     * Es muss noch immer der foreign_key angelegt werden
     */

    public ListView<Account> konto_listView;
    public ListView<Transaction> transaction_ListView;
    public Label info_text;
    @FXML
    private Label welcomeText;

    @FXML
    protected void initialize() {
        konto_listView.setItems(Account.getAccount());
    }

    public void konto_anlegen(ActionEvent actionEvent) {

    }

    public void transaction(ActionEvent actionEvent) {

    }

    public void kontoListViewClicked(MouseEvent mouseEvent) {
        Account selected = konto_listView.getSelectionModel().getSelectedItem();
        transaction_ListView.getItems().clear();
        if (selected != null){
            for (Transaction transaction : Account.getTransactions(selected.getIban())){
                transaction_ListView.getItems().add(transaction);
            }
        }
    }

    public void transactionListViewClicked(MouseEvent mouseEvent) throws SQLException {
        Transaction selected = transaction_ListView.getSelectionModel().getSelectedItem();
        if (selected != null){
            info_text.setText(selected.getInfo());
        }
    }
}