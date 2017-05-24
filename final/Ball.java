import env3d.Env;

/**
 *This is the ball class
 */
public class Ball
{
    private int mass;
    private String texture;
    private double x,y,z,scale, rotateZ, rotateX, ox,oy,oz;
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
        rotateX = 0;
        rotateZ = 0;
    }
    
    public void setYaw(double yee)
    {
        rotateZ = yee;
        
    }
    
    public void settype(String type2){
        texture = type2;
    }
    
    public double getScale()
    {
        return this.scale;
    }
    
    public void setscale(double scale2){
        scale = scale2;
    }
    
    public void setmass(int mass2)
    {
        this.mass = mass2;
    }
  
    public int getmass()
    {
        return this.mass;
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
    public void setxyz (double g, double e, double f)
     {
         ox = x;
         oy = y;
         oz = z;
         x = g;
         y = e;
         z = f;
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
    
    public void throwBall(Env env, double velocity, double initX, double initY)
    {
        
        
        
        
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
    
    /**
     * Payton herre --> Returns the rotation of X for the placeBall method
     * @param none
     * @return double -- rotateX
     */
    public double getRotateX(){
        return rotateX;
    }
    
}
