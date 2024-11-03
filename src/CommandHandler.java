import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler
{
    private final HashMap<String, Command<?>> commands = new HashMap<>();
    private Room currentRoom = null;

    public CommandHandler()
    {
    }

    public <T> CommandHandler(final HashMap<String, Command<T>> commands)
    {
        this.commands.putAll(commands);
    }

    public <T> boolean registerCommand(final Command<T> cmd)
    {
        return null == this.commands.put(cmd.getName(), cmd);
    }

    public <T> handleCommand(final String cmdName)
    {
        return this.handleCommand(Command.resolveCommand(cmdName));
    }

    public <T> handleCommand(final Command<T> cmd)
    {
        return true;
    }

    public Room setRoom(Room room)
    {
        this.currentRoom = room;
        return this.currentRoom;
    }
}
