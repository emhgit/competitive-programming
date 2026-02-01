#include <bits/stdc++.h>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    vector<int> a(N);
    int target = -1, direction = 0;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    for (int i = 0; i < N; i++) {
        bool valid = true;
        for (int j = i - 1; j >= 0; j--) {
            if ((i + 1 < N && a[i + 1] < a[j]) || j - 1 >= 0 && a[j - 1] > a[j]) {
                valid = false;
            }
        }
        for (int j = i + 1; j < N; j++) {
            if ((i - 1 < N && a[i - 1] > a[j]) ||j + 1 < N && a[j + 1] < a[j]) {
                valid = false;
            }
        }
        if (valid) {
            target = i;
            direction = (i + 1 < N && a[i + 1] < a[i]) ? 1 : - 1;
            break;
        }
    }
    int swaps = 0;
    if (target == -1) {
        cout << swaps;
        return 0;
    }
    for (int i = target + direction; i >= 0 && i < N; i += direction) {
        if (direction == -1 && a[i] > a[target]) {
            swaps++;
            int curr = a[i];
            while (i - 1 >= 0 && a[i - 1] == curr) {
                i--;
            }
        } else if (direction == 1 && a[i] < a[target]) {
            swaps++;
            int curr = a[i];
            while (i + 1 < N && a[i + 1] == curr) {
                i++;
            }
        }
    }
    cout << swaps;
}
