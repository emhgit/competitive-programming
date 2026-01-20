#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
	int N; cin >> N;
    int p[N];
    for (int i = 0; i < N; i++) {
        cin >> p[i];
    }
    int idx = -1;
    for (int i = N - 1; i >= 0; i--) {
        if (i == N - 1) {
            continue;
        }
        if (p[i] > p[i + 1]) {
            idx = i; 
            break;
        }
    }
    int ans = idx == -1 ? 0 : idx + 1;
    cout << ans;
}
