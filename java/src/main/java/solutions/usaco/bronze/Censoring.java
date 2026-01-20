package solutions.usaco.bronze;

import java.io.*;

public class Censoring {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("java/src/input/censor.in"));
            out = new PrintWriter(new FileWriter("java/src/output/censor.out"));
        } else {
            br = new BufferedReader(new FileReader("censor.in"));
            out = new PrintWriter(new FileWriter("censor.out"));
        }

        String s = br.readLine();
        String t = br.readLine();

        StringBuilder censored = new StringBuilder();
        censored.append(s.substring(0, t.length() - 1));

        for (int i = t.length() - 1; i < s.length(); i++) {
            censored = censored.append(s.charAt(i));

            if (censored.length() >= t.length()) {
                String check = censored.substring(censored.length() - t.length());
                if (check.equals(t))
                    censored.delete(censored.length() - t.length(), censored.length());
            }
        }
        out.println(censored.toString());

        br.close();
        out.flush();
        out.close();
    }
}