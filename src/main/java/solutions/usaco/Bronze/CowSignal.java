package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class CowSignal {
    // Problem URL: http://www.usaco.org/index.php?page=viewproblem2&cpid=665
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input/cowsignal.in"));
        PrintWriter out = new PrintWriter(new FileWriter("src/output/cowsignal.out"));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            String printStr = "";
            for (int j = 0; j < n; j++) {
                printStr += String.valueOf(str.charAt(j)).repeat(k);
            }
            for (int e = 0; e < k; e++) {
                out.println(printStr);
            }
        }

        br.close();
        out.flush();
        out.close();
    }

}
