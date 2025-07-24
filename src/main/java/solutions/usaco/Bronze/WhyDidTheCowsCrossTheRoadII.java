package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class WhyDidTheCowsCrossTheRoadII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String paths = br.readLine();
        Stack<Character> visited = new Stack<>();
        for (int i = 0; i < paths.length(); i++) {
            if (!visited.isEmpty()) {
                if (visited.contains(paths.charAt(i))) {
                    while (!visited.isEmpty() && visited.peek() != paths.charAt(i))
                        visited.pop();
                    if (!visited.isEmpty() && visited.peek() == paths.charAt(i))
                        visited.pop();
                } else {
                    visited.push(paths.charAt(i));
                }
            } else {
                visited.push(paths.charAt(i));
            }
        }
        out.println(visited.size());

        br.close();
        out.flush();
        out.close();
    }
}
