package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("java/src/input/pails.in"));
            out = new PrintWriter(new FileWriter("java/src/output/pails.out"));
        } else {
            br = new BufferedReader(new FileReader("pails.in"));
            out = new PrintWriter(new FileWriter("pails.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 0; i < m; i++) {
            if (x * i > m)
                break;
            for (int j = 0; j < m; j++) {
                int a = x * i + y * j;
                if (a > m)
                    break;
                max = Math.max(max, a);
            }
        }
        out.println(max);

        br.close();
        out.flush();
        out.close();
    }
}