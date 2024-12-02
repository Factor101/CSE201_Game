package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        World.addRooms(new Room[] {
                new Room("Cyro Pod Room",
                         "The room around you is eerily quiet. A dead alien sits in the opposite side of the room from the broken pod from which you awoke.",
                         new Point(0, 1),
                         new ArrayList<Item>(java.util.List.of(new Item("Keycard",
                                                                        "Keycard is the personal property of Dr. Grobu, resident and chief of the transient research facility. You can use this to unlock the lab entrance."))),
                         new HashMap<>(),
                         null),
                new Room("Lab",
                         "The room appears to be some sort of lab. There sits a desk in one corner, with some scrawlings along the opposite wall.",
                         new Point(1, 1),
                         new ArrayList<>(java.util.List.of(new Item("Gas Mask",
                                                                    "Needed to be able to enter the gas bottling room. Something seems to be broken"),
                                                           new Item("Letter",
                                                                    "Welcome to the Transient research facility. I wrote this letter before clicking the time release button on your stasis pod. This horrible disease has mutated me into what I am today and destroyed our planet. I have done all of the work for you to synthesize a cure. First in the gas bottling room vault you have to get (clowth gas), then in the genetic testing room you have to get the fur of a bright orange monster, and then get a flower bud from the greenhouse room. Finally you will have to mix all three ingredients in our mixing room. Synthesize a cure and save the planet.. -Dr. Grobu\r\n"))),
                         new HashMap<>(),
                         null),
                new Room("Gas Room",
                         "The room has a lingering odor about it. There seem to be various things related to chemicals in here.",
                         new Point(1, 2),
                         new ArrayList<>(java.util.List.of(new Item("Tranq Gun",
                                                                    "Needed to enter the genetic testing room in case of emergency."),
                                                           new Item("Clowth",
                                                                    "Clowth gas is gathered through the manipulation of multiple different elements. It can help heal cells at the cellular level."))),
                         new HashMap<>(),
                         null),
                new Room("Genetic Testing Room",
                         "The room contains various cages, and some important looking technology on the far wall.",
                         new Point(1, 0),
                         new ArrayList<>(List.of(new Item("Mirequills Fur",
                                                          "The bright orange fur glows as you stare at it. The result of multiple rounds of radiation testing and gene editing.\r\n"),
                                                 new Item("Sheers",
                                                          "Used to sheer the fur of different animals kept inside the genetic testing facility"))),
                         new HashMap<>(),
                         null),
                new Room("Hallway",
                         "The hallway contains a strange pattern on the wall, and a window which gives you a glimpse into the world outside.",
                         new Point(2, 1),
                         new ArrayList<>(),
                         new HashMap<>(),
                         null),
                new Room("Final Mixing Room",
                         "You see three tubes to your right and a large vaccine-making machine to your left. As you peer straight on, you can see a large glass door, and through that glass, you can see a spaceship. It seems as if your time here at the Transient research facility is finally coming to an end.",
                         new Point(3, 1),
                         new ArrayList<>(),
                         new HashMap<>(),
                         null),
                new Room("Yard",
                         "Your spaceship stands there in the middle of the yard.",
                         new Point(
                                 3,
                                 0),
                         new ArrayList<>(),
                         new HashMap<>(),
                         null) });
    }

    public static void initializeDefaultCommands()
    {

    }

    public static boolean addRooms(Room[] rooms)
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
        if(pos[0] < 0 || pos[0] >= MAX_HEIGHT_LENGTH || pos[1] < 0 || pos[1] >= MAX_HEIGHT_LENGTH)
        {
            return null;
        }

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
