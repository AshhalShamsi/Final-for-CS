

/**
 *This is the ball class
 */
public class Ball extends Objc
{
    private int mass;
    private String texture;
    private double x,y,z,scale, rotateZ, ox,oy,oz;
    /**
     * Default constructor for objects of class Ball
     */
    public Ball(int mass2, String type2, double g, double e, double f, double scle)
    {
        super(type2,g,e,f);
        this.mass = mass2;
        super.scale = scle;
        rotateZ = 0;
    }
    
    public void setYaw(double yee)
    {
        rotateZ = yee;
        
    }

    
    public double getScale()
    {
        return this.scale;
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
     * Payton here --> Gets the x coordinate
     * @param none
     * @return double - The x coordinate
     */
    public double getX(){
        return super.x;
    }
    
    /**
     * Payton here --> Sets the y coordinate
     * @param double --> The new y coordinate
     * @return none
     */
    public void setY(double f){
        super.setY(f);
    }
    
    /**
     * Payton here --> Gets the y coordinate
     * @param none
     * @return double - The y coordinate
     */
    public double getY(){
        return super.y;
    }
    
    /**
     * Payton here --> Sets the z coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setZ(double g){
        super.setZ(g);
    }
    
    /**
     * Payton here --> Gets the z coordinate
     * @param none
     * @return double --> The z coordinate
     */
    public double getZ(){
        return super.z;
    }
    
    /**
     * Payton here --> Sets all the coordinates at once (in case you're moving
     * in more than one direction at the same time for convinence reasons)
     * @param double --> The new x coordinate
     * @param double --> The new y coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setxyz(double e, double f, double g){
        super.setCoordinates(e,f,g);
    }
    
    /**
     * Reverts doty back to the previous position
     */
    public void revert()
    {
        super.revert();
    }
     
    
    /**
     * Payton here --> Sets the texture (in case you change it)
     * @param String --> The new texture
     * @return none
     */
    public void setTexture(String txt){
        super.setTexture(txt);
    }
    
    /**
     * Payton here --> Gets the texture of the objc object
     * @param none
     * @return String the texture
     */
    public String getTexture(){
        return super.getTexture();
    }
    
}
