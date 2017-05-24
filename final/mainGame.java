import java.util.ArrayList;
import env3d.Env;
import env3d.advanced.*;
import org.lwjgl.input.Keyboard;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.io.*;
/**
 * Write a description of class mainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainGame
{
    //initializes variables that are used by the Env3d library
    private static double ox,oy,oz;
    private static EnvAdvanced env;
    private Room room;//creates a room Class that was found in Example Code but modified
    private Objc stuff, stuff2, fidget, test, bucket1;
    private Ball ball1;//creates a ball object that follows you aroung
    private Thread t = new Thread();
    private final static double step = .25;//sets the step that each press of WASD moves
    private GraphiclessMenu menu;//creates a new Menu object that can be later called
    private Score score;//creates a score object to keep track of the score
    private Intensity_1 intensity; //The intensity object.
    /**
     * Constructor for objects of class mainGame
     */
    public mainGame() throws IOException
    {
        //creates the room, and sets the textures
        room = new Room (45,10,35, "Mi cabeza es ROJO");
        room.setTextureEast("textures/wall.jpg");
        room.setTextureNorth("textures/wall.jpg");
        room.setTextureSouth("textures/wall.jpg");
        room.setTextureWest("textures/wall.jpg");
        room.setTextureTop("textures/concrete.jpg");
        room.setTextureBottom("textures/floor/paving5.png");
        
        //creates the ball and bucket object that are used within the room
        ball1 = new Ball(512,"models/test/test.jpg", 5, 2, 8, 1 );
        bucket1 = new Objc("models/bucket/bucket1.jpg","models/bucket/bucket.obj",3,0,room.getDepth()/2);
        intensity = new Intensity_1(0, room.getHeight() - 5, room.getDepth() / 2 - 3);
        
        menu = new GraphiclessMenu();
        score = new Score();
        ball1.setscale(.25);//sets the scale of the ball to make it smaller
        //initializes old instance variables
        ox = 0;
        oy =0;
        oz = -1;
    }

    /**
     *This is the "main" method of the game, this is where all the magic happens
     */
    public void play() throws InterruptedException, IOException
    {
        //creates a new Env enviornment
        env = new EnvAdvanced();
        boolean finished = false;
        //sets the currrent room to the bucket room
        room.setCurrentRoom(env);
        //sets the initial position
        env.setCameraXYZ(5, 5, 4);        

        // Disable mouse and camera control
        env.setDefaultControl(finished);
        env.addObject(ball1);
        env.addObject(bucket1);
        env.addObject(intensity);
       
        //runs the game loop until ESC is pressed
        while (env.getKey() != 1)
        {
            //displays the Score and Shot number
            env.setDisplayStr("Score: " + score.getScore(),0,480);
            env.setDisplayStr("Shots: " + score.getShots(),0,460);
            env.advanceOneFrame();//advances one frame
            
            //if F2 is pressed magic happens
            if(env.getKey() == 60)
                if (finished == false)
                    finished = true;
                else
                    finished = false;
            
            //Increases the intensity
            if (env.getKey() == Keyboard.KEY_UP){
                intensity.increase();
            }
            
            //Decreases the intensity
            if (env.getKey() == Keyboard.KEY_DOWN){
                intensity.decrease();
            }
                    
            //F3 allows the ball to be thrown
            if(env.getKey() == 61)
            {
               if (!(score.getShots() >= 10))
               {
                   //checks if the ball landed in the bucket
                   boolean temp = ball1.throwBall(env,intensity.getIntensity());
                   //Since this isn't working, jsut always adding distance
                   //from basket to score regardless of whether or not you made it.
                  
                   if (temp)
                        score.add(ball1.getox(),ball1.getoy(),ball1.getoz(),true,true);
                   else 
                        score.addShots();
                    }
                }
            
            //if F1 is pressed then the menu opens up
            if (env.getKey() == 59)
                menu.useMenu(true);
            
            //if cheat mode is active than the move() method does not need to be called
            if (finished == false)    
                move();
            checkWall();//checks for collisions with the wall
            placeBall(7, 0, -1, 0);//places ball following the camera
          
            env.setDefaultControl(finished);//sets cheat mode on or off
        }
        score.checkScore();
        env.exit();
    }
    
     /**
     * Payton Here --> Something to get the ball to follow us arround. I hope it works.
     * 
     * @param double followDist -- How far away you want the ball from you
     * @param double offX -- Not sure
     * @param double offY -- The same as offX, but for the y axis
     * @param double offZ -- The same as offX, but for the z axis
     **/
    public void placeBall(double followDist, double offX, double offY, double offZ){
        
        //Gets the X coordinate for the ball
        ball1.setX((env.getCameraX() + offX) - followDist * Math.sin(Math.toRadians(env.getCameraYaw())) *
                  Math.cos(Math.toRadians(ball1.getRotateX())));
                
        //Gets the y coordinate for the ball
        ball1.setY((env.getCameraY() + offY) - followDist * Math.sin(Math.toRadians(ball1.getRotateX())));
        
        //Gets the z coordinate for the ball
        ball1.setZ((env.getCameraZ() + offZ) - followDist * Math.cos(Math.toRadians(env.getCameraYaw())) *
                  Math.cos(Math.toRadians(ball1.getRotateX())));
        
    }
    
 
 /**
 *Checks for collisions with the walls so the player cannot leave
 *
 **/
 private void checkWall()
    {
        if (env.getCameraX() > room.getWidth()-2) {
           revert();
        } else if (env.getCameraX() < 2) {
           revert();
        }       
         else if (env.getCameraZ() > room.getDepth()-2) {
           revert();
        }      
          else if (env.getCameraZ() < 2) {
           revert();
        }       
    }    

 /**
     *Moves the player if camera control is false
     *(This Code was taken from an Example, but was altered to fit my needs)
     **/
    public static void move(){
        ox = env.getCameraX();
        oy = env.getCameraY();
        oz = env.getCameraZ();
                
                if (env.getKeyDown(Keyboard.KEY_W)) {
            env.setCameraXYZ(env.getCameraX()-step*Math.sin(Math.toRadians(env.getCameraYaw())),
                                env.getCameraY(),
                                env.getCameraZ()-step*Math.cos(Math.toRadians(env.getCameraYaw())));
        }
         
        if (env.getKeyDown(Keyboard.KEY_S)) {
            env.setCameraXYZ(env.getCameraX()+step*Math.sin(Math.toRadians(env.getCameraYaw())),
                                env.getCameraY(),
                                env.getCameraZ()+step*Math.cos(Math.toRadians(env.getCameraYaw())));
        }
         
        if (env.getKeyDown(Keyboard.KEY_A)) {
            env.setCameraXYZ(env.getCameraX()-step*Math.cos(Math.toRadians(env.getCameraYaw())),
                                env.getCameraY(),
                                env.getCameraZ()+step*Math.sin(Math.toRadians(env.getCameraYaw())));
        }
        if (env.getKeyDown(Keyboard.KEY_D)) {
            env.setCameraXYZ(env.getCameraX()+step*Math.cos(Math.toRadians(env.getCameraYaw())),
                                env.getCameraY(),
                                env.getCameraZ()-step*Math.sin(Math.toRadians(env.getCameraYaw())));
        }
         
        double newPitch = env.getCameraPitch()+env.getMouseDY()/2;
         
        // Restrict the pitch to within a "reasonable" amount
        if (newPitch > 50) {
            env.setCameraPitch(50);
        } else if (newPitch < -50) {
            env.setCameraPitch(-50);
        } else {
            env.setCameraPitch(newPitch);
        }
         
        env.setCameraYaw(env.getCameraYaw()-env.getMouseDX()/2);

}
    
 /**
  * Is called if there is a collision between the wall and the player
     **/
public void revert(){
    env.setCameraXYZ(ox,oy,oz);
  
}

//launches the main game without a need for instanitaing an object
public static void main(String[] args) throws InterruptedException, IOException
    {  
        (new mainGame()).play();
    }
}
