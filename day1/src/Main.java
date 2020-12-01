import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day1/src/input.txt"));
            for (String line : allLines) {
                compare2Terms(allLines, line);
            }

            for (String line : allLines) {
                compare3Terms(allLines, line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void compare2Terms(List<String> allLines, String line) {
        for (String compLine : allLines) {
            int firstNum = Integer.parseInt(line);
            int secondNum = Integer.parseInt(compLine);

            if (firstNum + secondNum == 2020) {
                printAnswer(line, compLine, firstNum, secondNum, "", 1);
                return;
            }
        }
    }

    private static void compare3Terms(List<String> allLines, String line) {
        for (String compLine : allLines) {
            int firstNum = Integer.parseInt(line);
            int secondNum = Integer.parseInt(compLine);

            for (String compLine2 : allLines) {
                int thirdNum = Integer.parseInt(compLine2);
                if (firstNum + secondNum + thirdNum == 2020) {
                    printAnswer(line, compLine, firstNum, secondNum, compLine2, thirdNum);
                    return;
                }
            }
        }
    }

    private static void printAnswer(String line, String compLine, int firstNum, int secondNum, String compLine2, int thirdNum) {
        System.out.println("First: " + line + " Second: " + compLine + " Third: " + compLine2);
        System.out.println("Product: " + firstNum * secondNum * thirdNum);
    }
}
