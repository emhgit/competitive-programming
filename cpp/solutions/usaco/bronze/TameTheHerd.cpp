#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N; cin >> N;
    int* logs = new int[N];
    bool valid = true;
    for (int i = 0; i < N; i++) {
        cin >> logs[i];
    }
    if (logs[0] > 0) {
        cout << -1;
        valid = false;
    } else {
        logs[0] = 0;
    }
    int possible = 0, known = 0;
    for (int i = N - 1; i >= 0 && valid; i--) {
        if (i == N - 1) {
            if (logs[i] == -1) {
                possible++;
            } else if (logs[i] == 0) {
                known++;
            }
            continue;
        }
        if (logs[i] != -1 && logs[i + 1] != -1 && logs[i + 1] != 0 && logs[i] != logs[i + 1] - 1) {
            cout << -1;
            valid = false;
            break;
        } else if (logs[i] == -1) {
            if (logs[i + 1] != 0 && logs[i + 1] != -1) {
                logs[i] = logs[i + 1] - 1;
            } else {
                possible++;
            }
        }
        if (logs[i] == 0) {
            known++;
        }
    }
    if (valid) {
        cout << known << " " << known + possible;
    }
    delete[] logs;
}
