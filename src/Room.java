import java.awt.Point;

public class Room {
    private Item[] itemsInRoom;
    private String roomDescription;
    private Point roomPosition;
    private Command[] roomSpecificCommands;
    
    public Room(Item[] i, String desc, Point p, Command[] cm) {
        this.itemsInRoom = i;
        this.roomDescription = desc;
        this.roomPosition = p;
        this.roomSpecificCommands = cm;
    }
    
    public Item[] getItems() {
        return itemsInRoom;
    }
    
    public String getDescription() {
        return roomDescription;
    }
    
    public Point getRoomPosition() {
        return roomPosition;
    }
    
    public Command[] getRoomCommands() {
        return roomSpecificCommands;
    }
}

