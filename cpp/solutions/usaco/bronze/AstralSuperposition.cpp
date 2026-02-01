#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    while (T--) {
        int N; cin >> N;
        int A; cin >> A;
        int B; cin >> B;
        vector<string> grid(N);
        int total = 0;
        for (int i = 0; i < N; i++) {
            cin >> grid[i];
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 'W') {
                    total++;
                }
            }
        }
        if (A == 0 && B == 0) {
            cout << total << "\n";
        } else {
            vector<vector<bool>> in2nd(N, vector<bool>(N));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(in2nd[i][j] || grid[i][j] == 'W') {
                        continue;
                    }
                    if (i + B < N && j + A < N && grid[i+B][j+A] != 'B' && grid[i+B][j+A] != 'W') {
                        in2nd[i+B][j+A] = true;
                    }
                }
            }
            bool valid = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] != 'B') {
                        continue;
                    }
                    if (i - B >= 0 && j - A >= 0 && grid[i-B][j-A] != 'W') {
                        if (in2nd[i-B][j-A]) {
                            in2nd[i-B][j-A] = false;
                        }
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) {
                cout << -1 << "\n";
                continue;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (in2nd[i][j]) {
                        count++;
                    }
                }
            }
            cout << total - count << "\n";
        }
    }
}
