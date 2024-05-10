package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public class Game {

    private Astronaut astronaut;
    private CollisionDetector collisionDetector;
    private Background background;

    public static final String RESOURCES_PREFIX = "resources/";

    public static int SPEED;

    public Picture initialPic; //Include remotes explanation
    public Picture gameOverPic;
    public Picture pausePic;

    public Score score;
    public ScoreManager scoreManager;

    public static boolean gameOver = false;
    public static boolean paused = false;

    public Picture menuDisplay;
    public Picture winDisplay;
    public Picture gameOverDisplay;
    public Picture pauseDisplay;  //check in Picture or rectangle if we manage to create a freeze screen( screen desfocado com o jogo parado de fundo)

    public ObstaclesFactory obstacles;
    public CollisionDetector collisionCheck;

    public Game(){
        astronaut = new Astronaut();
        SPEED = Speed.SLOW.getSpeedValue();
        obstacles = new ObstaclesFactory();
        collisionCheck = new CollisionDetector();

        menuDisplay = new Picture(0, 0, RESOURCES_PREFIX + "menu/menu3.png");
        gameOverDisplay = new Picture(0,0,RESOURCES_PREFIX + "menu/menu3.png" );
        winDisplay = new Picture(0,0,RESOURCES_PREFIX + "menu/menu3.png" );
        gameOverPic = new Picture(0,0,RESOURCES_PREFIX + "menu/menu3.png" );
        pausePic = new Picture(0,0,RESOURCES_PREFIX + "menu/menu3.png" );
    }

    /*
    public void start(Background background){
        //background.moveBackground();
        Thread backgroundThread = new Thread(background);
        backgroundThread.start();

        while(true){
            System.out.println("random");
            //cleanObstaclesMemory();
            //while (scoreCheck.missionNotComlete() >> spaceShip items counte !=0  && scoreCheck.health >> O2 counter !=0){


            int random = (int) (Math.random() * 4) + 1;
            switch (random){
                    case 1:
                        obstacles.addAsteroid();
                        break;
                    case 2:
                        obstacles.addSpaceShipItem();
                        break;
                    case 3:
                        obstacles.addUFO();
                        break;
                    case 4 :
                        obstacles.addO2();
                        break;
                    default :
                        obstacles.addAsteroid();
                }
            //}
            moveObstacles();
        }
    }

     */

    public void start(Background background) {
        Thread backgroundThread = new Thread(background);
        backgroundThread.start();

        // Create and start a thread for each obstacle
        Thread[] obstacleThreads = new Thread[4];
        for (int i = 0; i < obstacleThreads.length; i++) {
            obstacleThreads[i] = new Thread(() -> {
                while (!gameOver && !paused) {
                    // Add a new obstacle based on a random selection
                    int random = (int) (Math.random() * 4) + 1;
                    switch (random) {
                        case 1:
                            obstacles.addAsteroid();
                            break;
                        case 2:
                            obstacles.addSpaceShipItem();
                            break;
                        case 3:
                            obstacles.addUFO();
                            break;
                        case 4:
                            obstacles.addO2();
                            break;
                        default:
                            obstacles.addAsteroid();
                    }
                    // Pause for a short time to allow other threads to execute
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            cleanObstaclesMemory();
            obstacleThreads[i].start();
            moveObstacles();
        }
        for (Thread thread : obstacleThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cleanObstaclesMemory(){
        if (obstacles.getSize() == 10) {
            obstacles.removeObstacle(0);
        }
    }

    public void moveObstacles() {
        while (!gameOver || !paused) {

            for (int i = 0; i <= (obstacles.getSize() - 1); i++) {
                obstacles.getObstacle(i).move();
                collisionCheck.collision(obstacles.getObstacle(i), astronaut);
            }

            if (gameOver || paused) {
                // Exit the loop if game over or paused
                break;
            }

            // Introduce a delay to control the speed of obstacle movement
            try {
                Thread.sleep(100); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause(){}
    public void resume(){}
    public void exitGame(){
    }
    public void removeControls(){}

    public void setKeyboard(){

    }

    public void setBackground(Background background){
        this.background = background;
    }

    public void setAstronaut(Astronaut astronaut){
        this.astronaut = astronaut;
    }

    public static void setSpeed(int speed){
        Game.SPEED = speed;
    }

    public static int getSpeed(){
        return Game.SPEED;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector){
        this.collisionDetector = collisionDetector;
    }

    public void drawControls(Background background){
        this.background = background;
    }

}
