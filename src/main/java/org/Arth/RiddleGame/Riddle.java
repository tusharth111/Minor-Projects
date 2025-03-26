package org.Arth.RiddleGame;

import java.util.Random;
import java.util.Scanner;

/***
 Developer Name : Tushar Thakur
 Developer Contact : tusharth111@gmail.com
 Created on:  26 3/26/2025 10:44 AM
 Project Name : MinorProjects
 ***/
public class Riddle {
    public static void Main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int score = 0;

        //Define arrays containing the riddles
        String[] riddles = {
                " I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
                " The more you take, the more you leave behind. What am I?",
                " I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?"
        };
        String[] answer={
            "An echo",
            "Footsteps",
            "A fire"
        };
        //Define the hints for each riddle
        String [] hints= {
                "Hint: This thing is known for its ability to reflect sound.",
                "Hint: Think about what you leave behind when you walk.",
                "Hint: It produces heat and light."
        };
        int numRiddles = riddles.length;
        while(true){
            int randomIndex = (int) (Math.random() *numRiddles);
            String selectedRiddle = riddles[randomIndex];
            String correctAnswer = answer[randomIndex];
            String hint = hints[randomIndex];

            // Display the riddle
            System.out.println("Riddle: "+ selectedRiddle);

            //Get the user answer
            String useranswer = scanner.nextLine();

            if(useranswer.equalsIgnoreCase(correctAnswer)){
                System.out.println("Correct");
                score++;
            }else{
                System.out.println("Wrong!, would you like a hind?(y/n)");
                String giveHint = scanner.nextLine().toLowerCase();
                if(giveHint.equals("y")){
                    System.out.println(hint);
                }
            }

            //ALLOW the user to continue or exit
            System.out.println("Continue playing?(y/n): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if(!playAgain.equals("y")){
                break;
            }
        }
        //display the final score
        System.out.println("Your score is : "+score);
        System.out.println("Thanks for playing! ");
    }
}
