package org.example.hackaton_project;

import javafx.scene.image.Image;

import java.util.Vector;

import static org.example.hackaton_project.GamePage.*;

public class Dialogues {
    Vector<String> dialogues = new Vector<String>();
    Image dialogueImage;
    int currentDialogue = 0;
    
    public void nextTextBox() {
        currentDialogue++;
        audio.dialoguePopSound();
        if (currentDialogue >= dialogues.size()) {
            isReading = false;
            textBox.setVisible(false);
        }
        textBox.setVisible(true);
        isReading = true;

        textBox.setText(dialogues.get(currentDialogue));
        graphicsContext.drawImage(dialogueImage, -gameScreen.getWidth() / 2, -gameScreen.getHeight() / 2, gameScreen.getWidth(), gameScreen.getHeight());
    }

    public void setBoxDialogueIntro1() {
        dialogues.add("Damn. Running outta gas.");
        dialogues.add("I’ve been driving for hours, where even am I?");
        dialogues.add("\"Kanata\"? Who spells Canada like that?");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/KanataSign.png"));
    }
    public void setBoxDialogueIntro2() {
        dialogues.add("Wait, Canada? But I left from Melbourne an hour ago!");
        dialogues.add("How did I get to Canada?");
        dialogues.add("This is weird, but first I should stock up on gas.");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/KanataSign.png"));
    }

    public void setBoxDialogueGasStation1() {
        dialogues.add("Where is the cashier?");
        dialogues.add("There hasn't been any other cars on the road, either.");
        dialogues.add("This is weird... Ooo, free map!");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Gas.png"));
    }

    public void setBoxDialogueIntoTown() {
        dialogues.add("Easiest gas I've ever gotten!");
        dialogues.add("It's getting late... Maybe I should look to stay the night somewhere.");
        dialogues.add("Good thing I got a map.");
        audio.mapCheckSound();
    }

    public void setBoxDialoguePrePuzzle1() {
        dialogues.add("Hold on... There's nothing on this but street names!");
        dialogues.add("No information on what places are where!");
        dialogues.add("What's this? ");

    }

    public void setBoxDialoguePuzzle1() {
        dialogues.add("Where darkness meets light,");
        dialogues.add("that is where you will find");
        dialogues.add("refuge from your plight.");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/pixil-frame-04.png"));
    }

    public void setBoxDialogueFailPuzzle() {
        dialogues.add("I don't think that's it...");
    }

    public void setBoxDialogueSolvePuzzle1() {
        dialogues.add("Ah! That's where the hotel is!");
        dialogues.add("Now I've got somewhere to go for the night.");
        dialogues.add("I guess I'll try to find the exit tomorrow.");
    }

    public void setBoxDialogueMorning() {
        dialogues.add("That was a pretty good rest.");
        dialogues.add("Now I got to find someplace to eat.");
        dialogues.add("I think I saw a WcDonald's last night, I'll go there.");
        dialogues.add("Hold on, there's a note under my coffee.");dialogueImage = new Image(getClass().getResourceAsStream("Images/Hotel.png"));
    }

    public void setBoxDialogueWcDonalds() {
        dialogues.add("At least the WcDonald's tastes the same as always.");
        dialogues.add("But what is up with this place? Canada should have more people, right?");
        dialogues.add("Hold on, there's a note under my coffee.");dialogueImage = new Image(getClass().getResourceAsStream("Images/wdonalds.png"));

    }

    public void setBoxDialoguePuzzle2() {
        dialogues.add("Did you know? Four means death in some Asian languages.");
        dialogues.add("But two fours don't. How does that work?");
        dialogues.add("Four is bad, but four squared is fine?");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Jesus.png"));
    }

    public void setBoxDialogueLeavingWcDonalds() {
        dialogues.add("I'm not sure what that note was about, but I have a feeling I should follow it.");
        dialogues.add("Four is bad, but four squared is fine, huh?");
        dialogues.add("Oh? The streets on my map are gone! They're coordinates now!?");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Jesus.png"));
    }

    public void setBoxDialogueWrongLocation() {
        dialogues.add("I don't think this is where I'm supposed to go right now.");
    }

    public void setBoxDialogueEnterLibrary() {
        dialogues.add("A library, hmm? I've always hated them.");
        dialogues.add("Wait. There was nothing inside that library for a second.");
        dialogues.add("Then it lit up in all its glory. That's not suspicious at all.");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Library.png"));
    }

    public void setBoxDialogueLibrary() {
        dialogues.add("This doesn't seem like too bad of a library, though.");
        dialogues.add("Wait. That's a single book on the ground while the others are neatly packed.");
        dialogues.add("Okay, there's definitely something going on here.");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/:Library.png"));
    }

    public void setBoxDialoguePuzzle3() {
        dialogues.add("You've already seen the true face of this world.");
        dialogues.add("There is no reason to prolong this further.");
        dialogues.add("Go see the creator and everything will be resolved.");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/EmptyBook.png"));
    }

    public void setBoxDialogueLeaveLibrary() {
        dialogues.add("So this is a simulation, then?");
        dialogues.add("Then, the creator would be someone who makes technology.");
        dialogues.add("Have I seen a place like that around here?");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Library.png"));
    }

    public void setBoxDialogueEnterNokia() {
        dialogues.add("NOKIA? Now that sounds like a tech company's name.");
        dialogues.add("This has got to be it.");
        dialogues.add("Drat! There's a lock with a four digit code.");
        //0241, don't put the  image here
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Nokia.png"));
    }

    public void setBoxDialoguePuzzle4() {
        dialogues.add("After all your touring around the city,");
        dialogues.add("just a single letter will get you the code.");
        dialogues.add("Don't worry, the lock won't explode after just one try.");
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Library.png"));//keypad image
    }

    public void setBoxDialogueFailPuzzle4() {
        dialogues.add("That wasn't correct? Really?");
        //the lockdialogueImage = new Image(getClass().getResourceAsStream("Images/Library.png"));
    }
    public void setBoxDialogueSucceedPuzzle4() {
        dialogues.add("I knew it. Finally.");
        //the lockdialogueImage = new Image(getClass().getResourceAsStream("Images/Library.png"))
    }

    public void setBoxDialogueBadEnding() {
        dialogues.add("That's... me?");
        dialogues.add("I caused... suffering? I should've stayed inside?");
        dialogues.add("No! It was the virus! It was - "); //game shuts down
    }

    public void kaboom1()
    {
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Nokia.png"));
    }

    public void kaboom2()
    {
        dialogueImage = new Image(getClass().getResourceAsStream("Images/NokiaKaboom.png"));
    }
    public void kaboom3()
    {
        dialogueImage = new Image(getClass().getResourceAsStream("Images/Nokia.png"));
    }
    public void setBoxDialogueGoodEnding() {
        dialogues.add("There's no way I just did that.");
        dialogues.add("But it worked. I'm free, aren't I?");//the end screen
        dialogueImage = new Image(getClass().getResourceAsStream("Images/TheEnd.png"));
    }
}
