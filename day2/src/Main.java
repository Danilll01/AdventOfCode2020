import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day2/src/input.txt"));
            getValidPasswordsPart1(allLines);

            getValidPasswordsPart2(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getValidPasswordsPart1(List<String> allLines) {
        int nrRepeatedLetters;
        int validPasswords = 0;

        for (String line : allLines) {
            String[] splittedLine = splitInputToArr(line);

            nrRepeatedLetters = getNrRepeatedLetters(splittedLine[2].charAt(0), splittedLine[3]);

            if (Integer.parseInt(splittedLine[0]) <= nrRepeatedLetters && nrRepeatedLetters <= Integer.parseInt(splittedLine[1])) {
                validPasswords++;
            }

        }
        System.out.println(validPasswords);
    }


    private static void getValidPasswordsPart2(List<String> allLines) {
        int validPasswords = 0;

        for (String line : allLines) {
            String[] splittedLine = splitInputToArr(line);
            int firstPos = Integer.parseInt(splittedLine[0])-1;
            int secondPos = Integer.parseInt(splittedLine[1])-1;
            char Char = splittedLine[2].charAt(0);

            try {
                if (splittedLine[3].charAt(firstPos) == Char ^ splittedLine[3].charAt(secondPos) == Char) {
                    validPasswords++;
                }
            } catch (StringIndexOutOfBoundsException ignored) {}

        }
        System.out.println(validPasswords);
    }

    private static String[] splitInputToArr(String line) {
        line = line.replaceAll(":", "");
        line = line.replaceAll("-", " ");
        return line.split(" ");
    }

    private static int getNrRepeatedLetters(char repeatedChar, String inputString) {
        int counter = 0;
        for (char Char : inputString.toCharArray()) {
            if (Char == repeatedChar) {
                counter++;
            }
        }
        return counter;
    }
}
