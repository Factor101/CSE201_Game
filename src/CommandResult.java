/**
 * Class: Intro to Software Engineering
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 * Course : CSE 201-C Fall 2024
 * Written: November 3, 2024
 * Purpose: Record class to represent the result of a command.
 *
 * @param result    The result of the command
 * @param message   The message to display to the user
 * @param isSuccess Whether the command was successful
 * @param <T>       The type of the result
 */
public record CommandResult<T>(T result, String message, boolean isSuccess)
{
    /**
     * Static method to create a failed result due to an invalid number of arguments.
     *
     * @param args     Actual args
     * @param expected Number of expected args
     * @param <T>      Type of the result
     * @return A failed result with message indicating args descrepancy
     */
    public static <T> CommandResult<T> failArgs(final String[] args, final int expected)
    {
        return CommandResult.fail(String.format("Invalid number of arguments. Expected: %d Got: %d",
                                                expected,
                                                args.length));
    }

    /**
     * Static method to create a successful without a message.
     *
     * @param result The result of the command
     * @param <T>    Type of the result
     * @return A successful result with a result and no message
     */
    public static <T> CommandResult<T> success(final T result)
    {
        return new CommandResult<T>(result, null, true);
    }

    /**
     * Static method to create a successful result with a message.
     *
     * @param result  The result of the command
     * @param message The result message
     * @param <T>     Type of the result
     * @return A successful result with a result and message
     */
    public static <T> CommandResult<T> success(final T result, final String message)
    {
        return new CommandResult<T>(result, message, true);
    }

    /**
     * Static method to create a failed result with a message.
     *
     * @param message The message indicating failure reason
     * @param <T>     Type of the result
     * @return A failed result with message indicating failure
     */
    public static <T> CommandResult<T> fail(final String message)
    {
        return new CommandResult<T>(null, message, false);
    }

    /**
     * Instance method to get the result value of the command.
     *
     * @return The result value of the command
     * @throws IllegalStateException If the command was unsuccessful
     */
    @Override
    public T result()
    {
        if(!this.isSuccess)
        {
            throw new IllegalStateException(String.format("Command failed with message: '%s'", this.message));
        }

        return this.result;
    }
}
