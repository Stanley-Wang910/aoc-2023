package Day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trebuchet {
    private static final Map<String, String> numSpellMap = new HashMap<String, String>() {{
        put("zero", "0");
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
    }};

    public static void main(String[] args) {
        ArrayList<String> input  = readInput();
//        int sumDigits = part1(input);
        int sumDigits = part2(input);
        System.out.println(sumDigits);
    }

    private static int part1(ArrayList<String> input) {
        int sum = 0;
        for (String s : input) {
            String firstInt = "";
            String lastInt = "";
            int firstIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    firstIndex = i;
                    firstInt = Character.toString(c);
                    break;
                }
            }


            for(int i = s.length() - 1; i >= firstIndex; i--) {
                if (Character.isDigit(s.charAt(i))) {
                    lastInt = Character.toString(s.charAt(i));
                    break;
                }
            }
            String combined = firstInt + lastInt;
            System.out.println("first int " + firstInt + ", last int " + lastInt + ", string " + s);
            sum += Integer.parseInt(combined);
            System.out.println("sum: "+ sum);
        }
        return sum;
    }

    private static int part2(ArrayList<String> input) {
        int sum = 0;
        Pattern pattern = Pattern.compile("(?=(\\d|one|two|three|four|five|six|seven|eight|nine))");

        for (String s : input) {
            ArrayList<String> matches = new ArrayList<>();
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                String match = matcher.group(1);
                matches.add(numSpellMap.getOrDefault(match,match));
            }

            String firstInt = matches.get(0);
            String lastInt = matches.get(matches.size()-1);

            String combined = firstInt + lastInt;

            sum += Integer.parseInt(combined);

        }
    return sum;
    }



    public static ArrayList<String> readInput() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("/Users/stanley/Code/aoc-2023/aoc-2023-java/src/main/java/Day1/Day1Input");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader  = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        ArrayList<String> lines = new ArrayList<String>();

        try {
            while ((strLine = reader.readLine()) != null) {
                lines.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
