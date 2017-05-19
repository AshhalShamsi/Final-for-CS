

/**
 *This is the ball class
 */
public class Ball
{
    private int mass;
    private String texture;
    private double x,y,z,scale, rotateZ, ox,oy,oz;
    /**
     * Default constructor for objects of class Ball
     */
    public Ball(int mass2, String type2, double g, double e, double f, double scle)
    {
        this.mass = mass2;
        texture = type2;
        x = g;
        y = e;
        z = f;
        scale = scle;
        rotateZ = 0;
    }
    
    public void setYaw(double yee)
    {
        rotateZ = yee;
        
        
        
    }

    public void settype(String type2)
    {
        texture = type2;
    }
    
    public void setscale(double scale2)
    {
        scale = scale2;
        
    }
    
    public double getScale()
    {
        return this.scale;
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
    
    
    public void setxyz (double g, double e, double f)
    {
        ox = x;
        oy = y;
        oz = z;
        x = g;
        y = e;
        z = f;
    }
    
    public void revert()
    {
       x = ox;
       y = oy;
       z = oz;
        
    }
    
    public void setmass(int mass2)
    {
        this.mass = mass2;
    }
  
    public int getmass()
    {
        return this.mass;
    }
}
