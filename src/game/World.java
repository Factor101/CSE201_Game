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
 *         Martin, Rafael Santell-Colon
 * @version 1.0
 */
public class World {
    private final static int MAX_HEIGHT_LENGTH = 10;
    private final static ArrayList<ArrayList<Room>> rooms = new ArrayList<ArrayList<Room>>(MAX_HEIGHT_LENGTH);

    private World() {
    }

    public static void init() {
        World.initializeRooms();
        World.initializeDefaultCommands();
    }

    public static void initializeRooms() {
        for (int i = 0; i < World.MAX_HEIGHT_LENGTH; ++i) {
            World.rooms.add(new ArrayList<Room>(Collections.nCopies(World.MAX_HEIGHT_LENGTH, null)));
        }

        World.addRoom(new Room("Gas Room",
                "As soon as you walk in it looks as if smoke has filled up the entire room. Through the gas mask you spot a broken pipe to your right, a vault to your left, and a large chemistry desk in front of you with a poster of the periodic table.",
                new int[] { 1, 2 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));

        World.addRoom(new Room("Genetic Testing Room",
                "As you walk in you see a large animal on the ground in front of you glowing bright orange. To your right you see 2 cages. One with a red animal, and another one with a blue animal. To your left you see 2 cages, one with a green animal and the other one busted open. On the back of the wall you see a poster of a greenhouse and a computer terminal.\r\n" + //
                        ,
                new int[] { 1, 0 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));
        
        World.addRoom(new Room("Lab room",
                "As you look around you see three doors, one to the north, east and one to the south of the lab room. It appears as if the door to the north leads to a gas bottling room. The door to the south seems to lead to a genetic testing room and the door to the east of you looks to lead to a long corridor. Although both the gas bottling door and genetics testing door are locked the hallway door to the east of you appears to be slightly ajar. You also see a large lab desk with drawings all over, and a poster",
                new int[] { 1, 1 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));

        World.addRoom(new Room("Cryo pod Room",
                "As you awake from what feels like an extremely long slumber you see a door to the east of you and an alien laying on the ground",
                new int[] { 0, 1 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));
        
        World.addRoom(new Room("Final Mixing Room",
                "As you walk inside, you see two tubes to your right and a large vaccine-making machine to your left. As you peer straight on, you can see a large glass door, and through that glass, you can see a spaceship. It seems as if your time here at the Transient research facility is finally coming to an end",
                new int[] { 3, 1 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));

        World.addRoom(new Room("Yard",
                "As you walk outside you see the door to the spaceship open and it feels like there is only one thing left to do. Get off of this planet.",
                new int[] { 3, 0 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));
        
        World.addRoom(new Room("Hallway Room",
                "As you go through the door, it looks as if it is just a desolate hallway. There seems to be some marking on the wall to your left, and a picture on the wall to your right. You can also see another door ahead of you which looks heavily fortified. \r\n"
                ,
                new int[] { 2, 1 },
                new ArrayList<Item>(),
                new ArrayList<RoomFeature>() {
                    {
                        add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>() {
                            {
                                add(new Command<Void>("pipe", args -> {
                                    return CommandResult.success(null,
                                            "You examine the broken pipe closely." +
                                                    "It appears to have been damaged recently," +
                                                    "with strange claw marks around the edges. " +
                                                    "The pipe seems to have once carried some kind of " +
                                                    "coolant for the genetic testing equipment.");
                                }));
                            }
                        }));
                    }
                },
                new HashMap<>(Collections.emptyMap()),
                null));
        

        System.out.println("Rooms initialized");
    }

    public static void initializeDefaultCommands() {

    }

    public static void addRooms(Room[] rooms) {
        for (final Room room : rooms) {
            if (World.addRoom(room) != null) {
                throw new IllegalArgumentException("Room already exists at position: " + room.getPosition());
            }
        }
    }

    public static Room addRoom(Room room) {
        final int[] pos = room.getPosition();
        return World.rooms.get(pos[0])
                .set(pos[1], room);
    }

    public static Room getRoomAt(int[] pos) {
        if (pos[0] < 0 || pos[0] >= MAX_HEIGHT_LENGTH || pos[1] < 0 || pos[1] >= MAX_HEIGHT_LENGTH) {
            return null;
        }

        return World.rooms.get(pos[0])
                .get(pos[1]);
    }

    public static ArrayList<ArrayList<Room>> getRooms() {
        return World.rooms;
    }

    public static void titleScreen() {
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
