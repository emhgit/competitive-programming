#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N; long long K; cin >> K;
    long long d[N];
    for (int i = 0; i < N; i++) {
        cin >> d[i];
    }
    long long prev = d[0], sum = 0;
    for (int i = 0; i < N; i++) {
        if (i + 1 < N && d[i + 1] - d[i] > K) {
            sum += d[i] - prev + 1 + K;
            prev = d[i + 1];
        } else if (i == N - 1) {
            sum += d[i] - prev + 1 + K;
        }
    }
    cout << sum;
}
