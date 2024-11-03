import java.awt.Point;

public class Command<T>
{
    public static interface CommandRun<T>
    {
        T run(String s);
    }

    private String cmdName;

    /**
     * Creates new command
     */
    public Command()
    {
        CommandRun<String> e = (s) -> {
            return s + "A";
        };

        System.out.println(e.run("foo"));
    }


    public Command(String cmdName, CommandRun<T> run)
    {

    }

    /**
     * Command to go with no direction
     *
     * @return message telling player to specify a direction
     */
    public static String go()
    {
        return "Go where?";
    }

    /**
     * Command for going north
     *
     * @return a point value to be added to current room position to determine
     * if the player can move to an new room
     */
    public static Point goNorth()
    {
        return new Point(0, 1);
    }

    /**
     * Command for going east
     *
     * @return a point value to be added to current room position to determine
     * if the player can move to an new room
     */
    public static Point goEast()
    {
        return new Point(1, 0);
    }

    /**
     * Command for going south
     *
     * @return a point value to be added to current room position to determine
     * if the player can move to an new room
     */
    public static Point goSouth()
    {
        return new Point(0, -1);
    }

    /**
     * Command for going west
     *
     * @return a point value to be added to current room position to determine
     * if the player can move to an new room
     */
    public static Point goWest()
    {
        return new Point(-1, 0);
    }

    /**
     * @param cmdName
     * @return
     */
    public static Command resolveCommand(String cmdName)
    {
        return null;
    }

    public String getName()
    {
        return this.cmdName;
    }
}
