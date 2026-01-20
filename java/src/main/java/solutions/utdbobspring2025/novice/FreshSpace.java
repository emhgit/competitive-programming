package solutions.utdbobspring2025.novice;

import java.io.*;
import java.util.*;

public class FreshSpace {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st.nextToken();
        Set<Integer> visitedRooms = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (!visitedRooms.contains(score)) {
                out.print(1 + " ");
                visitedRooms.add(score);
            } else
                out.print(0 + " ");
        }

        br.close();
        out.flush();
        out.close();
    }
}