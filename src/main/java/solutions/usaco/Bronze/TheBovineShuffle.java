package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class TheBovineShuffle {
    // Problem URL: http://www.usaco.org/index.php?page=viewproblem2&cpid=760
    public static void main(String[] args) throws IOException {

        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/shuffle.in"));
            out = new PrintWriter(new FileWriter("src/output/shuffle.out"));
        } else {
            br = new BufferedReader(new FileReader("shuffle.in"));
            out = new PrintWriter(new FileWriter("shuffle.out"));
        }

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cowIds = new int[n];
        for (int i = 0; i < n; i++) {
            cowIds[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = solve(cows, cowIds);
        for (int id : answer)
            out.println(id);

        br.close();
        out.flush();
        out.close();
    }

    public static int[] solve(int[] cows, int[] cowIds) {
        for (int i = 0; i < 3; i++) {
            int[] reverted = new int[cows.length];
            for (int j = 0; j < cows.length; j++) {
                reverted[j] = cowIds[cows[j] - 1];
            }
            cowIds = reverted;
        }
        return cowIds;
    }
}