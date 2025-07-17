package solutions.usaco.Bronze;

import java.io.*;

public class Herdle {
    /// problem URL: http://www.usaco.org/index.php?page=viewproblem2&cpid=1179
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            answer.append(br.readLine());
        }
        StringBuilder guess = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            guess.append(br.readLine());
        }
        int[] result = solve(answer.toString(), guess.toString().trim());
        for (int val : result)
            out.println(val);

        br.close();
        out.flush();
        out.close();
    }

    public static int[] solve(String answer, String guess) {
        int[] guessFreqArr = new int[26];
        int[] result = new int[2];
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != answer.charAt(i))
                guessFreqArr[guess.charAt(i) - 'A']++;
            else
                result[0]++;
        }
        for (int i = 0; i < answer.length(); i++) {
            char currCh = answer.charAt(i);
            if (currCh != guess.charAt(i) && guessFreqArr[currCh - 'A'] > 0) {
                result[1]++;
                guessFreqArr[currCh - 'A']--;
            }
        }
        return result;
    }
}