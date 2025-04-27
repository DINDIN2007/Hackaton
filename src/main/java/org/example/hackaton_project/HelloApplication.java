package org.example.hackaton_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage window;
    public static HomePage homePage;
    public static Lobby lobbyPage;
    public static GamePage gamePage;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("FIND BETTER TITLE");

        homePage = new HomePage();
        lobbyPage = new Lobby();
        gamePage = new GamePage();

        //homePage.display();
        gamePage.startGame();
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}