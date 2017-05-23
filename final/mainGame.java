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
    // instance variables - replace the example below with your own
    private static double ox,oy,oz;
    private static EnvAdvanced env;
    private Room room;
    private Objc stuff, stuff2, fidget, test, bucket1;
    private Ball ball1;
    private Thread t = new Thread();
    private final static double step = .25; 
    private GraphiclessMenu menu;
    /**
     * Constructor for objects of class mainGame
     */
    public mainGame() throws IOException
    {
        room = new Room (45,10,35, "Mi cabeza es ROJO");
        room.setTextureEast("textures/wall.jpg");
        room.setTextureNorth("textures/wall.jpg");
        room.setTextureSouth("textures/wall.jpg");
        room.setTextureWest("textures/wall.jpg");
        room.setTextureTop("textures/concrete.jpg");
        room.setTextureBottom("textures/floor/paving5.png");
        stuff2 = new Objc("models/bucket/bucket1.jpg","models/bucket/bucket.obj",3,0,room.getDepth()/2);
        ball1 = new Ball(512,"models/test/test.jpg", 5, 2, 8, 1 );
        bucket1 = new Objc("models/bucket/bucket1.jpg","models/bucket/bucket.obj",room.getWidth()-3,0,room.getDepth()/2);
        menu = new GraphiclessMenu();
        //test = new Intensity_1(13, 13, 13);
        ox = 0;
        oy =0;
        oz = -1;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void play() throws InterruptedException, IOException
    {
        // put your code here
        // Position the camera
        env = new EnvAdvanced();
        boolean finished = false;
        room.setCurrentRoom(env);
        env.setCameraXYZ(5, 5, 4);        
        
        //System.out.println(env.getCameraPitch());
        // Disable mouse and camera control
        env.setDefaultControl(finished);
        env.addObject(stuff2);
        env.addObject(ball1);
        env.addObject(bucket1);
        //env.addObject(test);
       
        while (env.getKey() != 1)
        {
            //ball1.setxyz(env.getCameraX()-(5*Math.cos(env.getCameraPitch()*Math.PI/180)), env.getCameraY()+(5*Math.sin(env.getCameraPitch()*Math.PI/180)), env.getCameraZ()-(5*Math.cos(env.getCameraYaw()*Math.PI/180)));
            ball1.setxyz(env.getCameraX() + (5*Math.cos(env.getMouseDX()*Math.PI/180)),  env.getCameraY()+(5*Math.sin(env.getCameraPitch()*Math.PI/180)), env.getCameraZ()+(5*Math.cos(env.getMouseDY()*Math.PI/180)));
            //ball1.setYaw(env.getCameraYaw());
            env.advanceOneFrame();
            // Position the camera
            if(env.getKey() == 60)
                if (finished == false)
                    finished = true;
                else
                    finished = false;
            
            if (env.getKey() == 59)
                menu.useMenu(true);
            move();
            checkWall();
          
            env.setDefaultControl(finished);
        }
        env.exit();
    }
    
    
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
    

public void revert(){
    env.setCameraXYZ(ox,oy,oz);
  
}
    
public static void main(String[] args) throws InterruptedException, IOException
    {  
        (new mainGame()).play();
    }
}