import java.awt.Point;

/**
 * Class to represent a room in the game.
 *
 * @version 1.0
 */
public class Room
{
    private final String name; // name of the room
    private final Item[] items; // items within the room
    private final String description; // room description
    private final Point position; // room position as a Point
    private final Command<?>[] contextualCommands; // commands unique to this room

    /**
     * Creates a new room
     *
     * @param items    list of items in the room
     * @param desc     description of the room
     * @param p        room's position represented as a Point
     * @param commands list of commands unique to this room
     */
    public Room(String name,
                Item[] items,
                String desc,
                Point p,
                Command<?>[] commands)
    {
        this.name = name;
        this.items = items;
        this.description = desc;
        this.position = p;
        this.contextualCommands = commands;
    }

    /**
     * Creates a new room with only a name and description
     *
     * @param name name of the room
     */
    public Room(String name, String desc)
    {
        this(name, new Item[0], desc, new Point(0, 0), new Command<?>[0]);
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
    public Item[] getItems()
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
    public Command<?>[] getRoomCommands()
    {
        return contextualCommands;
    }
}
