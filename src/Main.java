import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
                new Point(0, 0), 
                new ArrayList<>(Arrays.asList(new Item("Keycard", "Keycard is the personal property of Dr. Grobu, resident and chief of the transient research facility. You can use this to unlock the lab entrance."))), 
                new HashMap<>());
        rooms[1] = new Room("Lab",
                "The room appears to be some sort of lab. There sits a desk in one corner, with some scrawlings along the opposite wall.",
                new Point(1, 0), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[2] = new Room("Gas Room",
                "The room has a lingering odor about it. There seem to be various things related to chemicals in here.",
                new Point(1, 1), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[3] = new Room("Genetic Testing Room",
                "The room contains various cages, and some important looking technology on the far wall.",
                new Point(1, -1), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[4] = new Room("Hallway",
                "The hallway contains a strange pattern on the wall, and a window which gives you a glimpse into the world outside.",
                new Point(2, 0), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[5] = new Room("Split-Room",
                "You're surrounded by oil drums. The room splits off into two directions. Up north appears to be a greenhouse, while down south the rooms is labeled \"Final Mixing Room\".",
                new Point(3, 0), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[6] = new Room("Greenhouse",
                "As you walk in you see all of the overgrown fauna. You see a flowerbed that is missing its fertilizer and large hoses that seem to be the watering supply. Straight in front of you, against the back wall of the room, you see a terminal that looks like it controls the flower bed. There is also some writing against the wall.",
                new Point(3, 1), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[7] = new Room("Final Mixing Room",
                "You see three tubes to your right and a large vaccine-making machine to your left. As you peer straight on, you can see a large glass door, and through that glass, you can see a spaceship. It seems as if your time here at the Transient research facility is finally coming to an end.",
                new Point(3, -1), 
                new ArrayList<>(), 
                new HashMap<>());
        rooms[8] = new Room("Yard",
                "Your spaceship stands there in the middle of the yard.",
                new Point(3, -2), 
                new ArrayList<>(), 
                new HashMap<>());

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
