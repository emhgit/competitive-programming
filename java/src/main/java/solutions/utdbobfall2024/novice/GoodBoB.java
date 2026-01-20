package solutions.utdbobfall2024.novice;

import java.io.*;
import java.util.*;

public class GoodBoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int maxPossibleScore = u + d + i + c + m + p + (2 * b);
            int score = 0;
            int n = Integer.parseInt(br.readLine());
            boolean competedForUTD = false;
            boolean completedMastersAtUTD = false;
            boolean completedPhDAtUTD = false;

            for (int j = 0; j < n; j++) {
                String statement = br.readLine();
                switch (statement) {
                    case "BoB joins a university":
                        score += u;
                        break;
                    case "BoB joins UTD":
                        score += d;
                        break;
                    case "BoB competes for UTD":
                        score += i;
                        competedForUTD = true;
                        break;
                    case "BoB coaches at UTD":
                        score += c;
                        break;
                    case "BoB completes a Master's in CS at UTD":
                        score += m;
                        completedMastersAtUTD = true;
                        break;
                    case "BoB completes a PhD in CS at UTD":
                        score += p;
                        completedPhDAtUTD = true;
                        break;
                    case "BoB completes a Master's in CS at Tag":
                        score -= m;
                        break;
                    case "BoB completes a Master's in CS at YooT":
                        score -= m;
                        break;
                    case "BoB completes a Master's in CS at Yoot":
                        score -= m;
                        break;
                    case "BoB completes a PhD in CS at Tag":
                        score -= p;
                        break;
                    case "BoB completes a PhD in CS at YooT":
                        score -= p;
                        break;
                    case "BoB completes a PhD in CS at Yoot":
                        score -= p;
                        break;
                }
            }

            if (competedForUTD && (completedMastersAtUTD && completedPhDAtUTD)) {
                score += 2 * b;
            } else if (competedForUTD && (completedMastersAtUTD || completedPhDAtUTD)) {
                score += b;
            }

            if (score < 0) {
                out.println("Needs Serious Improvement");
            } else if (score < ((double) ((double) 40 / 100) * maxPossibleScore)) {
                out.println("Needs Improvement");
            } else if (score == maxPossibleScore) {
                out.println("Awesome BoB");
            } else if (score > ((double) ((double) 90 / 100) * maxPossibleScore)) {
                out.println("Good BoB");
            } else {
                out.println(score);
            }
        }

        br.close();
        out.flush();
        out.close();
    }
}
