/**
 * Generates random wind speeds & gives an arrow so user know how strong
 * the wind is
 * 
 * @author (Payton Schubel) 
 * @version (5/12/2017)
 */
public class Wind extends Objc
{
    private int speed; //The speed of the wind in meters per second
    private int rotateZ; //Me orienting the arrow in the proper direction

    /**
     * Default constructor for objects of class Wind
     * @param none
     */
    public Wind(double x, double y, double z)
    {
        //creates an arrow to represent the wind speed
        super("textures/explode.png", "models/arrows/arrow4.obj", x, y, z);
        
        //Generates a number between -27 and 27
        //Negative and positive will determine whether the wind goes left of right
        speed = (int)(Math.random() * 54) - 27;
        rotateZ = 0;
    }

    /**
     * Gets the wind speed
     * @param none
     * @return int the wind speed
     */
    public int getSpeed(){
        return speed;
    }
    
    /**
     * Changes the wind speed randomly and will return the new windspeed
     * @param none
     * @return int the new wind speed
     */
    public int changeSpeed(){
        speed = (int)(Math.random() * 54) - 27;
        return speed;
    }
    
    /**
     * Sets scale relative to the speed.
     * @param none
     * @return none
     */
    public void showSpeed(){
        super.setscale(Math.abs(speed) / 8.0);
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
        super.changeVisibility("textures/explode.png");
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
