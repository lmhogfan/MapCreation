package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetHotel
{
    Map<Integer, String> roomPet = new TreeMap<>();

    public static void main(String[] args)
    {
        PetHotel petHotel = new PetHotel();
        petHotel.run();

    }

    private void run()
    {
        System.out.println("Welcome to Dogs Without Horses!");
        System.out.println("===============================");
        System.out.println("Please choose from the following:");
        System.out.println("CheckIn <PetsName> <RoomNumber");
        System.out.println("CheckOut <RoomNumber>");
        System.out.println("Move <FromRoomNumber> to <ToRoomNumber>");
        System.out.println("Occupancy");
        System.out.println("CloseForSeason");
        System.out.println("Exit");
        Scanner grab = new Scanner(System.in);
        String command;

        do
        {
            String selection = grab.nextLine();
            String[] commandSelection = selection.split(" ");
            command = commandSelection[0].toUpperCase();

            if (command.equals("CHECKIN") && commandSelection.length == 3)
            {
                String petName = commandSelection[1];
                int roomNumber = Integer.parseInt(commandSelection[2]);
                if (roomPet.containsKey(roomNumber))
                {
                    System.out.println("There is already a pet in that room!");
                    System.out.println("Can I help you with something else?");
                }
                else
                {
                    checkIn(roomNumber, petName);
                    System.out.println("What else can I help you with?");
                }
            }
            else if (command.equals("CHECKOUT") && commandSelection.length == 2)
            {
                int roomNumber = Integer.parseInt(commandSelection[1]);
                checkOut(roomNumber);
                System.out.println("What else can I help you with?");

            }
            else if (command.equals("MOVE") && commandSelection.length == 4)
            {
                int oldRoom = Integer.parseInt(commandSelection[1]);
                int newRoom = Integer.parseInt(commandSelection[3]);
                String petName = roomPet.get(oldRoom);
                if (roomPet.containsKey(newRoom))
                {
                    System.out.println("There is already a pet in that room!");
                    System.out.println("Can I help you with anything else?");
                }
                else
                {
                    roomPet.remove(oldRoom);
                    roomPet.put(newRoom, petName);
                    System.out.println(petName + " was moved to room " + newRoom);
                    System.out.println("What else can I help you with?");
                }
            }
            else if (command.equals("OCCUPANCY"))
            {
                for (Map.Entry<Integer,String> entry:roomPet.entrySet())
                {
                    System.out.println("Room "+entry.getKey()+": "+entry.getValue());
                }
            }
            else if (command.equals("CLOSEFORSEASON"))
            {
                roomPet.clear();
                System.out.println("Dogs Without Horses is now closed!");
                break;
            }
            else
            {
                System.out.println("Please type a valid response!(Check spacing)");
            }
        }
        while (!command.equals("EXIT"));
        System.out.println("Goodbye!");
    }

    private void checkIn(int roomNumber, String petName)
    {
        System.out.println("Checking " + petName + " in to room " + roomNumber);
        roomPet.put(roomNumber, petName);
    }

    private void checkOut(int roomNumber)
    {
        String petName = roomPet.remove(roomNumber);
        System.out.println(petName + " was checked out of room " + roomNumber);
    }
}
