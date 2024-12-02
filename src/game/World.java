package game;

import rooms.Room;

import java.awt.*;
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
    private final static ArrayList<ArrayList<Room>> rooms = new ArrayList<>();

    public World()
    {}

    public static void initializeRooms()
    {
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

    public static Room getRoom(Point point)
    {
        return null;
    }
}
