import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class: Intro to Software Engineering
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 * Course : CSE 201-C Fall 2024
 * Written: November 3, 2024
 * Purpose: Class to represent a room in the game.
 *
 * @version 1.0
 */
public class Room
{
    private final String name; // name of the room
    private final ArrayList<Item> items; // items within the room
    private final String description; // room description
    private final Point position; // room position as a Point
    private final HashMap<String, Command<?>> contextualCommands; // commands unique to this room

    /**
     * Creates a new room
     *
     * @param items    list of items in the room
     * @param desc     description of the room
     * @param p        room's position represented as a Point
     * @param commands list of commands unique to this room
     */
    public Room(String name,
                ArrayList<Item> items,
                String desc,
                Point p,
                HashMap<String, Command<?>> commands)
    {
        this.name = name;
        this.items = items;
        this.description = desc;
        this.position = p;
        this.contextualCommands = commands;
    }

    /**
     * Returns the room's name
     *
     * @return the room's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the items in this room
     *
     * @return the items in this room
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }

    /**
     * Returns the room's description
     *
     * @return the room's description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns the room's position
     *
     * @return the room's position
     */
    public Point getPosition()
    {
        return position;
    }

    /**
     * Returns the room's unique commands
     *
     * @return the room's unique commands
     */
    public HashMap<String, Command<?>> getRoomCommands()
    {
        return contextualCommands;
    }
}
