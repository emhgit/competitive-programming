package solutions.hpe2026;

import java.io.*;
import java.util.*;

public class MacawMapping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static char grid[][];
    static char sol[][];
    static int[] xDir = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] yDir = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int N, M;
    static boolean found = false;
    static ArrayList<Pair> poss;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][N];
        sol = new char[N][N];
        poss = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == '.') {
                    poss.add(new Pair(i, j));
                }

            }
        }
        out.flush();

        search(0, 0);

        printBoard(sol);

        out.close();
    }

    static void search(int i, int placed) {
        if (found)
            return;
        if (placed > M || i >= poss.size())
            return;
        if (placed == M) {
            boolean valid = isBoardValid(grid);
            if (valid) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        sol[j][k] = grid[j][k];
                    }
                }
                found = true;
            }
            return;
        }
        int x = poss.get(i).x;
        int y = poss.get(i).y;
        grid[x][y] = 'M';
        boolean valid = true;
        for (int j = 0; j < 8; j++) {
            int row = x + xDir[j];
            int col = y + yDir[j];
            if (inBounds(row, col) && Character.isDigit(grid[row][col]) && !isValid(row, col)) {
                valid = false;
                break;
            }
        }
        if (valid) {
            search(i + 1, placed + 1);
        }
        grid[x][y] = '.';
        search(i + 1, placed);
        grid[x][y] = '.';
    }

    static boolean isValid(int x, int y) {
        int lim = grid[x][y] - '0';
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row = x + xDir[i];
            int col = y + yDir[i];
            if (inBounds(row, col) && grid[row][col] == 'M')
                count++;
        }
        return count <= lim;
    }

    static boolean inBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isBoardValid(char[][] ar) {
        boolean valid = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(grid[i][j])) {
                    int lim = grid[i][j] - '0';
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int row = i + xDir[k];
                        int col = j + yDir[k];
                        if (inBounds(row, col) && grid[row][col] == 'M') {
                            count++;
                        }
                    }
                    if (count != lim) {
                        valid = false;
                        break;
                    }
                }
            }
        }
        return valid;
    }

    static void printBoard(char[][] board) {
        for (char[] row : board) {
            out.println(Arrays.toString(row));
        }
    }
}

class Pair {
    public int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
