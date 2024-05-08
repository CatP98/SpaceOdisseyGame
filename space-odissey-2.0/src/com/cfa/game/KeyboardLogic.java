package com.cfa.game;


import com.cfa.gameObjects.Astronaut;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private Astronaut astronaut;
    private Game game;

    private boolean tPressed;
    private boolean nPressed;
    private boolean shiftPressed;

    public KeyboardLogic() {
    keyboard = new Keyboard(this);


    KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

    KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

    KeyboardEvent shift = new KeyboardEvent();
        shift.setKey(KeyboardEvent.KEY_SHIFT);
        shift.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shift);

    KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

    KeyboardEvent tKey = new KeyboardEvent();
        tKey.setKey(KeyboardEvent.KEY_T);
        tKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(tKey);
    //testing
    KeyboardEvent releaseTKey = new KeyboardEvent();
        releaseTKey.setKey(KeyboardEvent.KEY_T);
        releaseTKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseTKey);

    KeyboardEvent nKey = new KeyboardEvent();
        nKey.setKey(KeyboardEvent.KEY_N);
        nKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(nKey);
    //testing
    KeyboardEvent releaseNKey = new KeyboardEvent();
        releaseNKey.setKey(KeyboardEvent.KEY_N);
        releaseNKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseNKey);

    KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(enter);

    KeyboardEvent exit = new KeyboardEvent();
        exit.setKey(KeyboardEvent.KEY_ESC);
        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(exit);

}

public void setAstronaut(Astronaut astronaut){
        this.astronaut = astronaut;
}

public void setGame(Game game){
        this.game = game;
}

@Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            astronaut.moveUp();

        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_DOWN){
            astronaut.moveDown();

        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_SPACE){
            game.pause();
            System.out.println("Game paused");
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_ESC){
            game.exitGame();
            System.out.println("Exit game");
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_ENTER){
            game.removeControls();
        }

        //to change image of the objects when changing modes

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_T){
            tPressed = true;
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_N){
            nPressed = true;
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SHIFT){
            shiftPressed = true;
        }

        if(tPressed && shiftPressed){
            astronaut.changeToTurbo();
        }

        if(nPressed && shiftPressed){
            astronaut.changeToNormal();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_T){
            tPressed = false;
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_N){
            nPressed = false;
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SHIFT){
            shiftPressed = false;
        }

    }

}
