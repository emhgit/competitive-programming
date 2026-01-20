package solutions.usaco.bronze;

import java.io.*;

public class WhyDidTheCowsCrossTheRoadII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String paths = br.readLine();
        Letter[] letters = new Letter[26];
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            int start = -1;
            int end = -1;
            for (int j = 0; j < 52; j++) {
                if (paths.charAt(j) != ch)
                    continue;
                if (start == -1)
                    start = j;
                else {
                    end = j;
                    break;
                }
            }
            letters[i] = new Letter(ch, start, end);
        }

        int crossingPairs = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (letters[j].ch == letters[i].ch)
                    continue;
                if (letters[i].start < letters[j].start && letters[i].end < letters[j].end &&
                        letters[j].start < letters[i].end) {
                    crossingPairs++;
                }
            }
        }
        out.println(crossingPairs);

        br.close();
        out.flush();
        out.close();
    }

    static class Letter {
        char ch;
        int start;
        int end;

        public Letter(char ch, int start, int end) {
            this.ch = ch;
            this.start = start;
            this.end = end;
        }
    }
}
