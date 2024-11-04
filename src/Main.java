/**
 * Main class for the game.
 * Contains the main event loop.
 *
 * @version 1.0
 */
public class Main
{

    public static void main(String[] args)
    {
        // temporary line for demo
        Player.setCurrentRoom(new Room("Demo_Room", "The room smells of Lorem ipsum dolor sit amet"));

        // register the command handler
        InputHandler.registerCommandHandler(new CommandHandler());

        // main event loop
        // flag to control the main event loop
        boolean isRunning = true;
        while(isRunning)
        {
            // prompt, parse, and execute the command
            final String command = InputHandler.promptCommand("Enter a command:");
            final CommandResult<?> result = InputHandler.parseAndExecute(command);

            // output the result
            if(result.isSuccess())
            {
                final String message = result.message();
                if(message != null) // do not output Void type commands
                {
                    System.out.println(message);
                }
            }
            else
            {
                System.out.println("You spoke nonesense: " + result.message());
            }
        }
    }
}
