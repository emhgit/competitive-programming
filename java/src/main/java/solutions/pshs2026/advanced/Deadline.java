package solutions.pshs2026.advanced;

import java.io.*;
import java.util.*;

public class Deadline {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        map.put("g", 10);
        map.put("a", 5);
        map.put("s", 5);
        map.put("w", 15);
        map.put("c", 10);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if (type.equals("I")) {
                continue;
            }
            while (st.hasMoreTokens()) {
                sum += map.get(st.nextToken());
            }
        }
        String msg = (sum > limit) ? "Imposters Win!" : "Crewmates Win!";
        out.println(msg);
    }
}
