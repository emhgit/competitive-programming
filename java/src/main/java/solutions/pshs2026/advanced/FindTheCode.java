package solutions.pshs2026.advanced;

import java.io.*;
import java.util.*;

public class FindTheCode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> hm = new HashMap<>();
        hm.put("M", 1000);
        hm.put("D", 500);
        hm.put("C", 100);
        hm.put("L", 50);
        hm.put("X", 10);
        hm.put("V", 5);
        hm.put("I", 1);
        int a = Integer.parseInt(br.readLine());
        while (a-- > 0) {
            int temp = 0, val = 0;
            StringBuilder t = new StringBuilder(br.readLine());
            t.reverse();
            String s = t.toString();
            while (s.length() > 0) {
                String cur = s.substring(0, 1);
                if ((hm.get(cur) < temp))
                    val -= hm.get(cur);
                else
                    val += hm.get(cur);
                temp = Math.max(temp, hm.get(cur));
                s = s.substring(1);
            }
            out.println(val);
        }
    }
}