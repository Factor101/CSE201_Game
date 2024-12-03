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
        for(int i = 0; i < World.MAX_HEIGHT_LENGTH; ++i)
        {
            World.rooms.add(new ArrayList<Room>(Collections.nCopies(World.MAX_HEIGHT_LENGTH, null)));
        }

        World.addRoom(new Room("Gas Room",
                               "The room has a lingering odor about it. There seem to be various things related to chemicals in here.",
                               new int[]{ 1, 2 },
                               new ArrayList<Item>(),
                               new ArrayList<RoomFeature>()
                               {{
                                   add(new RoomFeature("Broken Pipe", "A broken pipe desc//TODO", new ArrayList<Command<?>>()
                                   {{
                                       add(new Command<Void>("pipe", args -> {
                                           return CommandResult.success(null,
                                                                        "You examine the broken pipe closely." +
                                                                        "It appears to have been damaged recently," +
                                                                        "with strange claw marks around the edges. " +
                                                                        "The pipe seems to have once carried some kind of " +
                                                                        "coolant for the genetic testing equipment.");
                                       }));
                                   }}));
                               }},
                               new HashMap<>(Collections.emptyMap()),
                               null));

        World.addRooms(new Room[]{ new Room("Cyro Pod Room",
                                            "The room around you is eerily quiet. A dead alien sits in the opposite side of the room from the broken pod from which you awoke.",
                                            new Point(0, 1),
                                            new ArrayList<>(),
                                            new HashMap<String, Command<?>>()
                                            {{
                                                put("investigate alien", new Command<Void>("investigate alien", args -> {
                                                    if(!Player.getCurrentRoom()
                                                              .getRoomCommands()
                                                              .containsKey("alien_investigated"))
                                                    {
                                                        Player.getCurrentRoom()
                                                              .addCommand("alien_investigated",
                                                                          new Command<Void>("alien_investigated",
                                                                                            a -> CommandResult.success(null,
                                                                                                                       "")));
                                                        if(Player.addItem(new Item("Keycard",
                                                                                   "Keycard is the personal property of Dr. Grobu, resident and chief of the transient research facility. You can use this to unlock the lab entrance.")))
                                                        {
                                                            return CommandResult.success(null,
                                                                                         "You approach the dead alien. Upon closer inspection, you notice it's Dr. Grobu. His skin has turned a sickly green color, and his body appears to have mutated significantly. This must be the effects of the disease he mentioned in his letter. You find a keycard on his body and add it to your inventory.");
                                                        }
                                                        return CommandResult.fail(
                                                                "You found Dr. Grobu's keycard but couldn't pick it up. Your inventory might be full.");
                                                    }
                                                    return CommandResult.success(null,
                                                                                 "You approach the dead alien. Upon closer inspection, you notice it's Dr. Grobu. His skin has turned a sickly green color, and his body appears to have mutated significantly. This must be the effects of the disease he mentioned in his letter.");
                                                }));
                                            }},
                                            null), new Room("Lab",
                                                            "The room appears to be some sort of lab. There sits a desk in one corner, with some scrawlings along the opposite wall.",
                                                            new Point(1, 1),
                                                            new ArrayList<>(),
                                                            new HashMap<String, Command<?>>()
                                                            {{
                                                                put("investigate desk",
                                                                    new Command<Void>("investigate desk", args -> {
                                                                        if(Player.addItem(new Item("Gas Mask",
                                                                                                   "Needed to be able to enter the gas bottling room. Something seems to be broken")))
                                                                        {
                                                                            if(Player.addItem(new Item("Letter",
                                                                                                       "Welcome to the Transient research facility. I wrote this letter before clicking the time release button on your stasis pod. This horrible disease has mutated me into what I am today and destroyed our planet. I have done all of the work for you to synthesize a cure. First in the gas bottling room vault you have to get (clowth gas), then in the genetic testing room you have to get the fur of a bright orange monster, and then get a flower bud from the greenhouse room. Finally you will have to mix all three ingredients in our mixing room. Synthesize a cure and save the planet.. -Dr. Grobu\r\n")))
                                                                            {
                                                                                return CommandResult.success(null,
                                                                                                             "You find a Gas Mask and a Letter on the desk. You've added both items to your inventory.");
                                                                            }
                                                                            return CommandResult.fail(
                                                                                    "Could not pick up the Letter. Your inventory might be full.");
                                                                        }
                                                                        return CommandResult.fail(
                                                                                "Could not pick up the Gas Mask. Your inventory might be full.");
                                                                    }));

                                                                put("investigate map",
                                                                    new Command<Void>("investigate map",
                                                                                      args -> CommandResult.success(null,
                                                                                                                    "On the wall, you find a detailed map of the facility. It shows the layout of several rooms: the Cryo Pod Room to the west, the Gas Room to the north, the Genetic Testing Room to the south, and a hallway leading east to what appears to be a mixing room and yard.")));
                                                            }},
                                                            null), new Room("Gas Room",
                                                                            "The room has a lingering odor about it. There seem to be various things related to chemicals in here.",
                                                                            new Point(1, 2),
                                                                            new ArrayList<>(java.util.List.of(new Item("Tranq Gun",
                                                                                                                       "Needed to enter the genetic testing room in case of emergency."),
                                                                                                              new Item("Clowth",
                                                                                                                       "Clowth gas is gathered through the manipulation of multiple different elements. It can help heal cells at the cellular level."))),
                                                                            new HashMap<String, Command<?>>()
                                                                            {{
                                                                                put("investigate broken pipe",
                                                                                    new Command<Void>("investigate broken pipe",
                                                                                                      args -> CommandResult.success(
                                                                                                              null,
                                                                                                              "You examine the broken pipe closely. It appears to have been damaged recently, with strange claw marks around the edges. The pipe seems to have once carried some kind of coolant for the genetic testing equipment.")));

                                                                                put("investigate vault",
                                                                                    new Command<Void>("investigate vault",
                                                                                                      args -> {
                                                                                                          // Add the combination input command after investigating vault
                                                                                                          Player.getCurrentRoom()
                                                                                                                .addCommand(
                                                                                                                        "put in combo",
                                                                                                                        new Command<String>(
                                                                                                                                "put in combo",
                                                                                                                                comboArgs -> {
                                                                                                                                    if(!Player.getCurrentRoom()
                                                                                                                                              .getRoomCommands()
                                                                                                                                              .containsKey(
                                                                                                                                                      "combo_attempted"))
                                                                                                                                    {
                                                                                                                                        if(comboArgs.length < 1)
                                                                                                                                        {
                                                                                                                                            return CommandResult.fail(
                                                                                                                                                    "Please enter the combination in the format: put in combo 23-45-89");
                                                                                                                                        }

                                                                                                                                        String combo = comboArgs[0].trim();
                                                                                                                                        if(combo.equals(
                                                                                                                                                "23-45-89"))
                                                                                                                                        {
                                                                                                                                            Player.getCurrentRoom()
                                                                                                                                                  .addCommand(
                                                                                                                                                          "combo_attempted",
                                                                                                                                                          new Command<Void>(
                                                                                                                                                                  "combo_attempted",
                                                                                                                                                                  a -> CommandResult.success(
                                                                                                                                                                          null,
                                                                                                                                                                          "")));
                                                                                                                                            return CommandResult.success(
                                                                                                                                                    null,
                                                                                                                                                    "You input the combination '23-45-89'. The vault door clicks and slowly swings open, revealing the secure storage area inside. You can now access the Clowth gas.");
                                                                                                                                        }
                                                                                                                                        return CommandResult.fail(
                                                                                                                                                "Incorrect combination. The keypad beeps in rejection.");
                                                                                                                                    }
                                                                                                                                    return CommandResult.fail(
                                                                                                                                            "You've already unlocked the vault.");
                                                                                                                                }));
                                                                                                          return CommandResult.success(
                                                                                                                  null,
                                                                                                                  "You approach the vault door. It's a heavy-duty security door with a digital keypad. There's a small terminal next to it that might have some useful information.");
                                                                                                      }));

                                                                                put("investigate poster",
                                                                                    new Command<Void>("investigate poster",
                                                                                                      args -> CommandResult.success(
                                                                                                              null,
                                                                                                              "A faded safety poster hangs on the wall. It details proper handling procedures for the genetic specimens. In the corner, someone has scribbled what looks like a partial sequence of numbers: '23-??-89'. The rest is too smudged to read.")));
                                                                            }},
                                                                            null), new Room("Genetic Testing Room",
                                                                                            "The room contains various cages, and some important looking technology on the far wall.",
                                                                                            new Point(1, 0),
                                                                                            new ArrayList<>(List.of(new Item(
                                                                                                    "Mirequills Fur",
                                                                                                    "The bright orange fur glows as you stare at it. The result of multiple rounds of radiation testing and gene editing.\r\n"))),
                                                                                            new HashMap<String, Command<?>>()
                                                                                            {{
                                                                                                put("investigate cages on the right",
                                                                                                    new Command<Void>(
                                                                                                            "investigate cages on the right",
                                                                                                            args -> CommandResult.success(
                                                                                                                    null,
                                                                                                                    "You examine the cages on the right side of the room. They appear to be reinforced with thick metal bars. Inside, you can see signs of recent occupancy, but the creatures seem to have escaped.")));

                                                                                                put("investigate cages on the left",
                                                                                                    new Command<Void>(
                                                                                                            "investigate cages on the left",
                                                                                                            args -> CommandResult.success(
                                                                                                                    null,
                                                                                                                    "The cages on the left contain various genetic experiments. Most concerning are the claw marks that match those you've seen elsewhere in the facility. One cage door hangs open, its lock completely destroyed.")));

                                                                                                put("investigate computer terminal",
                                                                                                    new Command<Void>(
                                                                                                            "investigate computer terminal",
                                                                                                            args -> {
                                                                                                                // Add the password command after investigating terminal
                                                                                                                Player.getCurrentRoom()
                                                                                                                      .addCommand(
                                                                                                                              "put in password",
                                                                                                                              new Command<String>(
                                                                                                                                      "put in password",
                                                                                                                                      passwordArgs -> {
                                                                                                                                          if(!Player.getCurrentRoom()
                                                                                                                                                    .getRoomCommands()
                                                                                                                                                    .containsKey(
                                                                                                                                                            "password_attempted"))
                                                                                                                                          {
                                                                                                                                              if(passwordArgs.length < 1)
                                                                                                                                              {
                                                                                                                                                  return CommandResult.fail(
                                                                                                                                                          "Please enter a password after the command. Example: put in password mirequills");
                                                                                                                                              }

                                                                                                                                              String password = passwordArgs[0].toLowerCase();
                                                                                                                                              if(password.equals(
                                                                                                                                                      "mirequills"))
                                                                                                                                              {
                                                                                                                                                  Player.getCurrentRoom()
                                                                                                                                                        .addCommand(
                                                                                                                                                                "password_attempted",
                                                                                                                                                                new Command<Void>(
                                                                                                                                                                        "password_attempted",
                                                                                                                                                                        a -> CommandResult.success(
                                                                                                                                                                                null,
                                                                                                                                                                                "")));
                                                                                                                                                  if(Player.addItem(
                                                                                                                                                          new Item(
                                                                                                                                                                  "Sheers",
                                                                                                                                                                  "Used to sheer the fur of different animals kept inside the genetic testing facility")))
                                                                                                                                                  {
                                                                                                                                                      return CommandResult.success(
                                                                                                                                                              null,
                                                                                                                                                              "The screen flashes green and a nearby drawer slides open, revealing a pair of sheers. You've added the sheers to your inventory.");
                                                                                                                                                  }
                                                                                                                                                  return CommandResult.fail(
                                                                                                                                                          "Found the sheers but couldn't pick them up. Your inventory might be full.");
                                                                                                                                              }
                                                                                                                                              return CommandResult.fail(
                                                                                                                                                      "Incorrect password. The terminal beeps in rejection.");
                                                                                                                                          }
                                                                                                                                          return CommandResult.fail(
                                                                                                                                                  "You've already accessed the terminal and retrieved the sheers.");
                                                                                                                                      }));
                                                                                                                return CommandResult.success(
                                                                                                                        null,
                                                                                                                        "You approach the computer terminal. The screen displays a login prompt. There's a sticky note nearby with what appears to be a password hint: 'What's orange and deadly? (lowercase)'");
                                                                                                            }));

                                                                                                put("investigate animal on the floor",
                                                                                                    new Command<Void>(
                                                                                                            "investigate animal on the floor",
                                                                                                            args -> CommandResult.success(
                                                                                                                    null,
                                                                                                                    "A strange creature lies motionless on the floor. Its bright orange fur seems to glow faintly. This must be one of the Mirequills mentioned in the terminal. Its mutations are severe, but its fur looks useful for the cure.")));
                                                                                            }},
                                                                                            null), new Room("Hallway",
                                                                                                            "The hallway contains a strange pattern on the wall, and a window which gives you a glimpse into the world outside.",
                                                                                                            new Point(2, 1),
                                                                                                            new ArrayList<>(),
                                                                                                            new HashMap<>(),
                                                                                                            null), new Room(
                "Final Mixing Room",
                "You see three tubes to your right and a large vaccine-making machine to your left. As you peer straight on, you can see a large glass door, and through that glass, you can see a spaceship. It seems as if your time here at the Transient research facility is finally coming to an end.",
                new Point(3, 1),
                new ArrayList<>(),
                new HashMap<String, Command<?>>()
                {{
                    put("investigate tube 1", new Command<Void>("investigate tube 1", args -> {
                        Player.getCurrentRoom()
                              .addCommand("put in tube 1", new Command<String>("put in tube 1", tubeArgs -> {
                                  if(!Player.getCurrentRoom()
                                            .getRoomCommands()
                                            .containsKey("tube1_filled"))
                                  {
                                      if(tubeArgs.length < 1)
                                      {
                                          return CommandResult.fail(
                                                  "Please specify what to put in tube 1. Example: put in tube 1 Clowth");
                                      }
                                      String item = tubeArgs[0].trim();
                                      if(item.equalsIgnoreCase("Clowth"))
                                      {
                                          Player.getCurrentRoom()
                                                .addCommand("tube1_filled",
                                                            new Command<Void>("tube1_filled",
                                                                              a -> CommandResult.success(null, "")));
                                          return CommandResult.success(null,
                                                                       "You place the Clowth gas into tube 1. The tube begins to glow with a soft blue light.");
                                      }
                                      return CommandResult.fail("That item doesn't belong in this tube.");
                                  }
                                  return CommandResult.fail("Tube 1 already contains the Clowth gas.");
                              }));
                        return CommandResult.success(null,
                                                     "You examine tube 1. It appears to be designed for gaseous substances.");
                    }));

                    put("investigate tube 2", new Command<Void>("investigate tube 2", args -> {
                        Player.getCurrentRoom()
                              .addCommand("put in tube 2", new Command<String>("put in tube 2", tubeArgs -> {
                                  if(!Player.getCurrentRoom()
                                            .getRoomCommands()
                                            .containsKey("tube2_filled"))
                                  {
                                      if(tubeArgs.length < 1)
                                      {
                                          return CommandResult.fail(
                                                  "Please specify what to put in tube 2. Example: put in tube 2 Mirequills Fur");
                                      }
                                      String item = String.join(" ", tubeArgs)
                                                          .trim();
                                      if(item.equalsIgnoreCase("Mirequills Fur"))
                                      {
                                          Player.getCurrentRoom()
                                                .addCommand("tube2_filled",
                                                            new Command<Void>("tube2_filled",
                                                                              a -> CommandResult.success(null, "")));
                                          return CommandResult.success(null,
                                                                       "You place the Mirequills Fur into tube 2. The tube begins to pulse with an orange glow.");
                                      }
                                      return CommandResult.fail("That item doesn't belong in this tube.");
                                  }
                                  return CommandResult.fail("Tube 2 already contains the Mirequills Fur.");
                              }));
                        return CommandResult.success(null, "You examine tube 2. It appears to be designed for solid materials.");
                    }));

                    put("investigate vaccine maker", new Command<Void>("investigate vaccine maker", args -> {
                        if(Player.getCurrentRoom()
                                 .getRoomCommands()
                                 .containsKey("tube1_filled") && Player.getCurrentRoom()
                                                                       .getRoomCommands()
                                                                       .containsKey("tube2_filled"))
                        {
                            Player.getCurrentRoom()
                                  .addCommand("activate machine", new Command<String>("activate machine", passwordArgs -> {
                                      if(!Player.getCurrentRoom()
                                                .getRoomCommands()
                                                .containsKey("machine_activated"))
                                      {
                                          if(passwordArgs.length < 1)
                                          {
                                              return CommandResult.fail(
                                                      "Please enter the activation code. Example: activate machine CURE2024");
                                          }
                                          String password = passwordArgs[0].toUpperCase();
                                          if(password.equals("CURE2024"))
                                          {
                                              Player.getCurrentRoom()
                                                    .addCommand("machine_activated",
                                                                new Command<Void>("machine_activated",
                                                                                  a -> CommandResult.success(null, "")));
                                              if(Player.addItem(new Item("Cure",
                                                                         "A glowing vial containing the cure for the mutation disease. This should save the planet.")))
                                              {
                                                  return CommandResult.success(null,
                                                                               "The machine whirs to life, combining the ingredients. After a few moments, a small vial containing a glowing liquid emerges. You've created the cure!");
                                              }
                                              return CommandResult.fail(
                                                      "Created the cure but couldn't pick it up. Your inventory might be full.");
                                          }
                                          return CommandResult.fail("Incorrect activation code. The machine remains inactive.");
                                      }
                                      return CommandResult.fail("You've already created the cure.");
                                  }));
                            return CommandResult.success(null,
                                                         "The vaccine maker is ready to combine the ingredients. You notice a keypad with the text 'Enter activation code: CURE____'");
                        }
                        return CommandResult.success(null,
                                                     "The vaccine maker appears to be waiting for all ingredients to be placed in the tubes before it can be activated.");
                    }));
                }},
                null), new Room("Yard",
                                "Your spaceship stands there in the middle of the yard.",
                                new Point(3, 0),
                                new ArrayList<>(),
                                new HashMap<>(),
                                null) });

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
}
