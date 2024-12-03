package game;

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
            System.out.println("Global commands:");
            CommandHandler.commands.forEach((k, v) -> System.out.println(k));
            System.out.println("Contextual commands:");
            Player.getCurrentRoom().getRoomCommands().forEach((k, v) -> System.out.println(k));
            System.out.println();

            return CommandResult.success(null);
        }));

        // Move command
        put("go", new Command<int[]>("go", 1, args -> {
            // cardinal directions as vectors
            int[] pt = switch(args[0].toLowerCase())
            {
                case "north" -> new int[]{ 0, 1 };
                case "east" -> new int[]{ 1, 0 };
                case "south" -> new int[]{ 0, -1 };
                case "west" -> new int[]{ -1, 0 };
                default -> null;
            };

            if(pt == null)
            {
                return CommandResult.fail("Invalid direction");
            }

            int[] curPt = Player.getPosition();
            pt[0] += curPt[0];
            pt[1] += curPt[1];

            final Room room = World.getRoomAt(pt);
            if(room == null)
            {
                return CommandResult.fail("You can't go that way.");
            }

            // check entry conditions
            if(!room.checkEntry())
            {
                return CommandResult.fail("You can't enter this room.");
            }

            Player.setPosition(pt);
            return CommandResult.success(pt, "You ventured " + args[0]);
        }));

        // Quit command
        put("quit", new Command<Void>("quit", 0, args -> {
        	System.out.println("Quitting game...");

        	System.exit(0);

        	return CommandResult.success(null);
        }));

        // Yell command
        put("yell", new Command<Void>("yell", 0, args -> {
        	System.out.println("You yell for help...\nYou hear nothing in response. You must help yourself.");
        	return CommandResult.success(null);
        }));

        // Investigate command
        put("investigate", new Command<Void>("investigate", 0, args -> {
            System.out.println("You looked around. A few things caught your eye:");
            final Room room = Player.getCurrentRoom();
            for(RoomFeature e : room.getFeatures())
            {
                // print feature name and description
                System.out.printf("\t%s: %s%n", e.getName(), e.getDescription());

                // populate contextual commands of Room, only once
                if(!e.isInteracted)
                {
                    e.isInteracted = true;
                    e.getCommands().forEach(cmd -> room.addCommand(cmd.getName(), cmd));
                }
            }

            return CommandResult.success(null);
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
        // check if command exists in default or contextual commands
        Command<?> cmd = CommandHandler.commands.get(cmdName);
        if(cmd == null)
        {
            cmd = Player.getCurrentRoom().getRoomCommands().get(cmdName);
        }

        if(cmd == null)
        {
            return CommandResult.fail(cmdName + " means nothing here.");
        }

        return cmd.exec(args);
    }
}
