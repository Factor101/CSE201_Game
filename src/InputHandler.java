import java.util.Arrays;
import java.util.Scanner;

/**
 * Class to handle user input and commands.
 *
 * @version 1.0
 */
public class InputHandler
{
    private static final Scanner stdin = new Scanner(System.in); // stdin scanner
    private static CommandHandler commandHandler; // command handler instance

    /**
     * Registers a command handler.
     *
     * @param commandHandler CommandHandler instance to register
     */
    public static void registerCommandHandler(final CommandHandler commandHandler)
    {
        InputHandler.commandHandler = commandHandler;
    }

    /**
     * Parses and executes a command.
     *
     * @param command Command to parse and execute
     * @return Result of the command
     * @throws IllegalStateException if InputHandler.commandHandler is not registered
     */
    public static CommandResult<?> parseAndExecute(final String command)
    {
        if(InputHandler.commandHandler == null)
        {
            throw new IllegalStateException("Command handler not registered");
        }

        final String[] tokens = command.split(" +"); // split command by spaces
        return commandHandler.callCommand(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length)); // call command
    }

    /**
     * Prompts the user for a command.
     *
     * @param prompText Text to prompt the user with
     * @return User entered input
     * @throws IllegalStateException if InputHandler.commandHandler is not registered
     */
    public static String promptCommand(final String prompText)
    {
        if(InputHandler.commandHandler == null)
        {
            throw new IllegalStateException("Command handler not registered");
        }

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
