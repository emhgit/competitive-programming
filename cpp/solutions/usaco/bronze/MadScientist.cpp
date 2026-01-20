#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    // freopen("breedflip.in", "r", stdin);
    // freopen("breedflip.out", "w", stdout);
    int N; cin >> N;
    string a; cin >> a;
    string b; cin >> b;
    int min = 0;
    for (int i = 0; i < N; i++) {
        int found = 0;
        while (b[i] != a[i]) {
            if (found == 0) {
                found++;
            }
            i++;
        }
        min += found;
    }
    cout << min;
}
