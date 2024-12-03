package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Class: Intro to Software Engineering
 * Course : CSE 201-C Fall 2024
 * Written: November 30, 2024.
 * Purpose: Utility class to represent the world map and state.
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad
 * Martin, Rafael Santell-Colon
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
        for(int i = 0; i < World.MAX_HEIGHT_LENGTH; ++i)
        {
            World.rooms.add(new ArrayList<Room>(Collections.nCopies(World.MAX_HEIGHT_LENGTH, null)));
        }

        World.addRoom(new Room("Gas Room",
                               "As soon as you walk in it looks as if smoke has filled up the entire room. Through the gas mask you spot a broken pipe to your right, a vault to your left, and a large chemistry desk in front of you with a poster of the periodic table.",
                               new int[]{ 1, 2 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("Broken Pipe", "On the left wall of the room a pipe appears to be busted open", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("pipe", args -> {
                                           return CommandResult.success(null,
                                                                        "As soon as you walk in it looks as if smoke has filled up the entire room. Through the gas mask you spot a broken pipe to your right, a vault to your left, and a large chemistry desk in front of you with a poster of the periodic table.\r\n" + //
                                                                                                                                                        "");
                                       }));
                                   }}));

                                   add(new RoomFeature("Periodic table Poster", "it looks as if the Periodic table poster has been marked up with some drawings", new ArrayList<Command<?>>()
                                   {
                                       {
                                           add(new Command<Void>("PeriodicTable", args -> {
                                               return CommandResult.success(null,
                                               "You notice something a little strange as soon as your eyes meet the color of the periodic table poster. The atomic numbers of each element are circled and an arrow is pointing from top to bottom. Over the noble gasses.\r\n"                                                
                                               );
                                           }));
                                       }
                                   }));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRoom(new Room("Genetic Testing Room",
                               "As you walk in you see a large animal on the ground in front of you glowing bright orange. To your right you see 2 cages. One with a red animal, and another one with a blue animal. To your left you see 2 cages, one with a green animal and the other one busted open. On the back of the wall you see a poster of a greenhouse and a computer terminal.\r\n",
                               new int[]{ 1, 0 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("four cages", "Four cages are present in the room with three of them still containing animals and one busted open", new ArrayList<Command<?>>()
                                   {
                                       {
                                           add(new Command<Void>("cages", args -> {
                                               return CommandResult.success(null,
                                               "As you look at the two cages on your right you can make out name tags on the cages. On top of the cage with the red animal inside you can see a nametage “Zephyrhound”. " +
                                               "On top of the second cage with the blue animal inside you see another nametag that reads “Luminarks”.As you look at the two cages on your left you can make out name tags " +
                                                "on the cages. On top of the cage with the green animal inside you can see a nametage “Shardwalker“. On top of the second cage that is busted open you can see a nametag that read “Mirequills”"
                                               );
                                           }));
                                       }
                                   }));

                                   add(new RoomFeature("Computer terminal", "A terminal on the back wall of the room", new ArrayList<Command<?>>()
                                   {{
                                           add(new Command<Void>("computer", 0, args -> {
                                               if(Player.hasItem("Shears"))
                                               {
                                                   return CommandResult.success(null, "There's nothing more to do here.");
                                               }

                                               final String pass = InputHandler.promptInput("You walk over to the computer terminal and see" + "'PASSWORD: ' with a blinking cursor.");
                                               if(pass.equals("password")) //TODO: PLACEHOLDER PASSWORD
                                               {
                                                   Player.addItem(new Item("Shears", "A pair of shears")); //TODO: PLACEHOLDER
                                                   return CommandResult.success(null, "The screen flashes green for a moment, " +
                                                                                      "before going black. You hear a soft " +
                                                                                      "click, and the computer screen unlatches" +
                                                                                      " to reveal a hidden compartment. Inside," +
                                                                                      " you find a pair of shears.");

                                               }
                                               else
                                               {
                                                   return CommandResult.fail("The screen flashes red for a moment, filling the " +
                                                                             "room with a loud beep. 'INCORRECT' is displayed for a " +
                                                                             "moment, before the screen resets to allow you to try " +
                                                                             "again.");
                                               }
                                           }));
                                   }}));

                                   add(new RoomFeature("Animal on the floor", "", new ArrayList<Command<?>>()
                                   {
                                       {
                                           add(new Command<Void>("cages", args -> {
                                               return CommandResult.success(null,
                                               "As you look at the two cages on your right you can make out name tags on the cages. On top of the cage with the red animal inside you can see a nametage “Zephyrhound”. " +
                                               "On top of the second cage with the blue animal inside you see another nametag that reads “Luminarks”.As you look at the two cages on your left you can make out name tags " +
                                                "on the cages. On top of the cage with the green animal inside you can see a nametage “Shardwalker“. On top of the second cage that is busted open you can see a nametag that read “Mirequills”"
                                               );
                                           }));
                                       }
                                   }));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRoom(new Room("Lab room",
                               "As you look around you see three doors, one to the north, east, and south of the lab room. It appears as if the door to the north leads to a gas bottling room. The door to the south seems to lead to a genetic testing room and the door to the east of you looks to lead to a long corridor. Although both the gas bottling door and genetics testing door are locked the hallway door to the east of you appears to be slightly ajar. You also see a large lab desk with drawings all over, and a poster.",
                               new int[]{ 1, 1 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("Desk", "A desk in the corner of the lab.", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("desk", args -> {
                                    	   Player.getInventory().add(new Item("Gas Mask", "Needed to be able to enter the gas bottling room. Something seems to be broken."));
                                    	   Player.getInventory().add(new Item("Letter", "Welcome to the Transient research facility. I wrote this letter before clicking the time release button on your stasis pod. This horrible disease has mutated me into what I am today and destroyed our planet. I have done all of the work for you to synthesize a cure. First in the gas bottling room vault you have to get (clowth gas), then in the genetic testing room you have to get the fur of a bright orange monster. Finally you will have to mix both ingredients in our mixing room. Synthesize a cure and save the planet. -Dr. Grobu"));
                                           return CommandResult.success(null,
                                                                        "You see an open compartment at the bottom of the desk with a gas mask inside. A letter is sitting on the desk as well. Gas mask and letter added to inventory.\n");
                                       }));
                                   }}));
                                      
                                   add(new RoomFeature("Map", "A map on the wall.", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("map", args -> {
                                           return CommandResult.success(null,
                                                                        "It looks as if this is a map of the pre-virus planet. Apparently, it goes by the name of Mars.\n");
                                       }));
                                   }}));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRoom(new Room("Cryo pod Room",
                               "As you awake from what feels like an extremely long slumber you see a door to the east of you and an alien laying on the ground",
                               new int[]{ 0, 1 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("pipe", args -> {
                                           return CommandResult.success(null,
                                                                        "You examine the broken pipe closely." + "It appears to have been damaged recently," + "with strange claw marks around the edges. " + "The pipe seems to have once carried some kind of " + "coolant for the genetic testing equipment.");
                                       }));
                                   }}));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRoom(new Room("Final Mixing Room",
                               "As you walk inside, you see two tubes to your right and a large vaccine-making machine to your left. As you peer straight on, you can see a large glass door, and through that glass, you can see a spaceship. It seems as if your time here at the Transient research facility is finally coming to an end",
                               new int[]{ 3, 1 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("pipe", args -> {
                                           return CommandResult.success(null,
                                                                        "You examine the broken pipe closely." + "It appears to have been damaged recently," + "with strange claw marks around the edges. " + "The pipe seems to have once carried some kind of " + "coolant for the genetic testing equipment.");
                                       }));
                                   }}));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRoom(new Room("Yard",
                               "As you walk outside you see the door to the spaceship open and it feels like there is only one thing left to do. Get off of this planet.",
                               new int[]{ 3, 0 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("SpaceShip", "A spaceships sits in the middle of the yard", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("SpaceShip", args -> {
                                           return CommandResult.success(null,
                                                                        "As you walk outside you see the door to the spaceship open and it feels like there is only one thing left to do. Get off of this planet");
                                       }));
                                   }}));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRoom(new Room("Hallway Room",
                               "As you go through the door, it looks as if it is just a desolate hallway. There seems to be some marking on the wall to your left, and a picture on the wall to your right. You can also see another door ahead of you which looks heavily fortified. \r\n",
                               new int[]{ 2, 1 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("Markings on the wall", "It looks as if the markings are some type of color code", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("markings", args -> {
                                           return CommandResult.success(null,
                                                                        "As you look onto the wall you can tell these are safety instructions for the genetic testing room. It seems as if there is a color code to the animals which should give you access to the computer terminal in that room. However, the names needed to complete the code are not here. Code below. Bright Orange animal name, characters “1,3,4”. Red animal name, characters “5,6,4”. Blue animal name, Characters “3,4,2” and finally green animal name, characters “6,7,7”. Password should be these characters concatenated together.");
                                       }));
                                   }}));

                                   add(new RoomFeature("Picture", "A pre-virus picture of mars is hanging on the wall", new ArrayList<Command<?>>()
                                   {
                                       {
                                           add(new Command<Void>("picture", args -> {
                                               return CommandResult.success(null,
                                               "This picture is of the planet before the plague. There are advanced cities, flying cars, and what looks to be a second picture of a happy family. Now the only thing on the surface seems to be rubble."
                                               );
                                           }));
                                       }
                                   }));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));


        System.out.println("Rooms initialized");
    }

    public static void initializeDefaultCommands()
    {

    }

    public static void addRooms(Room[] rooms)
    {
        for(final Room room : rooms)
        {
            if(World.addRoom(room) != null)
            {
                throw new IllegalArgumentException("Room already exists at position: " + room.getPosition());
            }
        }
    }

    public static Room addRoom(Room room)
    {
        final int[] pos = room.getPosition();
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

    public static void titleScreen()
    {
        System.out.println("  __  __          _____   _____ ");
        System.out.println(" |  \\/  |   /\\   |  __ \\ / ____|");
        System.out.println(" | \\  / |  /  \\  | |__) | (___  ");
        System.out.println(" | |\\/| | / /\\ \\ |  _  / \\___ \\ ");
        System.out.println(" | |  | |/ ____ \\| | \\ \\ ____) |");
        System.out.println(" |_|  |_/_/    \\_\\_|  \\_\\_____/ ");
        System.out.println("\t  ______  _____  _____          _____  ______ ");
        System.out.println("\t |  ____|/ ____|/ ____|   /\\   |  __ \\|  ____|");
        System.out.println("\t | |__  | (___ | |       /  \\  | |__) | |__   ");
        System.out.println("\t |  __|  \\___ \\| |      / /\\ \\ |  ___/|  __|  ");
        System.out.println("\t | |____ ____) | |____ / ____ \\| |    | |____ ");
        System.out.println("\t |______|_____/ \\_____/_/    \\_\\_|    |______|\n");
    }
}
