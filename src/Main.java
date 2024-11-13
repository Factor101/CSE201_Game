/**
 * Class: Intro to Software Engineering
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 * Course : CSE 201-C Fall 2024
 * Written: November 3, 2024
 * Purpose: Main class for the game.
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

        // main event loop
        // flag to control the main event loop
        boolean isRunning = true;
        while(isRunning)
        {
            // prompt, parse, and execute the command
            // user will enter a command + args (where applicable)
            final String userInput = InputHandler.promptCommand("Enter a command:");
            final CommandResult<?> result = InputHandler.parseAndExecute(userInput);

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
