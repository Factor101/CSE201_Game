import java.awt.Point;

public class Room {
    private Item[] itemsInRoom;
    private String roomDescription;
    private Point roomPosition;
    private Command[] roomSpecificCommands;
    
    /**
     * Creates a new room
     * @param i list of items in the room
     * @param desc description of the room
     * @param p room's position represented as a Point
     * @param cm list of commands unique to this room
     */
    public Room(Item[] i, String desc, Point p, Command[] cm) {
        this.itemsInRoom = i;
        this.roomDescription = desc;
        this.roomPosition = p;
        this.roomSpecificCommands = cm;
    }
    
    /**
     * Returns the items in this room
     * @return the items in this room
     */
    public Item[] getItems() {
        return itemsInRoom;
    }
    
    /**
     * Returns the room's description
     * @return the room's description
     */
    public String getDescription() {
        return roomDescription;
    }
    
    /**
     * Returns the room's position
     * @return the room's position
     */
    public Point getRoomPosition() {
        return roomPosition;
    }
    
    /**
     * Returns the room's unique commands
     * @return the room's unique commands
     */
    public Command[] getRoomCommands() {
        return roomSpecificCommands;
    }
}
