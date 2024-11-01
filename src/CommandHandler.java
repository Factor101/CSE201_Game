package src;

import java.util.ArrayList;

public class CommandHandler
{
    private final ArrayList<Command> defaultCommands = new ArrayList<>();
    private Room currentRoom = null;

    public CommandHandler()
    {
    }

    public CommandHandler(ArrayList<Command> defaultCommands)
    {
        this.defaultCommands.addAll(defaultCommands);
    }

    public boolean handleCommand(final String cmdName)
    {
        return this.handleCommand(Command.resolveCommand(cmdName));
    }

    public boolean handleCommand(final Command cmd)
    {
        return true;
    }

    public Room setRoom(Room room)
    {
        this.currentRoom = room;
        return this.currentRoom;
    }
}
