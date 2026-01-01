package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class WhereAmI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Set<String> visited;
        boolean found = false;
        for (int i = 1; i < N; i++) {
            visited = new HashSet<>();
            int count = 0;
            for (int j = 0; j + i <= N; j++) {
                count++;
                String curr = j + 1 > N - 1 ? s.substring(j) : s.substring(j, j + i);
                visited.add(curr);
            }
            if (visited.size() == count) {
                found = true;
                out.println(i);
                break;
            }
        }
        if (!found) {
            out.println(N);
        }
        out.close();
    }
}
