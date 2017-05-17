
/**
 * Write a description of class Objc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objc
{
    private double x,y,z, roomWidth, roomDepth, scale;
    private String texture, model;
    public Objc(String txt, String mod, double e, double f, double g)
    {
        x = e;
        y = f;
        z = g;
        texture = txt;
        model = mod;
        scale = 1;
    }
    
    public double setscale(double num)
    {
        double rekt = scale;
        scale = num;
        return rekt;
        
    }
     /**
     * Set the dimension of the room Doty is in
     */
    public void setRoomDim(double w, double d)
    {
        roomWidth = w;
        roomDepth = d;
    }
    
    /**
     * Payton here --> Sets the x coordinate
     * @param double --> The new x coordinate
     * @return none
     */
    public void setX(double e){
        x = e;
    }
    
    /**
     * Payton here --> Gets the x coordinate
     * @param none
     * @return double - The x coordinate
     */
    public double getX(){
        return x;
    }
    
    /**
     * Payton here --> Sets the y coordinate
     * @param double --> The new y coordinate
     * @return none
     */
    public void setY(double f){
        y = f;
    }
    
    /**
     * Payton here --> Gets the y coordinate
     * @param none
     * @return double - The y coordinate
     */
    public double getY(){
        return y;
    }
    
    /**
     * Payton here --> Sets the z coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setZ(double g){
        z = g;
    }
    
    /**
     * Payton here --> Gets the z coordinate
     * @param none
     * @return double --> The z coordinate
     */
    public double getZ(){
        return z;
    }
    
    /**
     * Payton here --> Sets all the coordinates at once (in case you're moving
     * in more than one direction)
     * @param double --> The new x coordinate
     * @param double --> The new y coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setCoordinates(double e, double f, double g){
        x = e;
        y = f;
        z = g;
    }
    
}
