package game;

import java.util.function.Function;

/**
 * Class: Intro to Software Engineering
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 * Course : CSE 201-C Fall 2024
 * Written: November 3, 2024
 * Purpose: Represents a command that can be executed by the user.
 *
 * @param <T> the type of the result of the command
 * @version 1.0
 */
public class Command<T>
{
    private final String cmdName; // Name of the command
    private final int expectedArgc; // Expected number of arguments TODO: add support argc in range
    private final Function<String[], CommandResult<T>> callback; // Callback function of commmand

    /**
     * Constructor to create a command with a name, expected number of arguments, and callback function.
     *
     * @param cmdName      Name of the command
     * @param expectedArgc Expected number of arguments
     * @param callback     Callback function of the command
     */
    public Command(String cmdName,
                   int expectedArgc,
                   Function<String[], CommandResult<T>> callback)
    {
        this.cmdName = cmdName;
        this.expectedArgc = expectedArgc;
        this.callback = callback;
    }

    /**
     * Constructor to create a command with a name and callback function.
     *
     * @param cmdName  Name of the command
     * @param callback Callback function of the command
     */
    public Command(String cmdName,
                   Function<String[], CommandResult<T>> callback)
    {
        this.cmdName = cmdName;
        this.expectedArgc = 0;
        this.callback = callback;
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args Arguments to pass to the command
     * @return Result of the command
     */
    public CommandResult<T> exec(String[] args)
    {
        return args.length == this.expectedArgc ? this.callback.apply(args)
                                                : CommandResult.failArgs(args, this.expectedArgc);
    }

    /**
     * Executes the command with no arguments.
     *
     * @return Result of the command
     */
    public CommandResult<T> exec()
    {
        return this.callback.apply(new String[0]);
    }

    /**
     * Returns the name of the command.
     *
     * @return Name of the command
     */
    public String getName()
    {
        return this.cmdName;
    }
}
