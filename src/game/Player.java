package game;

import java.util.ArrayList;

/**
 * Class: Intro to Software Engineering
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 */
public abstract class Player
{
    // The inventory of the player.
    private static final ArrayList<Item> inventory = new ArrayList<>();

    // The current room the player is in.
    private static Room currentRoom = null;

    // The limit of items a player can hold.
    private static final int inventoryLimit = 5;

    // Position of player
    private static final int[] position = new int[]{ 0, 0 };

    /**
     * Method to add an item to the player's inventory.
     *
     * @param item - The item to be added.
     *
     * @return True if the item was added, false otherwise.
     */
    public static boolean addItem(Item item)
    {
        if(Player.inventory.size() < Player.inventoryLimit)
        {
            return Player.inventory.add(item);
        }

        return false;
    }

    /**
     * Method to determine if the player has a given item.
     *
     * @param item - The item to get.
     *
     * @return The item if the player has the item, null otherwise.
     */
    public static Item getItem(Item item)
    {
        // iterate over inventory until item is found
        for(final Item e : Player.inventory)
        {
            if(e == item)
            {
                return e;
            }
        }

        return null;
    }

    public static int[] getPosition()
    {
        return Player.position;
    }

    public static void setPosition(int[] pt)
    {
        Player.position[0] = pt[0];
        Player.position[1] = pt[1];
        Player.setCurrentRoom(World.getRoomAt(pt));
    }

    public static ArrayList<Item> getInventory()
    {
        return Player.inventory;
    }

    public static Room getCurrentRoom()
    {
        return Player.currentRoom;
    }

    public static void setCurrentRoom(Room room)
    {
        Player.currentRoom = room;
    }
}
