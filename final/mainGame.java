import java.util.ArrayList;
import env3d.Env;
import org.lwjgl.input.Keyboard;
import java.util.*;
/**
 * Write a description of class mainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainGame
{
    // instance variables - replace the example below with your own
    private Env env;
    private Room room;
    private Objc stuff, stuff2, fidget, test;
    private Ball ball1;
    /**
     * Constructor for objects of class mainGame
     */
    public mainGame()
    {
        room = new Room (15,10,10, "Mi cabeza es ROJO");
        room.setTextureEast("textures/bricks.jpg");
        room.setTextureNorth("textures/bricks.jpg");
        room.setTextureSouth("textures/bricks.jpg");
        room.setTextureWest("textures/bricks.jpg");
        room.setTextureTop("textures/bricks.jpg");
        room.setTextureBottom("textures/bricks.jpg");
        stuff = new Objc("models/test/test.jpg", "models/test/test.obj", 10,10,10);
        stuff2 = new Objc("models/test/test.jpg","models/trash/trash.obj",5,8,5);
        ball1 = new Ball(512, "models/test/test.jpg", 5, 2, 8, 1 );
        fidget = new Objc("models/test/test.jpg","models/fidget/fidget.obj",5,2,5);
        
        test = new Intensity_1(13, 13, 13);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void play()
    {
        // put your code here
        // Position the camera
        env = new Env();
        boolean finished = false;
        fidget.setscale(1);
        room.setCurrentRoom(env);
        env.setCameraXYZ(5, 13, 9);        
        System.out.println(env.getCameraPitch());
        // Disable mouse and camera control
        env.setDefaultControl(true);
        stuff.setRoomDim(room.getWidth(), room.getDepth());     
        env.addObject(stuff);
        env.addObject(stuff2);
        env.addObject(ball1);
        env.addObject(test);
        //env.addObject(fidget);
        while (env.getKey() != 1)
        {
            ball1.setxyz(env.getCameraX()+(5*Math.cos(env.getCameraPitch()*Math.PI/180)*Math.sin(env.getCameraYaw()*Math.PI/180)), env.getCameraY()+(5*Math.sin(env.getCameraPitch()*Math.PI/180)), env.getCameraZ()+(5*Math.cos(env.getCameraPitch()*Math.PI/180) * Math.cos(env.getCameraYaw()*Math.PI/180)));
            //ball1.setYaw(env.getCameraYaw());
            env.advanceOneFrame();
            // Position the camera
            
        }
        env.exit();
    }
}
