package solutions.cses;

import java.io.*;
import java.util.*;

public class SumOfTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> visited = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        boolean found = false;
        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if (visited.containsKey(x - curr)) {
                out.println((visited.get(x - curr) + 1) + " " + (i + 1));
                found = true;
                break;
            }
            visited.put(curr, i);
        }
        if (!found) {
            out.println("IMPOSSIBLE");
        }
        out.close();
    }
}
