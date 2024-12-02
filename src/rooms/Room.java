package rooms;

import game.Command;
import game.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class: Intro to Software Engineering
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 */
public abstract class Room
{
    private final String name; // name of the room
    private final ArrayList<Item> items; // items within the room
    private final String description; // room description
    private final int[] position; // room position as a Point
    private final HashMap<String, Command<?>> contextualCommands; // commands unique to this room

    /**
     * Creates a new room.
     *
     * @param items    list of items in the room
     * @param desc     description of the room
     * @param pt       room's position represented as a point {x, y}
     * @param commands list of commands unique to this room
     */
    public Room(String name, String desc, int[] pt, ArrayList<Item> items, HashMap<String, Command<?>> commands)
    {
        this.name = name;
        this.items = items;
        this.description = desc;
        this.position = pt;
        this.contextualCommands = commands;
    }

    /**
     * Creates a new room with a Point instead of int[].
     *
     * @param items    list of items in the room
     * @param desc     description of the room
     * @param pt       room's position represented as a Point
     * @param commands list of commands unique to this room
     */
    public Room(String name, String desc, Point pt, ArrayList<Item> items, HashMap<String, Command<?>> commands)
    {
        this(name, desc, new int[]{ (int) pt.getX(), (int) pt.getY() }, items, commands);
    }

    public Room(String name, String desc)
    {
        this(name, desc, new int[]{ 0, 0 }, new ArrayList<Item>(), new HashMap<>());
    }

    /**
     * Decides if user should be allowed to enter.
     *
     * @return true if player can enter the room.
     */
    public abstract boolean checkEntry();

    /**
     * Returns the room's name
     *
     * @return the room's name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the items in this room
     *
     * @return the items in this room
     */
    public ArrayList<Item> getItems()
    {
        return this.items;
    }

    /**
     * Returns the room's description
     *
     * @return the room's description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Returns the room's position
     *
     * @return the room's position
     */
    public int[] getPosition()
    {
        return this.position;
    }

    /**
     * Returns the room's unique commands
     *
     * @return the room's unique commands
     */
    public HashMap<String, Command<?>> getRoomCommands()
    {
        return this.contextualCommands;
    }
}
