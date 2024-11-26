import java.awt.Point;
import java.util.ArrayList;

/**
 * Class: Intro to Software Engineering
 * 
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad
 *         Martin, Rafael Santell-Colon
 * @version 1.0 Course : CSE 201-C Fall 2024 Written: November 3, 2024 Purpose:
 *          Main class for the game. Contains the main event loop.
 *
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = new Room[9];
        rooms[0] = new Room("Cyro Pod Room",
                "The room around you is eerily quiet. A dead alien sits in the opposite side of the room from the broken pod from which you awoke.",
                new Point(0, 0), null, null);
        rooms[1] = new Room("Lab",
                "The room appears to be some sort of lab. There sits a desk in one corner, with some scrawlings along the opposite wall.",
                new Point(1, 0), null, null);
        rooms[2] = new Room("Gas Room",
                "The room has a lingering odor about it. There seem to be various things related to chemicals in here.",
                new Point(1, 1), null, null);
        rooms[3] = new Room("Genetic Testing Room",
                "The room contains various cages, and some important looking technology on the far wall.",
                new Point(1, -1), null, null);
        rooms[4] = new Room("Hallway",
                "The hallway contains a strange pattern on the wall, and a windom which gives you a glimpse into the world outside.",
                new Point(2, 0), null, null);
        rooms[5] = new Room("Split-Room",
                "The room smells of Lorem ipsum dolor sit amet",
                new Point(3, 0), null, null);
        rooms[6] = new Room("Greenhouse",
                "The room smells of Lorem ipsum dolor sit amet",
                new Point(3, 1), null, null);
        rooms[7] = new Room("Final Mixing Room",
                "The room smells of Lorem ipsum dolor sit amet",
                new Point(3, -1), null, null);
        rooms[8] = new Room("Yard",
                "The room smells of Lorem ipsum dolor sit amet",
                new Point(3, -2), null, null);

        // temporary line for demo
        Player.setCurrentRoom(rooms[0]);

        // main event loop
        // flag to control the main event loop
        boolean isRunning = true;
        while (isRunning) {
            // prompt, parse, and execute the command
            // user will enter a command + args (where applicable)
            final String userInput = InputHandler
                    .promptCommand("Enter a command:");
            final CommandResult<?> result = InputHandler
                    .parseAndExecute(userInput);

            // output the result
            if (result.isSuccess()) {
                final String message = result.message();
                if (message != null) // do not output Void type commands
                {
                    System.out.println(message);
                }
            } else {
                System.out.println("You spoke nonesense: " + result.message());
            }
        }
    }
}
