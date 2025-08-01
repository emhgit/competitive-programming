package solutions.cses;

import java.io.*;

public class ChessboardAndQueens {
    static final int BOARD_SIZE = 8;
    static boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];
    static boolean[] visitedRows = new boolean[BOARD_SIZE];
    static boolean[] visitedMinor = new boolean[BOARD_SIZE * 2 - 1];
    static boolean[] visitedMajor = new boolean[BOARD_SIZE * 2 - 1];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < BOARD_SIZE; i++) {
            String row = br.readLine();
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (row.charAt(j) == '*')
                    board[i][j] = true;
            }
        }
        search(0);
        out.println(max);
        br.close();
        out.flush();
        out.close();
    }

    static void search(int c) {
        if (c == BOARD_SIZE) {
            max++;
            return;
        }
        for (int r = 0; r < BOARD_SIZE; r++) {
            // check row
            if (!board[r][c] && !visitedRows[r] && !visitedMinor[r + c] && !visitedMajor[r - c + BOARD_SIZE - 1]) {
                visitedRows[r] = visitedMinor[r + c] = visitedMajor[r - c + BOARD_SIZE - 1] = true;
                search(c + 1);
                visitedRows[r] = visitedMinor[r + c] = visitedMajor[r - c + BOARD_SIZE - 1] = false;
            }
        }
    }
}
