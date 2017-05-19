
/**
 * Write a description of class Objc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objc
{
    private double x,y,z, roomWidth, roomDepth, scale, ox,oy,oz;
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
    
    
    public double getScale()
    {
        return this.scale;
        
        
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
        ox= x;
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
        oy = y;
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
        oz = z;
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
     * in more than one direction at the same time for convinence reasons)
     * @param double --> The new x coordinate
     * @param double --> The new y coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setCoordinates(double e, double f, double g){
        ox = x;
        oy = y;
        oz = z;
        x = e;
        y = f;
        z = g;
    }
    
    /**
     * Reverts doty back to the previous position
     */
    public void revert()
    {
        x = ox;
        y = oy;
        z = oz;
    }
     
    
    /**
     * Payton here --> Sets the texture (in case you change it)
     * @param String --> The new texture
     * @return none
     */
    public void setTexture(String txt){
        texture = txt;
    }
    
    /**
     * Payton here --> Gets the texture of the objc object
     * @param none
     * @return String the texture
     */
    public String getTexture(){
        return texture;
    }
    
}
