import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day3/src/input.txt"));

            int oneOne = slopeCalculator(allLines, 1, 1);
            int threeOne = slopeCalculator(allLines, 3, 1);
            int fiveOne = slopeCalculator(allLines, 5, 1);
            int sevenOne = slopeCalculator(allLines, 7, 1);
            int oneTwo = slopeCalculator(allLines, 1, 2);

            long product = oneOne * threeOne * fiveOne * sevenOne * oneTwo;

            System.out.println(product);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int slopeCalculator(List<String> allLines, int right, int down) {
        int i = 0;
        int xPos = 0;
        int nHits = 0;
        int nNonHits = 0;

        //System.out.println(allLines.get(0));
        while (i < allLines.size() - 1) {
            String line = allLines.get(i);
            xPos += right;
            if (xPos > line.length()-1) {
                xPos = xPos - line.length();
            }
            i += down;
            String nextLine = allLines.get(i);

            if (nextLine.charAt(xPos) == '#') {
                nHits++;
                nextLine = nextLine.substring(0,xPos) + "X" + nextLine.substring(xPos+1);
                //System.out.println(nextLine + " : hit" );
            } else {
                nNonHits++;
                nextLine = nextLine.substring(0,xPos) + "O" + nextLine.substring(xPos+1);
                //System.out.println(nextLine + " : no hit" );
            }

        }
        System.out.println("Right: "+ right + " Down: " + down + " Hits: " + nHits + " Non hits: " + nNonHits);
        return nHits;
    }


}
