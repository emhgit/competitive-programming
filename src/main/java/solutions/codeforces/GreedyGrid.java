package solutions.codeforces;

import java.io.*;
import java.util.*;

public class GreedyGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // Example: Read an integer
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if ((n < 2 && m >= 2) || (m < 2 && n >= 2))
                out.println("NO");
            else
                out.println("YES");
        }

        br.close();
        out.flush();
        out.close();
    }
}