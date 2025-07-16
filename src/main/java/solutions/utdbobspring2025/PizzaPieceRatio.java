package solutions.utdbobspring2025;

import java.io.*;
import java.util.*;

public class PizzaPieceRatio {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        // determine the largest possible ratio between the volume of the largest piece
        // and the smallest piece
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int c = k / 2;
            if (k / 2 <= 1) {
                out.println(1);
                continue;
            }
            double largestArcLen = (double) (360 / k) + ((double) p * (c - 1) / 100) * (360 / k);
            double smallestArcLen = (double) (360 / k) - ((double) p / 100) * (360 / k);
            double ratio = largestArcLen / smallestArcLen;
            out.println(ratio);
        }

        br.close();
        out.flush();
        out.close();
    }
}