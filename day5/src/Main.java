import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day5/src/input.txt"));
            int highestID = 0;
            int lowestID = 99999;

            List<Integer> IDs = new ArrayList<>();

            for (String line : allLines) {
                int row = getRow(line, 1, 128, 0) - 1;
                int col = getCol(line, 1, 8, 0) - 1;
//                System.out.println("Row: " + row);
//                System.out.println("Col: " + col);
                int ID = row * 8 + col;
                IDs.add(ID);
                if (ID > highestID) highestID = ID;
                if (ID < lowestID) lowestID = ID;
            }

            System.out.println("Highest ID: " + highestID);
            System.out.println("Lowest ID: " + lowestID);
            IDs.sort(null);

            for (int i = 0; i < IDs.size()-1; i++) {
                if (Math.abs(IDs.get(i) - IDs.get(i+1)) == 2) {
                    System.out.println("Correct ID: " + (IDs.get(i)+1));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRow(String str, int lowNum, int highNum, int depth) {
        if (highNum - lowNum != 0 && depth < 7) {
            char Char = str.charAt(depth);
            if (Char == 'F') {
                return getRow(str, lowNum, highNum - (highNum - lowNum) / 2 - 1, depth + 1);
            } else {
                return getRow(str, lowNum + (highNum - lowNum) / 2 + 1, highNum, depth + 1);
            }
        }
        return lowNum;
    }

    public static int getCol(String str, int lowNum, int highNum, int depth) {
        if (highNum - lowNum != 0 && depth < 3) {
            char Char = str.charAt(7 + depth);
            if (Char == 'L') {
                return getCol(str, lowNum, highNum - (highNum - lowNum) / 2 - 1, depth + 1);
            } else {
                return getCol(str, lowNum + (highNum - lowNum) / 2 + 1, highNum, depth + 1);
            }

        }
        return lowNum;
    }
}
