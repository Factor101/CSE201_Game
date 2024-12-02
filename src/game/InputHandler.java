package game;

import rooms.Room;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class: Intro to Software Engineering
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 * Course : CSE 201-C Fall 2024
 * Written: November 3, 2024
 * Purpose: Class to handle user input and commands.
 *
 * @version 1.0
 */
public class InputHandler
{
    private static final Scanner stdin = new Scanner(System.in); // stdin scanner

    /**
     * Parses and executes a command.
     *
     * @param command game.Command to parse and execute
     * @return Result of the command
     */
    public static CommandResult<?> parseAndExecute(final String command)
    {
        final String[] tokens = command.split(" +"); // split command by spaces
        return CommandHandler.callCommand(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length)); // call command
    }

    /**
     * Prompts the user for a command.
     *
     * @param prompText Text to prompt the user with
     * @return User entered input
     */
    public static String promptCommand(final String prompText)
    {
        final Room currentRoom = Player.getCurrentRoom(); // get player room
        System.out.printf("You find yourself in %s. %s%n%s\n > ", // print state
                          currentRoom.getName(),
                          currentRoom.getDescription(),
                          prompText);

        final String userInput = stdin.nextLine(); // get user input
        System.out.println(); // print a newline

        return userInput;
    }
}
