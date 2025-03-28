package org.Arth.SwingBasedNumberGuessingGame;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/***
 Developer Name : Tushar Thakur
 Developer Contact : tusharth111@gmail.com
 Created on:  28 3/28/2025 1:48 PM
 Project Name : MinorProjects
 ***/

public class NumberGuessingGame extends JFrame{
    private int targetNumber;
    private int attempts;
    private final JLabel titleLabel;
    private final JLabel promptLabel;
    private final JLabel resultLabel;
    private final JTextField guessField;
    private final JButton submitButton;
    private final JButton restartButton;

    private void resetGame(){
        Random random = new Random();
        targetNumber = random.nextInt(100)+1; //Random number in between the 1 to 100
        attempts = 0;
    }

    public NumberGuessingGame(){
        setTitle("Number Guessing Game");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        //title label
        titleLabel = new JLabel("Guess the number (1-100)",SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial",Font.BOLD,18));
        add(titleLabel, BorderLayout.NORTH);

        //Main Panel
        JPanel centerPanel = new JPanel(new GridLayout(3,1,10,10));

        promptLabel = new JLabel("Enter the guess: ",SwingConstants.CENTER);

        guessField = new JTextField();
        guessField.setHorizontalAlignment(JTextField.CENTER);

        resultLabel = new JLabel("",SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial",Font.ITALIC,15));

        centerPanel.add(promptLabel);
        centerPanel.add(guessField);
        centerPanel.add(resultLabel);
        add(centerPanel,BorderLayout.CENTER);

        //BUTTON PANEL south
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));

        submitButton = new JButton("SUBMIT GUESS");
        submitButton.addActionListener(e -> checkGuess());
        restartButton = new JButton("RESTART BUTTON");
        restartButton.addActionListener(e -> resetGame());

        buttonPanel.add(submitButton);
        buttonPanel.add(restartButton);
        add(buttonPanel,BorderLayout.SOUTH);

        resetGame();
    }
    public void checkGuess(){
        try{
            int guess = Integer.parseInt(guessField.getText());
            attempts++;

            if (guess == targetNumber){
                resultLabel.setText("CORRECT ! YOU WON IN "+attempts+"ATTEMPTS");
                submitButton.setEnabled(false);//disabled after wining
            } else if (guess<targetNumber) {
                resultLabel.setText("TOO LOW! TRY AGAIN.");

            }else {
                resultLabel.setText("TOO HIGH! TRY AGAIN.");
            }
        }catch (NumberFormatException e){
            resultLabel.setText("Invalid input! Enter a number .");
        }
    }

//SwingUtilities.invokeLater() ->Ensures GUI runs on the Event Dispatch Thread (EDT).
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            NumberGuessingGame game = new NumberGuessingGame();
            game.setVisible(true);
        });
    }
}