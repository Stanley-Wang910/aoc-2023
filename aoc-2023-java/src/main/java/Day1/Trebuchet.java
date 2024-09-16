package Day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Trebuchet {

    public static void main(String[] args) {
        ArrayList<String> input  = readInput();
        int sumDigits = sumFirstLastDigits(input);
        System.out.println(sumDigits);
    }

    private static int sumFirstLastDigits(ArrayList<String> input) {
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

    public static ArrayList<String> readInput() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("/Users/stanley/Code/aoc-2023-java/src/main/java/Day1/Day1Input");
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
