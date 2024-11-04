/**
 * Class to represent items.
 *
 * @version 1.0
 */
public class Item
{
    private final String name; // Name of the item.
    private final String description; // Description of the item.

    /**
     * Constructor method.
     */
    Item(String name, String description)
    {
        this.name = name;
        this.description = description;
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
}
