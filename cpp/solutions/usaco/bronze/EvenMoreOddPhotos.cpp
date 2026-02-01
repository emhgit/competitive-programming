#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    int even = 0, odd = 0;
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        if (a % 2 == 0) {
            even++;
        } else {
            odd++;
        }
    }
    while (odd > even) {
        odd -= 2;
        even++;
    }
    if (even > odd + 1) {
        even = odd + 1;
    }
    cout << even + odd;
}
