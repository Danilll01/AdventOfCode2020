import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day4/src/input.txt"));
            int i = 0;
            int legalAndValidPasses = 0;

            while (i < allLines.size()-1) {
                List<String> passportCred = new ArrayList<>();
                while (!allLines.get(i).equals("")) {
                    String[] splittedCreds = allLines.get(i).split(" ");

                    passportCred.addAll(Arrays.asList(splittedCreds));

                    i++;
                }


                if (isLegal(passportCred) && isValid(passportCred)){
                    legalAndValidPasses++;
                    System.out.println(passportCred.toString() + "Passed!");
                } else {
                    System.out.println(passportCred.toString() + "NOT Passed!");
                }
                i++;

            }
            System.out.println(legalAndValidPasses);
        } catch (IOException e) {
            e.printStackTrace();
        }


        
    }

    public static boolean isValid(List<String> list) {

        for (String s : list) {
            if (s.startsWith("byr:") && !s.replace("byr:", "").matches("19[2-9][0-9]|200[0-2]")) {
                return false;
            } else if (s.startsWith("iyr") && !s.replace("iyr:", "").matches("201[0-9]|2020")) {
                return false;
            } else if (s.startsWith("eyr:") && !s.replace("eyr:", "").matches("202[0-9]|2030")) {
                return false;
            } else if (s.startsWith("hgt:") && !s.replace("hgt:", "").matches("1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in")) {
                return false;
            } else if (s.startsWith("hcl:") && !s.replace("hcl:", "").matches("#[0-9a-f]{6}")) {
                return false;
            } else if (s.startsWith("ecl:") && !s.replace("ecl:", "").matches("amb|blu|brn|gry|grn|hzl|oth")) {
                return false;
            } else if (s.startsWith("pid:") && !s.replace("pid:", "").matches("[0-9]{9}")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLegal(List<String> list) {
        List<String> categories = new ArrayList<>(
                List.of("ecl:", "eyr:", "hcl:", "byr:", "iyr:", "hgt:", "pid:")
        );
        boolean legal = true;

        for (String line : list) {
            boolean legalTmp = false;
            for (String category : categories) {
                if (line.contains(category) || line.contains("cid:")) {
                    legalTmp = true;
                    break;
                }
            }
            legal = legalTmp && legal;
        }
        return legal;
    }
}


/*
*   if (s.startsWith("byr:") && !s.replace("byr:", "").matches("19[2-9][0-9]|200[0-2]")) {
        return false;
    } else if (s.startsWith("iyr") && !s.replace("iyr:", "").matches("201[0-9]|2020")) {
        return false;
    } else if (s.startsWith("eyr:") && !s.replace("eyr:", "").matches("202[0-9]|2030")) {
        return false;
    } else if (s.startsWith("hgt:") && !s.replace("hgt:", "").matches("1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in")) {
        return false;
    } else if (s.startsWith("hcl:") && !s.replace("hcl:", "").matches("#[0-9a-f]{6}")) {
        return false;
    } else if (s.startsWith("ecl:") && !s.replace("ecl:", "").matches("amb|blu|brn|gry|grn|hzl|oth")) {
        return false;
    } else if (s.startsWith("pid:") && !s.replace("pid:", "").matches("[0-9]{9}")) {
        return false;
    }
* */