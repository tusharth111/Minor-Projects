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
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int score = 0;

        //Define arrays containing the riddles
        String[] riddles = {
                " I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
                " The more you take, the more you leave behind. What am I?",
                " I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?"
        };
        String[] answer={
            "echo",
            "Footsteps",
            "fire"
        };
        //Define the hints for each riddle
        String [] hints= {
                "Hint: This thing is known for its ability to reflect sound.",
                "Hint: Think about what you leave behind when you walk.",
                "Hint: It produces heat and light."
        };
        boolean playing = true;
        while(playing)
        {
            int guesses = 1;
            int randomIndex = (int) (Math.random() * riddles.length);
            String selectedRiddle = riddles[randomIndex];
            String correctAnswer = answer[randomIndex];
            String hint = hints[randomIndex];

            // Display the riddle
            System.out.println("Riddle: "+ selectedRiddle);

            //Get the user answer
            String useranswer = scanner.next();

            if(useranswer.equalsIgnoreCase(correctAnswer)){
                System.out.println("Correct");
                System.out.println("Number of guesses you have taken are : " +guesses);
                score++;
            }else{
                System.out.println("Wrong!, would you like a hint?(y/n)");
                String giveHint = scanner.next().toLowerCase();
                guesses=guesses+1;
                if(giveHint.equals("y")) {
                    System.out.println(hint);
                    System.out.println("TRY again");
                    useranswer = scanner.next();
                    if (useranswer.equalsIgnoreCase(correctAnswer)) {
                        System.out.println("Correct! ");
                        score++;
                        System.out.println("you have taken this many guesses: "+guesses);
                    } else {
                        System.out.println("Still Wrong ! the correct answer was : " + correctAnswer);
                    }
                }else{
                        System.out.println("The correct answer was :"+ correctAnswer);
                    }
                }


            //ALLOW the user to continue or exit
            System.out.println("Continue playing?(y/n): ");
            String playAgain = scanner.next().toLowerCase();
            if(!playAgain.equals("y")){
                playing = false;
            }
        }
        //display the final score
        System.out.println("Your score is : "+score);
        System.out.println("Thanks for playing! ");
    }
}
