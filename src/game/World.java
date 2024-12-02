package game;

import java.util.ArrayList;

/**
 * Class: Intro to Software Engineering
 * Course : CSE 201-C Fall 2024
 * Written: November 30, 2024.
 * Purpose: Utility class to represent the world map and state.
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad Martin, Rafael Santell-Colon
 * @version 1.0
 */
public class World
{
    private final static int MAX_HEIGHT_LENGTH = 10;
    private final static ArrayList<ArrayList<Room>> rooms = new ArrayList<ArrayList<Room>>(MAX_HEIGHT_LENGTH);

    private World()
    {
    }

    public static void init()
    {
        World.initializeRooms();
        World.initializeDefaultCommands();
    }

    public static void initializeRooms()
    {
        for(int i = 0; i < MAX_HEIGHT_LENGTH; ++i)
        {
            World.rooms.add(new ArrayList<Room>(MAX_HEIGHT_LENGTH));
        }
    }

    public static void initializeDefaultCommands()
    {

    }

    public static boolean addRooms(ArrayList<Room> rooms)
    {
        for(final Room room : rooms)
        {
            if(World.addRoom(room) == null)
            {
                return false;
            }
        }

        return true;
    }

    public static Room addRoom(Room room)
    {
        final int[] pos = room.getPosition();
        if(World.rooms.get(pos[0])
                      .get(pos[1]) != null)
        {
            return null;
        }

        return World.rooms.get(pos[0])
                          .set(pos[1], room);
    }

    public static Room getRoomAt(int[] pos)
    {
        return World.rooms.get(pos[0])
                          .get(pos[1]);
    }

    public static ArrayList<ArrayList<Room>> getRooms()
    {
        return World.rooms;
    }

    public static Room getRoom(int[] point)
    {
        return null;
    }
}
