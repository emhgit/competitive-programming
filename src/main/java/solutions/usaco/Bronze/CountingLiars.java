package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class CountingLiars {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Statement[] statements = new Statement[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            statements[i] = new Statement(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(statements, (a, b) -> Integer.compare(a.position, b.position));
        int[] leftLiars = new int[n];
        for (int i = 1; i < n; i++) {
            leftLiars[i] += leftLiars[i - 1];
            if (statements[i - 1].operator.equals("L")) {
                leftLiars[i]++;
            }
        }
        int[] rightLiars = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightLiars[i] += rightLiars[i + 1];
            if (statements[i + 1].operator.equals("G")) {
                rightLiars[i]++;
            }
        }
        int minLying = n;
        for (int i = 0; i < n; i++) {
            minLying = Math.min(minLying, leftLiars[i] + rightLiars[i]);
        }
        out.println(minLying);
        br.close();
        out.flush();
        out.close();
    }

    static class Statement {
        String operator;
        int position;

        public Statement(String operator, int position) {
            this.operator = operator;
            this.position = position;
        }
    }
}