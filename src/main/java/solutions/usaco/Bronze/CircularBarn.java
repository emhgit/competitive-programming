package solutions.usaco.Bronze;

import java.io.*;

public class CircularBarn {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/cbarn.in"));
            out = new PrintWriter(new FileWriter("src/output/cbarn.out"));
        } else {
            br = new BufferedReader(new FileReader("cbarn.in"));
            out = new PrintWriter(new FileWriter("cbarn.out"));
        }

        int n = Integer.parseInt(br.readLine());

        int[] rooms = new int[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            int idx = 1;
            for (int j = (i + 1) % n; j != i; j++) {
                curr += (idx * rooms[j]);
                idx++;
                if (j + 1 == n)
                    j = -1;
            }
            min = Math.min(min, curr);
        }
        out.println(min);

        br.close();
        out.flush();
        out.close();
    }
}