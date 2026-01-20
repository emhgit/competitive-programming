package solutions.usaco.silver;

import java.io.*;
import java.util.*;

public class CitiesAndStates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter out = new PrintWriter(new FileWriter("citystate.out"));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> locationMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cityCode = st.nextToken().substring(0, 2), stateCode = st.nextToken();
            if (cityCode.equals(stateCode)) {
                continue;
            }
            String key = stateCode + cityCode;
            locationMap.put(key, locationMap.getOrDefault(key, 0) + 1);
        }
        Set<String> visited = new HashSet<>();
        int total = 0;
        for (Map.Entry<String, Integer> e : locationMap.entrySet()) {
            String key = e.getKey();
            if (visited.contains(key)) {
                continue;
            }
            int count = e.getValue();
            String complement = key.substring(2) + key.substring(0, 2);
            if (locationMap.containsKey(complement)) {
                total += count * locationMap.get(complement);
                visited.add(complement);
            }
        }
        out.println(total);
        out.close();
        br.close();
    }
}
