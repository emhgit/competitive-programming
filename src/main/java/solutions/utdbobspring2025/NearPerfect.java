package solutions.utdbobspring2025;

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
            if (Math.abs(Math.sqrt(score) - Math.floor(Math.sqrt(score))) < 1e-12) {
                p++;
            } else if ((Math.sqrt(score + t) > Math.ceil(Math.sqrt(score)) - 1e-12)
                    || (Math.sqrt(score - t) < Math.floor(Math.sqrt(score)) + 1e-12)) {
                s++;
            } else
                c++;
        }
        out.println(p + " " + s + " " + c);

        br.close();
        out.flush();
        out.close();
    }
}
