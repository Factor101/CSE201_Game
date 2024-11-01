import java.awt.Point;

public class Command {
    /**
     * Creates new command
     */
    public Command() {

    }

    /**
     * Command to go with no direction
     * 
     * @return message telling player to specify a direction
     */
    public static String go() {
        return "Go where?";
    }

    /**
     * Command for going north
     * 
     * @return a point value to be added to current room position to determine
     *         if the player can move to an new room
     */
    public static Point goNorth() {
        return new Point(0, 1);
    }
    
    /**
     * Command for going east
     * 
     * @return a point value to be added to current room position to determine
     *         if the player can move to an new room
     */
    public static Point goEast() {
        return new Point(1, 0);
    }
    
    /**
     * Command for going south
     * 
     * @return a point value to be added to current room position to determine
     *         if the player can move to an new room
     */
    public static Point goSouth() {
        return new Point(0, -1);
    }
    
    /**
     * Command for going west
     * 
     * @return a point value to be added to current room position to determine
     *         if the player can move to an new room
     */
    public static Point goWest() {
        return new Point(-1, 0);
    }

    /**
     * 
     * @param cmdName
     * @return
     */
    public static Command resolveCommand(String cmdName) {
    	return null;
    }
}
