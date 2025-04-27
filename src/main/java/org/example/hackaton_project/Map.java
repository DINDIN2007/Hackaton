package org.example.hackaton_project;

import java.util.Vector;

import static org.example.hackaton_project.GamePage.*;

public class Map {
    public static Vector<CollisionBoxes> collisionBoxes = new Vector<CollisionBoxes>();
    public static Vector<DetectionBoxes> detectionBoxes = new Vector<DetectionBoxes>();
    public static double x, y, width, height;


    public static void update() {
        updatePosition();
        drawBackground();

        if (collisionBoxes.size() != 0) {
            for (CollisionBoxes box : collisionBoxes) {
                box.update();
            }
        }
        if (detectionBoxes.size() != 0) {
            for (DetectionBoxes box : detectionBoxes) {
                box.update();
            }
        }
    }

    public static void updatePosition() {
        Map.x = centerX - playerCar.x;
        Map.y = centerY - playerCar.y;

        Map.width = gameScreen.getWidth() * 5;
        Map.height = Map.width / 512 * 592;
    }

    private static void drawBackground() {
        graphicsContext.drawImage(backgroundSource,
                Map.x, Map.y, Map.width, Map.height
        );
    }

    public static void drawBackgroundOverlay() {
        graphicsContext.drawImage(backgroundOverlay,
                Map.x, Map.y, Map.width, Map.height
        );
    }

    public static void createCollisionBoxes() {
        collisionBoxes.add(
            new CollisionBoxes(40, 72, 160, 160 - 72)
        );
        collisionBoxes.add(
                new CollisionBoxes(40, 6, 199-40, 53-6)
        );
        collisionBoxes.add(
            new CollisionBoxes(216, 72, 295 - 216, 159 - 72)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 22, 511, 37-22)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 6, 23, 277-6)
        );
        collisionBoxes.add(
                new CollisionBoxes(216, 6, 511-216, 53-6)
        );
        collisionBoxes.add(
                new CollisionBoxes(328, 70, 416-328, 165-70)
        );
        collisionBoxes.add(
                new CollisionBoxes(432, 70, 511-462, 165-70)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 174, 135, 277-174)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 174, 135, 277-174)
        );
        collisionBoxes.add(
                new CollisionBoxes(152, 174, 319-152, 277-174)
        );
        collisionBoxes.add(
                new CollisionBoxes(328, 190, 399-328, 277-190)
        );
        collisionBoxes.add(
                new CollisionBoxes(328, 190, 399-328, 277-190)
        );
        collisionBoxes.add(
                new CollisionBoxes(416, 190, 495-416, 269-190)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 294, 135, 365-294)
        );
        collisionBoxes.add(
                new CollisionBoxes(152, 294, 319-152, 373-294)
        );
        collisionBoxes.add(
                new CollisionBoxes(328, 294, 399-328, 373-294)
        );
        collisionBoxes.add(
                new CollisionBoxes(416, 294, 503-416, 381-294)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 397, 135, 500-397)
        );
        collisionBoxes.add(
                new CollisionBoxes(152, 397, 319-152, 500-397)
        );
        collisionBoxes.add(
                new CollisionBoxes(328, 413, 399-328, 500-413)
        );
        collisionBoxes.add(
                new CollisionBoxes(416, 413, 495-416, 492-413)
        );
        collisionBoxes.add(
                new CollisionBoxes(0, 519, 223, 591-519)
        );
        collisionBoxes.add(
                new CollisionBoxes(240, 519, 511-240, 591-519)
        );

        // Detection boxes
        DetectionBoxes box;
        //When you arrive at the hotel
        box = new DetectionBoxes(241, 153, 269-241, 167-153);
        box.boxDialogue.setBoxDialogueSolvePuzzle1();
        detectionBoxes.add(box);

        //WcDonalds
        box = new DetectionBoxes(343, 371, 370-343, 390-371);
        box.boxDialogue.setBoxDialogueWcDonalds();
        detectionBoxes.add(box);

        //NOKIA building
        box = new DetectionBoxes(88, 244, 127-88, 288-244);
        box.boxDialogue.kaboom1();
        box.boxDialogue.kaboom2();
        box.boxDialogue.kaboom3();
        box.boxDialogue.setBoxDialogueGoodEnding();
        detectionBoxes.add(box);

        box = new DetectionBoxes(88, 244, 127-88, 288-244);
        box.boxDialogue.setBoxDialogueIntro1();
        detectionBoxes.add(box);
    }
}