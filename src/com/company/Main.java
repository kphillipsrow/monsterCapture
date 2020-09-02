package com.company;

import java.util.Scanner;
import java.lang.Math;

class CaptureCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");
        System.out.println("Please enter the latitude of the monster (1-10): ");
        int monstery= input.nextInt();
        System.out.println("Please enter the longitude of the monster (1-10): ");
        int monsterx= input.nextInt();
        System.out.println("Please enter the time of the monster appear (1-1440): ");
        int Ta = input.nextInt();
        System.out.println("Please enter the possible time of the monster will exist (10-59): ");
        int Te = input.nextInt();
        System.out.println("Please enter the player's ID (8 digits): ");
        int playerId = input.nextInt();
        System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears): ");
        int Tn = input.nextInt();
        System.out.println("Please enter the latitude of the player (1-10): ");
        int playery = input.nextInt();
        System.out.println("Please enter the longitude of the player (1-10): ");
        int playerx = input.nextInt();
        System.out.println("Please enter the player's walking speed (10-200): ");
        int playerSpeed = input.nextInt();	//up to here collects information
        String possible = null;
        double d = Math.pow((playerx-monsterx),2)+Math.pow((playery-monstery),2);
        d = Math.sqrt(d) * 1000;
        d = Math.round(d*10)/10.0;
        double Tg = (Tn + (d / playerSpeed));
        Tg = Math.round(Tg*10)/10.0;
        int i = (int) (((Math.abs(Tg - (Ta + Te)))/ Te) * 100);
        int Td = Ta+Te;

        if ((playerId%100>=0) && (playerId%100)<=49) //Checks the last two digits of player ID to be between 0 and 49
        {
            String player = "lucky";

            if (Tg <= Ta + Te) //when the player gets to the mosnter's location before it disappears
            {
                System.out.println("Player " + playerId + " who is on the " + player + " list,");
                System.out.println("noticed the monster at time " + Tn+",");
                System.out.println("is " + d + " m away from the monster,");
                System.out.println("and will arrive at time " + Tg+",");
                System.out.println("The monster's disappear time is about " + Td+".");
                System.out.println("So the player will capture this monster with definitely possibility.");
            }

            if (Tg >= Ta + Te) //conditions for when the player takes longer than the monster's disappear time
            {
                System.out.println("Player " + playerId + " who is on the " + player + " list,");
                System.out.println("noticed the monster at time " + Tn+",");
                System.out.println("is " + d + " m away from the monster,");
                System.out.println("and will arrive at time " + Tg +",");
                System.out.println("The monster's disappear time is about " + Td+".");

                if (i>=0 && i<=10) //chance of catching is between 0 and 10 percent (inclusive)
                {
                    possible = "highly likely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>10 && i<=30) //chance of not catching is between 10 and 30 percent(inclusive)
                {
                    possible = "likely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>30 && i<=40) //chance of not catching is between 30 and 40 percent(inclusive)
                {
                    possible = "unsure";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>40 && i<=50) //chance of not catching is between 40 and 50 percent(inclusive)
                {
                    possible = "unlikely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>50) //chance of not catching is more than 50 percent
                {
                    possible = "highly unlikely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }

            }
        }
        if ((playerId%100>=50) && (playerId%100)<=99) //Checks the last two digits of player ID to be between 50 and 99
        {
            String player = "normal";
            if (Tg <= Ta + Te) //when the player gets to the mosnter's location before it disappears
            {
                System.out.println("Player " + playerId + " who is on the " + player + " list,");
                System.out.println("noticed the monster at time " + Tn+",");
                System.out.println("is " + d + " m away from the monster,");
                System.out.println("and will arrive at time " + Tg +",");
                System.out.println("The monster's disappear time is about " + Td+".");
                System.out.println("so the player will capture this monster with definitely possibility.");
            }
            if (Tg >= Ta + Te) //conditions for when the player takes longer than the monster's disappear time
            {
                System.out.println("Player " + playerId + " who is on the " + player + " list,");
                System.out.println("noticed the monster at time " + Tn+",");
                System.out.println("is " + d + " m away from the monster,");
                System.out.println("and will arrive at time " + Tg+".");
                System.out.println("The monster's disappear time is about " + Td+".");

                if (i>=0 && i<=5) //chance of not catching is between 0 and 5 percent(inclusive)
                {
                    possible = "highly likely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>5 && i<=20) //chance of not catching is between 5 and 20 percent(inclusive)
                {
                    possible = "likely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>20 && i<=35) //chance of not catching is between 20 and 35 percent(inclusive)
                {
                    possible = "unsure";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>35 && i<=40) //chance of not catching is between 35 and 40 percent(inclusive)
                {
                    possible = "unlikely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
                if (i>40) //chance of not catching is more than 40 percent
                {
                    possible = "highly unlikely";
                    System.out.println("So the player will capture this monster with "+ possible + " possibility.");
                }
            }
        }
        input.close();
    }
}

