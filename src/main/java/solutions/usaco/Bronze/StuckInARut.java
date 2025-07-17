package solutions.usacoguide.Bronze;

import java.io.*;
import java.util.*;

public class StuckInARut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Cow> northCows = new ArrayList<>();
        List<Cow> eastCows = new ArrayList<>();
        Cow[] cows = new Cow[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char direction = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(direction, x, y, i);
            if (direction == 'N') {
                northCows.add(cows[i]);
            } else {
                eastCows.add(cows[i]);
            }
        }

        // Sort north cows by x, east cows by y
        northCows.sort(Comparator.comparingInt(c -> c.x));
        eastCows.sort(Comparator.comparingInt(c -> c.y));

        int[] stopPos = new int[n];
        Arrays.fill(stopPos, -1);

        for (Cow ncow : northCows) {
            for (Cow ecow : eastCows) {
                if (ncow.x > ecow.x && ncow.y < ecow.y) {
                    int nTrav = ecow.y - ncow.y;
                    int eTrav = ncow.x - ecow.x;

                    if (nTrav < eTrav && stopPos[ecow.id] == -1) {
                        if (stopPos[ncow.id] == -1 || stopPos[ncow.id] >= ecow.y) {
                            stopPos[ecow.id] = ncow.x;
                        }
                    } else if (nTrav > eTrav && stopPos[ecow.id] == -1) {
                        if (stopPos[ncow.id] == -1) {
                            stopPos[ncow.id] = ecow.y;
                            break;
                        }
                    }
                }
            }
        }

        for (Cow cow : cows) {
            if (cow.direction == 'N') {
                out.println(stopPos[cow.id] == -1 ? "Infinity" : stopPos[cow.id] - cow.y);
            } else {
                out.println(stopPos[cow.id] == -1 ? "Infinity" : stopPos[cow.id] - cow.x);
            }
        }

        br.close();
        out.flush();
        out.close();
    }

    static class Cow {
        char direction;
        int x, y, id;

        public Cow(char direction, int x, int y, int id) {
            this.direction = direction;
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }
}