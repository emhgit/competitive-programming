package solutions.utdbobspring2025.novice;

import java.io.*;
import java.util.*;

public class LovelyDecryption {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st.nextToken();
        int q = Integer.parseInt(st.nextToken());

        String encryptedMsg = br.readLine();
        String[] hiddenMsgs = new String[q];
        for (int i = 0; i < q; i++)
            hiddenMsgs[i] = br.readLine();
        StringBuilder sb;

        // iterate 26 times to represent each possible shift
        outer: for (int i = 1; i <= 25; i++) {
            sb = new StringBuilder();
            // perform the shift on the encrypted msg
            for (int j = 0; j < n; j++) {
                char cipheredChar = (char) ((encryptedMsg.charAt(j) + i - 'A') % 26 + 'A');
                sb.append(cipheredChar);
            }
            String cipheredStr = sb.toString();
            // if the shifted string is in the hidden msgs, return that str
            for (String hiddenMsg : hiddenMsgs) {
                if (cipheredStr.indexOf(hiddenMsg) != -1) {
                    out.println(cipheredStr);
                    break outer;
                }
            }
        }

        br.close();
        out.flush();
        out.close();
    }
}