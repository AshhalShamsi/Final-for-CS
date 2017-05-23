import java.util.ArrayList;
import env3d.Env;
import env3d.advanced.*;
import org.lwjgl.input.Keyboard;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.io.*;
/**
 * Write a description of class Objc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objc
{
    protected double x,y,z, roomWidth, roomDepth, scale, ox,oy,oz, rotateX, rotateY;
    private String texture;
    public Objc(String txt, String mod, double e, double f, double g)
    {
        String model;
        x = e;
        y = f;
        z = g;
        texture = txt;
        if (!(mod.equalsIgnoreCase("ball"))){
            model = mod;
        }
        else
            model = "ball";
        scale = 1;
    }

    
    public Objc(String txt, double e, double f, double g)
    {
        x = e;
        y = f;
        z = g;
        texture = txt;
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
     * The private distance method
     */
    private double distance(Objc obj) {
        double x1 = this.getX();
        double y1 = this.getY();
        double z1 = this.getZ();
        double x2 = obj.getX();
        double y2 = obj.getY();
        double z2 = obj.getZ();
        double xdiff, ydiff, zdiff;
        xdiff = x2 - x1;
        ydiff = y2 - y1;
        zdiff = z2 - z1;
        return (double) Math.sqrt(xdiff*xdiff + ydiff*ydiff + zdiff*zdiff);
    }    
    
    /**
     * Turn this object to face another game object
     * @param gameObj to object to face 
     */
    public void turnToFace(Objc gameObj) 
    {
        this.setRotateY(Math.toDegrees(Math.atan2(gameObj.getX()-this.getX(),gameObj.getZ()-this.getZ())));
        setRotateX(Math.toDegrees(Math.asin((this.getY()-gameObj.getY())/this.distance(gameObj))));        
    }
    
     /**
     * Turn this object to face another game object
     * @param gameObj to object to face 
     */
    public void turnToFace(Ball gameObj) 
    {
        setRotateY(Math.toDegrees(Math.atan2(gameObj.getX()-this.getX(),gameObj.getZ()-this.getZ())));
        setRotateX(Math.toDegrees(Math.asin((this.getY()-gameObj.getY())/this.distance(gameObj))));        
    }
    
    public void setRotateY(double stuff)
    {
        rotateY = stuff;
        
    }
    
     public void setRotateX(double stuff)
    {
        rotateX = stuff;
        
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
    
    /**
     * Changes the visibility of the objc object
     * (Invisible when the texture is none
     * @param String the texture of the object
     * @return none
     */
    public void changeVisibility(String txt){
        if (this.getTexture().equals(null))
            this.setTexture(txt);
        else
            this.setTexture(null);
    }
    
}
