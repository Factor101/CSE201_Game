package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static final Scanner stdin = new Scanner(System.in);
    private static boolean isRunning = true;

    private static String promptCommand(final String prompText)
    {
        System.out.printf("%s\n > ", prompText);
        final String userInput = stdin.nextLine();
        System.out.println();

        return userInput;
    }

    public static void main(String[] args)
    {
        Player player = new Player();
        CommandHandler commandHandler = new CommandHandler();

        while(isRunning)
        {

        }
    }
}
