/**
 * Class to represent the player, containing their
 * info and possible actions.
 * @version 1.0
 */
public class Player {
	// The inventory of the player.
	private Item[] inventory;
	
	// The current room the player is in.
	private Room currentRoom;
	
	// The limit of items a player can hold.
	final private int inventoryLimit = 5;
	
	/**
	 * Constructor method.
	 */
	Player() {
		this.inventory = new Item[inventoryLimit];
	}
	
	/**
	 * Method to determine if the player has a given item.
	 * @param item - The item being tested for.
	 * @return True if the player has the item, false otherwise.
	 */
	public boolean hasItem(Item item) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == item) {
				return true;
			}
		}
		return false;
	}
}
