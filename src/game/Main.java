package game;

import rooms.Room;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Class: Intro to Software Engineering
 *
 * @author Stefan Wenzke, Ilhaan Artan, Nathan Anthony, Matthew Heffernan, Brad
 * Martin, Rafael Santell-Colon
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Room> rooms = new ArrayList<>()
        {{
            add(new Room("Cyro Pod Room",
                         "The room around you is eerily quiet. A dead alien sits in the opposite side of the room from the broken pod from which you awoke.",
                         new Point(0, 0),
                         new ArrayList<>(List.of(new Item("Keycard",
                                                          "Keycard is the personal property of Dr. Grobu, resident and chief of the transient research facility. You can use this to unlock the lab entrance."))),
                         new HashMap<>()));
            add(new Room("Lab",
                         "The room appears to be some sort of lab. There sits a desk in one corner, with some scrawlings along the opposite wall.",
                         new Point(1, 0),
                         new ArrayList<>(List.of(new Item("Gas Mask", "Needed to be able to enter the gas bottling room. Something seems to be broken"), new Item("Letter", "Welcome to the Transient research facility. I wrote this letter before clicking the time release button on your stasis pod. This horrible disease has mutated me into what I am today and destroyed our planet. I have done all of the work for you to synthesize a cure. First in the gas bottling room vault you have to get (clowth gas), then in the genetic testing room you have to get the fur of a bright orange monster, and then get a flower bud from the greenhouse room. Finally you will have to mix all three ingredients in our mixing room. Synthesize a cure and save the planet.. -Dr. Grobu\r\n"
                                                    ))),
                         new HashMap<>()));
            add(new Room("Gas Room",
                         "The room has a lingering odor about it. There seem to be various things related to chemicals in here.",
                         new Point(1, 1),
                         new ArrayList<>(List.of(new Item("Tranq Gun", "Needed to enter the genetic testing room in case of emergency."), 
                            new Item("Clowth", "Clowth gas is gathered through the manipulation of multiple different elements. It can help heal cells at the cellular level."))),
                         new HashMap<>()));
            add(new Room("Genetic Testing Room",
                         "The room contains various cages, and some important looking technology on the far wall.",
                         new Point(1, -1),
                         new ArrayList<>(List.of(new Item("Fertilizer", "Used primarily in the greenhouse to plant seedlings into the flower bed. Needed to enter the greenhouse.\r\n"
                                                          ), new Item("Seed", "A long and distant relative from the rose this seed has unique chemical properties when in full bloom\r\n" 
                                                        ), new Item("Mirequills Fur", "The bright orange fur glows as you stare at it. The result of multiple rounds of radiation testing and gene editing.\r\n"
                                                        ))),
                         new HashMap<>()));
            add(new Room("Hallway",
                         "The hallway contains a strange pattern on the wall, and a window which gives you a glimpse into the world outside.",
                         new Point(2, 0),
                         new ArrayList<>(),
                         new HashMap<>()));
            add(new Room("Split-Room",
                         "You're surrounded by oil drums. The room splits off into two directions. Up north appears to be a greenhouse, while down south the rooms is labeled \"Final Mixing Room\".",
                         new Point(3, 0),
                         new ArrayList<>(),
                         new HashMap<>()));
            add(new Room("Greenhouse",
                         "As you walk in you see all of the overgrown fauna. You see a flowerbed that is missing its fertilizer and large hoses that seem to be the watering supply. Straight in front of you, against the back wall of the room, you see a terminal that looks like it controls the flower bed. There is also some writing against the wall.",
                         new Point(3, 1),
                         new ArrayList<>(List.of(new Item("Tulip Bulb", "This special flower tulip bulb has a neurotoxin that helps reduce the spread of infection through the air by constricting bloodflow throughout the body"))),
                         new HashMap<>()));
            add(new Room("Final Mixing Room",
                         "You see three tubes to your right and a large vaccine-making machine to your left. As you peer straight on, you can see a large glass door, and through that glass, you can see a spaceship. It seems as if your time here at the Transient research facility is finally coming to an end.",
                         new Point(3, -1),
                         new ArrayList<>(),
                         new HashMap<>()));
            add(new Room("Yard",
                         "Your spaceship stands there in the middle of the yard.",
                         new Point(3, -2),
                         new ArrayList<>(),
                         new HashMap<>()));
        }};

        // temporary line for demo
        Player.setCurrentRoom(rooms.get(0));

        // main event loop
        // flag to control the main event loop
        boolean isRunning = true;
        while(isRunning)
        {
            // prompt, parse, and execute the command
            // user will enter a command + args (where applicable)
            final String userInput = InputHandler.promptCommand("Enter a command:");
            final CommandResult<?> result = InputHandler.parseAndExecute(userInput);

            // output the result
            if(result.isSuccess())
            {
                final String message = result.message();
                if(message != null) // do not output Void type commands
                {
                    System.out.println(message);
                }
            }
            else
            {
                System.out.println("You spoke nonesense: " + result.message());
            }
        }
    }
}
