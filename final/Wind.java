import env3d.advanced.EnvAdvanced;
import env3d.advanced.EnvParticle;
import env3d.Env;

import com.jme3.math.Vector3f;
import com.jme3.math.ColorRGBA;

/**
 * Generates random wind speeds & gives an arrow so user know how strong
 * the wind is
 * 
 * @author (Payton Schubel) 
 * @version (5/12/2017)
 */
public class Wind
{
    private float speed; //The speed of the wind in meters per second
    private int rotateZ; //Me orienting the arrow in the proper direction

    /**
     * Default constructor for objects of class Wind
     * @param none
     */
    public Wind()
    {
        //creates an arrow to represent the wind speed
        //Generates a number between -27 and 27
        //Negative and positive will determine whether the wind goes left of right
        speed = (float)(Math.random() * 54) - 27;
    }
    
    public void particles()
    {
        // Create a particle system with 10000 particles
        EnvParticle particle = new EnvParticle(100);

        // emit in the negative y direction
        particle.getJmeParticleSystem().getParticleInfluencer().setInitialVelocity(new Vector3f(0, 0, getSpeed()));
        
        // size of each particle
        particle.getJmeParticleSystem().setStartSize(0.05f);
        particle.getJmeParticleSystem().setEndSize(0.01f);
        // how long does each particle last        
        particle.getJmeParticleSystem().setLowLife(100);
        particle.getJmeParticleSystem().setHighLife(10000);
        // The start and end color, color is (r, g, b, alpha).  
        // alpha = 1 means visible, alpha = 0 means transparent
        particle.getJmeParticleSystem().setStartColor(new ColorRGBA(1, 1, 1, 1));
        particle.getJmeParticleSystem().setEndColor(new ColorRGBA(1, 1, 1, 0.8f));

        // Sets the texture to be a snowfake 
        particle.setTexture("textures/particle/snowflake.png");        
        // put the particle system much higher than the camera
        particle.setZ(50);
         
        // add the particle to the environment. 
        // The default center point is 0, 0, 0.
        Game.env.addObject(particle);
        
    }

    /**
     * Gets the wind speed
     * @param none
     * @return int the wind speed
     */
    public float getSpeed(){
        //particles();
        return speed;
    }
    
    /**
     * Changes the wind speed randomly and will return the new windspeed
     * @param none
     * @return int the new wind speed
     */
    public float changeSpeed(){
        float lol = speed;
        speed = (int)(Math.random() * 54) - 27;
        return lol;
    }
    
    /**
     * Sets scale relative to the speed.
     * @param none
     * @return none
     */
    public void showSpeed(){
        Game.env.setDisplayStr("Wind: " + speed);
    }
    
    /**
     * Rotates the arrow (so they know in what direction
     * the wind is blowing)
     * @param none
     * @return none
     */
    public void direction(){
        if (speed < 0)
            rotateZ = 180;
        else
            rotateZ = 0;
    }
    
    /**
     * Changes the visibility of the object
     * (visible or invisible)
     * @param none
     * @return none
     */
    public void changeVisibility(){
       
    }
    
    /**
     * toString: Returns the speed in a String
     * @param none
     * @return String the speed
     */
    public String toString(){
        return "" + speed;
    }
}
