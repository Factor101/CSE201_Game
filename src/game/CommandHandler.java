package game;

import java.awt.Point;
import java.util.HashMap;


/**
 * Class: Intro to Software Engineering
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 */
public class CommandHandler
{
    /**
     * HashMap of executable commands.
     * (k, v) -> (command name, command).
     * Default commands are initialized here.
     */
    private static final HashMap<String, Command<?>> commands = new HashMap<>()
    {{
        // Help command
        put("help", new Command<Void>("help", 0, args -> {
            System.out.println("Commands:");
            CommandHandler.commands.forEach((k, v) -> System.out.println(k));
            System.out.println();
            return CommandResult.success(null);
        }));

        // Move command
        put("go", new Command<Point>("go", 1, args -> {
            // cardinal directions as vectors
            Point pt = switch(args[0].toLowerCase())
            {
                case "north" -> new Point(0, 1);
                case "east" -> new Point(1, 0);
                case "south" -> new Point(0, -1);
                case "west" -> new Point(-1, 0);
                default -> null;
            };

            if(pt == null)
            {
                return CommandResult.fail("Invalid direction");
            }



            return CommandResult.success(pt, "You ventured " + args[0]);
        }));

        // Inventory game.Command
        put("inventory", new Command<Void>("inventory", 0, args -> {
            System.out.println("You inventory consists of:");

            for(Item i : Player.getInventory())
            {
                System.out.println(i.getName() + ", ");
            }

            return CommandResult.success(null);
        }));
    }};

    /**
     * Default constructor.
     */
    public CommandHandler()
    {
    }

    /**
     * Constructor to initialize the command handler with a set of commands.
     *
     * @param commands HashMap of commands to initialize the command handler with.
     */
    public CommandHandler(final HashMap<String, Command<?>> commands)
    {
        CommandHandler.commands.putAll(commands);
    }

    /**
     * Registers a command with the command handler.
     *
     * @param cmd game.Command to register.
     * @return true if the command was successfully registered, false otherwise.
     */
    public static boolean registerCommand(final Command<?> cmd)
    {
        return null == CommandHandler.commands.put(cmd.getName(), cmd);
    }

    public static CommandResult<?> callCommand(final String cmdName, final String[] args)
    {
        if(!CommandHandler.commands.containsKey(cmdName))
        {
            return CommandResult.fail(cmdName + " means nothing here.");
        }

        return CommandHandler.commands.get(cmdName)
                                      .exec(args);
    }
}
