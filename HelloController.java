package com.example.girilab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<client> clientTable;
    public TableColumn<client,Integer> ID;
    public TableColumn <client,String> Name;
    public TableColumn <client,String> Username;
    public TableColumn <client,String> Password;
    public TextField UID;
    public TextField UName;
    public TextField UUsername;
    public TextField UPassword;
    @FXML
    private Label welcomeText;

    ObservableList<client> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fetch();
    }

    @FXML
    private void fetch() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/junglab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM client";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String Name = resultSet.getString("Name");
                String Username = resultSet.getString("Username");
                String Password = resultSet.getString("Password");
                clientTable.getItems().add(new client(ID, Name, Username, Password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<client,Integer>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<client,String>("Name"));
        Username.setCellValueFactory(new PropertyValueFactory<client,String>("Username"));
        Password.setCellValueFactory(new PropertyValueFactory<client,String>("Password"));
        clientTable.setItems(list);


    }

    public void insert(ActionEvent actionEvent) {


        String Name = UName.getText();
        String Username = UUsername.getText();
        String Password = UPassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/junglab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `client`( `Name`, `Username`, `Password`) VALUES ('"+Name+"','"+Username+"','"+Password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void update(ActionEvent actionEvent) {
        String ID = UID.getText();
        String Name = UName.getText();
        String Username = UUsername.getText();
        String Password = UPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/junglab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `client` SET `Name`='"+Name+"',`Username`='"+Username+"',`Password`='"+Password+"' WHERE ID='"+ID+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ActionEvent actionEvent) {

        String ID = UID.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/junglab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `client` WHERE ID='"+ID+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void load(ActionEvent actionEvent) {

        String ID = UID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/junglab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM client WHERE ID='"+ID+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String Name = resultSet.getString("Name");
                String Username = resultSet.getString("Username");
                String Password = resultSet.getString("Password");

                UName.setText(Name);
                UUsername.setText(Username);
                UPassword.setText(Password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}