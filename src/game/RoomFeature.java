package game;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomFeature
{
    private final String name; // name of the item
    private final String description; // description of the item
    private final ArrayList<Command<?>> commands; // commands unique to this item
    public boolean isInteracted = false;

    /**
     * Constructor method.
     */
    RoomFeature(String name, String description, ArrayList<Command<?>> commands)
    {
        this.name = name;
        this.description = description;
        this.commands = commands;
    }

    /**
     * Returns the name of the item as a string.
     *
     * @return Name of the item.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns a description of the item as a string.
     *
     * @return Description of the item.
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Returns the commands unique to this item.
     *
     * @return Commands unique to this item.
     */
    public ArrayList<Command<?>> getCommands()
    {
        return this.commands;
    }
}
