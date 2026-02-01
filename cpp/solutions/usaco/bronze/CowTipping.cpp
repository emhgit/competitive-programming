#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    vector<vector<int>> grid(N, vector<int>(N));
    for (int i = 0; i < N; i++) {
        string s; cin >> s;
        for (int j = 0; j < N; j++) {
            grid[i][j] = s[j] - '0';
        }
    }
    int count = 0;
    for (int i = N - 1; i >= 0; i--) {
        for (int j = N - 1; j >= 0; j--) {
            if (grid[i][j] == 1) {
                count++;
                for (int r = i; r >= 0; r--) {
                    for (int c = j; c >= 0; c--) {
                        grid[r][c] = grid[r][c] == 1 ? 0 : 1;
                    }
                }
            }
        }
    }
    cout << count;
}
