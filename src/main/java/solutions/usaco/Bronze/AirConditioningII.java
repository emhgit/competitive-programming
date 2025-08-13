package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class Main {
    static int[] cows;
    static int[] curr;
    static AC[] acs;
    static int cost = Integer.MAX_VALUE, currCost = 0;
    static int N, M;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cows = new int[101];
        curr = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int amt = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                cows[j] -= amt;
            }
        }
        acs = new AC[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int amt = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            acs[i] = new AC(start, end, amt, cost);
        }
        search();
        out.println(cost);
        
        br.close();
        out.flush();
        out.close();
    }

    static void search() {
        boolean valid = true;
        for (int i = 1; i <= 100; i++) {
            if (curr[i] > cows[i]) {
                valid = false;
                break;
            }
        }
        if (valid) {
            cost = Math.min(cost, currCost);
            return;
        }
        for (int i = 0; i < M; i++) {
            if (acs[i].active)
                continue;
            if (currCost + acs[i].cost > cost)
                continue;
            acs[i].active = true;
            currCost += acs[i].cost;
            for (int j = acs[i].start; j <= acs[i].end; j++) {
                curr[j] -= acs[i].amt;
            }
            search();
            acs[i].active = false;
            currCost -= acs[i].cost;
            for (int j = acs[i].start; j <= acs[i].end; j++) {
                curr[j] += acs[i].amt;
            }
        }
          
    }

    static class AC {
        int start, end, amt, cost;
        boolean active;

        public AC (int start, int end, int amt, int cost) {
            this.start = start;
            this.end = end;
            this.amt = amt;
            this.cost = cost;
            this.active = false;
        }
    }
}
