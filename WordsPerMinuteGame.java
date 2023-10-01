import java.util.*;

/**
 * Created by Travis Huynh.
 * Date: 9/30/2023.
 * Used only Java in this project.
 * This project is not perfect, there are some problems calculating the correct WPM and the timing.
 */

public class WordsPerMinuteGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sentences = {
                "why moon on I person voice gold may own voice look town once water order.",
                "Jeanne wished she has chosen the red button.",
                "It was difficult for Mary to admit that most of her workout consisted of exercising poor judgment.",
                "The wake behind the boat told of the past while the open sea for told life in the unknown future.",
                "If I don’t like something, I’ll stay away from it.",
                "The gloves protect my feet from excess work.",
                "Traveling became almost extinct during the pandemic.",
                "There should have been a time and a place, but this wasn't it.",
                "Tuesdays are free if you bring a gnome costume.",
                "She was the type of girl who wanted to live in a pink house."
        };

        System.out.println("Hello! My name is Travis Huynh! This is my small project that I made" +
                " that introduces a WPM game similar to online games like MonkeyType and Typeracer!");
        System.out.println("This is the game I created to practice my Java Skills. (Date: 9/30/2023) \n");
        System.out.println("You have 60 seconds to complete the sentence!\nThe timer starts when program started!\n");
        System.out.println("Please type out the sentence down below as fast as possible: \n");

        int correctWords = 0;
        int totalWords = 0;
        int totalTime = 60;
        //CHOOSING RANDOM SENTENCES FOR GAME.
        String sentence = sentences[(int)(Math.random() * sentences.length)];
        System.out.println(sentence);

        //ERROR HERE, I COULD NOT FIGURE OUT WHERE TO TIME.
        long startTime = System.currentTimeMillis();
        String typedSentence = scanner.nextLine();

        String[] originalWords = sentence.split(" ");
        String[] typedWords = typedSentence.split(" ");

        for (int i = 0; i < Math.min(typedWords.length, originalWords.length); i++) {
            totalWords++;
            if (typedWords[i].equals(originalWords[i])) {
                correctWords++;
            }
        }

        int elapsedTime = (int) ((System.currentTimeMillis() - startTime) / 1000);

        if (elapsedTime < totalTime) {
            double wpm = ((double)correctWords / elapsedTime) * 60;
            double accuracy = ((double)correctWords / totalWords) * 100;

            System.out.println("\nResults-------");
            System.out.println("Time: " + elapsedTime + " seconds");
            System.out.println("Words Typed: " + totalWords);
            System.out.println("Correct Words: " + correctWords);
            System.out.println("Accuracy: " + accuracy + "%");
            System.out.println("Words Per Minute (WPM): " + wpm);
            System.out.println("\nThank you for playing my game! The words per minute is not accurate and requires " +
                    "more action to accurately time user input.");
        }
        else {
            System.out.println("Uh oh! Time's up! You typed " + totalWords + " words with only " + correctWords + " correct.");
        }
        scanner.close();
    }
}