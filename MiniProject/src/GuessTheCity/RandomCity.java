package GuessTheCity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class RandomCity {
    static String makeRandomCity() {
        try {
            File file = new File("/Users/mac/Desktop/MiniProject/src/GuessTheCity/cities.txt");
            Scanner scan = new Scanner(file);
            List<String> content = new ArrayList<String>();

            while (scan.hasNextLine()) {
                content.add(scan.nextLine());
            }
            String[] cities = content.toArray(new String[0]);
            Random random = new Random();
            return cities[random.nextInt(cities.length)];

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return "";
    }
}
