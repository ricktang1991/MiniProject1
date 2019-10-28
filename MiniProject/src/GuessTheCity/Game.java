package GuessTheCity;
import static GuessTheCity.RandomCity.makeRandomCity;
import java.util.Scanner;
class Game {
        private String randomCity = makeRandomCity();
        private StringBuilder display = displayRandomCity(randomCity);


        private StringBuilder displayRandomCity(String randomCity) {
            StringBuilder displayRandomCity = new StringBuilder();
            for (int i = 0; i < randomCity.length(); i++) {
                if (randomCity.charAt(i) == ' ') {
                    displayRandomCity.append(' ');
                } else {
                    displayRandomCity.append('_');
                }
            }return displayRandomCity;
    }

    void playGame() {
        int guessCount = 0;
        String wrongNames = "";
        System.out.println("Guess a city.");
        System.out.println(display);

        while (guessCount < 10 && !display.toString().equals(randomCity)) {
            Scanner guess = new Scanner(System.in);
            System.out.print("Guess a letter: ");
            String letter = guess.nextLine();
            if (!randomCity.contains(letter)) {
                if (letter.length() > 1) {
                    System.out.println("Input must be one letter");
                }
                else if (wrongNames.contains(letter)) {
                    System.out.println("You Already guessed " + letter);
                } else {
                    wrongNames += " " + letter;
                    guessCount++;
                }
                System.out.println("You are guessing: " + display);
                System.out.println("You have guessed (" + guessCount + ") wrong letters:" + wrongNames);

            } else {
                for (int i = 0; i < randomCity.length(); i++) {
                    if (String.valueOf(randomCity.charAt(i)).equals(letter)) {
                        display.setCharAt(i, letter.charAt(0));
                    }
                }
                System.out.println("You are guessing: " + display);
                System.out.println("You have guessed (" + guessCount + ") wrong letters:" + wrongNames);
            }

        }
        if (display.toString().equals(randomCity)) {
            System.out.println("You Win!\nYou have guessed '" + randomCity + "' correctly");
        } else {
            System.out.println("You Lose!\nThe correct word was '" + randomCity + "'!");
        }
    }

}
