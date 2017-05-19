import java.util.ArrayList;
import java.util.HashMap;
import env3d.Env;
/**
 * A room describes the current environment.  Only one
 * room can be displayed at one time.
 * 
 */
public class Room
{
    // Must have these fields for Env to reconize this room
    private double width, height, depth;
    private String textureNorth, textureSouth, textureEast, textureWest,textureTop, textureBottom;
 
    // Some additional fields for the game
    private String description;
    private ArrayList<Block> blocks;
    private HashMap<String, Room> exits;
    private Room currentRoom;
     
    /**
     * Constructor for objects of class Room
     */
    public Room(double w, double h, double d, String desc)
    {
        width = w;
        height = h;
        depth = d;
        description = desc;
         
        textureNorth = "textures/fence0.png"; 
        textureEast = "textures/fence0.png"; 
        textureSouth = "textures/fence0.png"; 
        textureWest =  "textures/fence0.png"; 
        textureTop = "textures/fence0.png"; 
        textureBottom = "textures/fence0.png"; 
        blocks = new ArrayList<Block>();
        exits = new HashMap<String, Room>();
    }
     
    /**
     * Add a block to this room.
     * 
     * @param block The block object to be added to the room
     */
    public void addBlock(Block block)
    {
        blocks.add(block);
    }
     
    /**
     * Get the block 
     * 
     * @return The collection of blocks
     */
    public ArrayList<Block> getBlocks()
    {
        return blocks;
    }
     
    
    
    
     /**
     * The private distance method
     */
    private double distance(double x1, double x2, double y1, double y2, double z1, double z2) {
        double xdiff, ydiff, zdiff;
        xdiff = x2 - x1;
        ydiff = y2 - y1;
        zdiff = z2 - z1;
        return (double) Math.sqrt(xdiff*xdiff + ydiff*ydiff + zdiff*zdiff);
    }    
     
    
    /**
     * Check to see if any collision occur between Doty and the objects in the current room
     */   
    public boolean checkCollision(Env env)
    {
        // For every wall in the current room
        for (Block block : this.getBlocks()) {
            // Stop doty from moving if doty hits a wall
            double dist = distance(block.getX(), env.getCameraX(), block.getY(), env.getCameraY(), block.getZ(), env.getCameraZ());
            if (dist <= block.getScale() + 5) {                
                return true;
            }
           
        }
        return false;
    }
    
    
    
    
    /**
     * Get the description of the room
     * 
     * @return The description string
     */
    public String getDescription()
    {
        return description;
    }
     
    /**
     * Mutator for the wall texture
     */
    public void setTextureNorth(String fileName)
    {
        textureNorth = fileName;
    }
    
     /**
     * Mutator for the wall texture
     */
    public void setTextureBottom(String fileName)
    {
        textureBottom = fileName;
    }
    
     /**
     * Mutator for the wall texture
     */
    public void setTextureTop(String fileName)
    {
        textureTop = fileName;
    }
    
    
    public void setCurrentRoom(Env env)
    {
        if (this != null) {
            currentRoom = this;
            env.setRoom(currentRoom);
            for (Block block : currentRoom.getBlocks()) {
                env.addObject(block);
            }
        }
    }
 
    /**
     * Mutator for the wall texture
     */
    public void setTextureEast(String fileName)
    {
        textureEast = fileName;
    }
 
    /**
     * Mutator for the wall texture
     */
    public void setTextureSouth(String fileName)
    {
        textureSouth = fileName;
    }
 
    /**
     * Mutator for the wall texture
     */
    public void setTextureWest(String fileName)
    {
        textureWest = fileName;
    }
         
    /**
     * Create an exit to a room
     * 
     * @param direction the direction of the exit
     * @param room the room that this direction exits to
     */
    public void setExit(String direction, Room room)
    {
        exits.put(direction, room);
    }
     
    /**
     * Get the room a direction exits to.  
     * 
     * @param direction a string indicating a direction
     * @return the room that the direction exits to.  null if no exit
     * in that direction
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
     
    /**
     * Accessor for the room's dimension
     */
    public double getWidth()
    {
        return width;
    }
     
    /**
     * Accessor for room's dimension
     */
    public double getDepth()
    {
        return depth;
    }
}