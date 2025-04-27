package org.example.hackaton_project;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.IOException;

import static org.example.hackaton_project.HelloApplication.*;
import static org.example.hackaton_project.Audio.*;

public class GamePage {
    @FXML private Parent root;
    @FXML public static Canvas gameScreen;
    @FXML public static Label textBox;

    public static Car playerCar;

    public static Audio audio = new Audio();
    
    private Scene scene;
    public static Image backgroundSource;
    public static Image backgroundOverlay;
    public static Image carImage;
    public static Image playerBox;
    private static Image puzzle1;

    public static GraphicsContext graphicsContext;

    int timeOfTheDay;

    public static boolean isReading = false;

    public static double centerX, centerY;
    public static boolean showHitBoxes = false;

    public void home() throws IOException {
        homePage.display();
    }

    public void createTextBox() {

    }

    public void display() {
        window.setScene(scene);
    }

    public void startGame() throws IOException {
        root = FXMLLoader.load(getClass().getResource("game.fxml"));
        scene = new Scene(root);
        gameScreen = (Canvas) root.lookup("#gameScreen");
        graphicsContext = gameScreen.getGraphicsContext2D();
        graphicsContext.setImageSmoothing(false);

        centerX = gameScreen.getWidth() / 2;
        centerY = gameScreen.getHeight() / 2;

        backgroundSource = new Image(getClass().getResourceAsStream("Images/test_background.png"));
        backgroundOverlay = new Image(getClass().getResourceAsStream("Images/overlay.png"));
        carImage = new Image(getClass().getResourceAsStream("Images/redLambo.png"));
        playerBox = new Image(getClass().getResourceAsStream("Images/puzzle1.png"));
        playerCar = new Car();

        textBox = (Label) root.lookup("#textBox");
        textBox.setVisible(false);

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                updateElement();
            }
        }.start();

        scene.setOnKeyPressed(this::handleKeyPressed); //need to implement a pause, so that the controls can be paused while text shows
        scene.setOnKeyReleased(this::handleKeyReleased); //don't forget the pause to disable this too

        audio.carStart();
        audio.playBackgroundMusic();
        gamePage.display();

        updateElement();
        Map.createCollisionBoxes();
    }

    private static void updateElement() {
        if (isReading) return;

        graphicsContext.clearRect(0, 0, gameScreen.getWidth(), gameScreen.getHeight());
        graphicsContext.translate(centerX, centerY);

        Map.update();
        playerCar.update();
        Map.drawBackgroundOverlay();

        graphicsContext.translate(-centerX, -centerY);
    }

    private void handleKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W: case UP:
                audio.carMove();
                playerCar.moveUp = true;
                break;
            case S: case DOWN:
                audio.carMove();
                playerCar.moveDown = true;
                break;
            case A: case LEFT:
                audio.carMove();
                playerCar.moveLeft = true;
                break;
            case D: case RIGHT:
                if (isReading) {
                    playerCar.currentDialogue.nextTextBox();
                }
                audio.carMove();
                playerCar.moveRight = true;
                break;
            case H:
                showHitBoxes = !showHitBoxes;
                break;
        }
    }

    private void handleKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W: case UP:
                playerCar.moveUp = false;
                break;
            case S: case DOWN:
                playerCar.moveDown = false;
                break;
            case A: case LEFT:
                playerCar.moveLeft = false;
                break;
            case D: case RIGHT:
                playerCar.moveRight = false;
                break;
        }
    }
}
