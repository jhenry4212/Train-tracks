import java.util.*;
import java.io.*;

//Data and File Structures Final Project
//Matthew Koser & Jonathan Henry


public class trainMain
{
    static trainGraph trains = new trainGraph(11);
    public static void main(String[] args)
    {
        trains.initializeData();
        trains.evaluatePaths();
        process();
    }
   
    public static void process()
    {
        System.out.println("What would you like to do?");
        System.out.println("\n1. Calculate the travel time between two stations");
        System.out.println("2. Show list of all avaliable stations.");
        System.out.println("3. Exit the program");
        Scanner response = new Scanner(System.in);
        int c = response.nextInt();
        switch(c)
        {
            case 1:
               distance();
               break;
            case 2:
               list();
               break;
            case 3:
               break;
            default:
                System.out.println("Your answer doesn't look valid. Please try again!\n\n");
                process();
        }
    }
    
    public static void list()
    {
        System.out.println("\nHere is every station able to be used for evaluation:\n");
        trains.printList();
        System.out.print("\n\n");
        process();
    }
    
    public static void distance()
    {
        Scanner get = new Scanner(System.in);
        System.out.println("\nPlease enter where you would like to start: ");
        String source = get.nextLine();
        System.out.println("Please enter your destination: ");
        String destination = get.nextLine();
        double time = trains.getShortest(source, destination);
        if(time == -2)
            {
                System.out.println("One or more of your entries is not valid! Please try again!");
                distance();
            }
        else if(time == -1)
            {
                System.out.println("A path to that destination does not exist! Please try again!");
                distance();
            }
        else
            {
                int hours = (int)time / 60;
                int minutes = (int)time % 60;
                System.out.println("The time it takes to travel from " + source + " to " + destination + " is: " + hours + " hours and " + minutes + " minutes");
                process();
            }
    }
}