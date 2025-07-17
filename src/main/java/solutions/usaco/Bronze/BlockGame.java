package solutions.usaco.Bronze;

import java.io.*;

public class BlockGame {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/blocks.in"));
            out = new PrintWriter(new FileWriter("src/output/blocks.out"));
        } else {
            br = new BufferedReader(new FileReader("blocks.in"));
            out = new PrintWriter(new FileWriter("blocks.out"));
        }

        int[] letters = new int[26];
        int[] firstVisitedChars;
        int[] secondVisitedChars;

        int n = Integer.parseInt(br.readLine());

        // Example: Read a line of integers
        for (int i = 0; i < n; i++) {
            String[] spellingBoard = br.readLine().split(" ");
            firstVisitedChars = new int[26];
            secondVisitedChars = new int[26];
            for (int j = 0; j < spellingBoard[0].length(); j++) {
                char ch = spellingBoard[0].charAt(j);
                if (!Character.isAlphabetic(ch))
                    continue;
                letters[ch - 'a']++;
                firstVisitedChars[ch - 'a']++;
            }
            for (int j = 0; j < spellingBoard[1].length(); j++) {
                char ch = spellingBoard[1].charAt(j);
                if (!Character.isAlphabetic(ch))
                    continue;
                if (firstVisitedChars[ch - 'a'] <= secondVisitedChars[ch - 'a'])
                    letters[ch - 'a']++;
                secondVisitedChars[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            out.println(letters[i]);
        }

        br.close();
        out.flush();
        out.close();
    }
}