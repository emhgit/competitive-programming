package solutions.utdbobspringnovice2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NearPerfect {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = 0, s = 0, c = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long score = Long.parseLong(st.nextToken());
            long k = (long) Math.sqrt(score);
            // adjust k so that k*k ≤ score < (k+1)*(k+1)
            while ((k + 1) * (k + 1) <= score)
                k++;
            while (k * k > score)
                k--;

            // exact square?
            long diffLo = score - k * k;
            if (diffLo == 0) {
                p++;
            } else {
                // distance to next square above
                long diffHi = (k + 1) * (k + 1) - score;
                if (diffLo <= t || diffHi <= t) {
                    s++;
                } else {
                    c++;
                }
            }
        }
        out.println(p + " " + s + " " + c);

        br.close();
        out.flush();
        out.close();
    }
}
