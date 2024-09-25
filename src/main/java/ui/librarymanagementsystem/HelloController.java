package ui.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField loginEmail;
    @FXML
    private TextField loginPassword;

    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public void switchToRegister(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("register.fxml"));
        root = fxml.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public void switchToLogin(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = fxml.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }
    public void onLogin(ActionEvent event) throws IOException {
        // get login information
        String email = loginEmail.getText();
        String password = loginPassword.getText();
        // check login for authorize

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainApp.fxml"));
        root = fxml.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}