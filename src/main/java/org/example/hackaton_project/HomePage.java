package org.example.hackaton_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import static org.example.hackaton_project.HelloApplication.*;

public class HomePage {
    Parent root; Scene scene;

    public void display() throws IOException {
        root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        scene = new Scene(root, 800, 640);
        window.setScene(scene);
    }

    @FXML
    public void joinGame() throws IOException {
        lobbyPage.display();
    }
}
