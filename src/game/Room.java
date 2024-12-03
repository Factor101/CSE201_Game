package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Function;

/**
 * Class: Intro to Software Engineering
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 */
public class Room
{
    private final String name; // name of the room
    private final ArrayList<Item> items; // items within the room
    private final ArrayList<RoomFeature> features; // features within the room
    private final String description; // room description
    private final int[] position; // room position as a Point
    private final HashMap<String, Command<?>> contextualCommands; // commands unique to this room
    private Function<Void, Boolean> checkEntry;

    /**
     * Creates a new room.
     *
     * @param items    list of items in the room
     * @param desc     description of the room
     * @param pt       room's position represented as a point {x, y}
     * @param commands list of commands unique to this room
     */
    public Room(String name,
                String desc,
                int[] pt,
                ArrayList<Item> items,
                ArrayList<RoomFeature> features,
                HashMap<String, Command<?>> commands,
                Function<Void, Boolean> checkEntry)
    {
        this.name = name;
        this.items = items;
        this.description = desc;
        this.position = pt;
        this.features = features;
        this.contextualCommands = commands;
        this.checkEntry = checkEntry;
    }

    public Room(String name,
                String desc,
                int[] pt,
                ArrayList<Item> items,
                Command<?>[] commands,
                ArrayList<RoomFeature> features,
                Function<Void, Boolean> checkEntry)
    {
        this(name, desc, pt, items, features, new LinkedHashMap<>(), checkEntry);
        for(Command<?> command : commands)
        {
            this.contextualCommands.put(command.getName(), command);
        }
    }

    public Room(String name,
                String desc,
                Point pt,
                ArrayList<Item> items,
                Command<?>[] commands,
                ArrayList<RoomFeature> features,
                Function<Void, Boolean> checkEntry)
    {
        this(name, desc, new int[]{ (int) pt.getX(), (int) pt.getY() }, items, features, new LinkedHashMap<>(), checkEntry);
        for(Command<?> command : commands)
        {
            this.contextualCommands.put(command.getName(), command);
        }
    }

    /**
     * Creates a new room with a Point instead of int[].
     *
     * @param items    list of items in the room
     * @param desc     description of the room
     * @param pt       room's position represented as a Point
     * @param commands list of commands unique to this room
     */
    public Room(String name,
                String desc,
                Point pt,
                ArrayList<Item> items,
                HashMap<String, Command<?>> commands,
                ArrayList<RoomFeature> features,
                Function<Void, Boolean> checkEntry)
    {
        this(name, desc, new int[]{ (int) pt.getX(), (int) pt.getY() }, items, features, commands, checkEntry);
    }

    public Room(String name, String desc)
    {
        this(name, desc, new int[]{ 0, 0 }, new ArrayList<Item>(), new ArrayList<>(), new HashMap<>(), null);
    }

    /**
     * Checks if the player can enter the room.
     *
     * @return true if checkEntry is null (not specified) or if checkEntry returns true
     */
    public Boolean checkEntry()
    {
        return this.checkEntry == null || this.checkEntry.apply(null);
    }

    public void addCommand(String name, Command<?> command)
    {
        this.contextualCommands.put(name, command);
    }

    public void setGetEntry(Function<Void, Boolean> checkEntry)
    {
        this.checkEntry = checkEntry;
    }

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

    /**
     * Returns the room's features
     *
     * @return the room's features
     */
    public ArrayList<RoomFeature> getFeatures()
    {
        return this.features;
    }
}
