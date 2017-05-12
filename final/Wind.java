/**
 * Generates random wind speeds
 * 
 * @author (Payton Schubel) 
 * @version (5/12/2017)
 */
public class Wind
{
    private int speed; //The speed of the wind in meters per second

    /**
     * Default constructor for objects of class Wind
     * @param none
     */
    public Wind()
    {
        //Generates a number between -27 and 27
        //Negative and positive will determine whether the wind goes left of right
        speed = (int)(Math.random() * 54) - 27;
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
     * toString: Returns the speed in a String
     * @param none
     * @return String the speed
     */
    public String toString(){
        return "" + speed;
    }
}
