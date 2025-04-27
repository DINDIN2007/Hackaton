package org.example.hackaton_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import static org.example.hackaton_project.HelloApplication.*;

public class Lobby {
    @FXML private Button startButton;

    private Parent root; private Scene scene;
    
    @FXML
    public void display() throws IOException {
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        scene = new Scene(root);
        window.setScene(scene);
    }

    @FXML
    public void joinGame() throws IOException {
        gamePage.startGame();
    }

    
}
