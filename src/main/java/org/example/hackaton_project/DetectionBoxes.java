package org.example.hackaton_project;

import java.awt.*;

import static org.example.hackaton_project.GamePage.graphicsContext;
import static org.example.hackaton_project.GamePage.showHitBoxes;

public class DetectionBoxes {
    double x, y;
    double width, height;
    double currentX = x, currentY = y;
    public Dialogues boxDialogue;

    public DetectionBoxes(int x, int y, int width, int height) {
        double resolution = Map.width / 512;

        this.x = x * resolution;
        this.y = y * resolution;
        this.width = width * resolution;
        this.height = height * resolution;

        boxDialogue = new Dialogues();
    }

    public void update() {
        updatePosition();
        draw();
    }

    public void updatePosition() {
        this.currentX = Map.x + this.x;
        this.currentY = Map.y + this.y;
    }

    public void draw() {
        if (showHitBoxes) {
            graphicsContext.fillRect(this.currentX, this.currentY, this.width, this.height);
        }
    }
}
